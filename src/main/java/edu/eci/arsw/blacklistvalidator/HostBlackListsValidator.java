/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

/**
 *
 * @author hcadavid
 */
public class HostBlackListsValidator {

    private static final int BLACK_LIST_ALARM_COUNT = 5;

    /**
     * Check the given host's IP address in all the available black lists,
     * splitting the search among N threads, and report it as NOT Trustworthy
     * when it was found in at least BLACK_LIST_ALARM_COUNT lists, or as
     * Trustworthy otherwise.
     *
     * @param ipaddress suspicious host's IP address.
     * @param N         number of threads to split the search among.
     * @return Blacklists numbers where the given host's IP address was found.
     */
    public List<Integer> checkHost(String ipaddress, int N) {

        HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();

        int totalServers = skds.getRegisteredServersCount();
        int baseChunk = totalServers / N;
        int remainder = totalServers % N;

        List<BlackListSearchThread> threads = new LinkedList<>();

        int start = 0;
        for (int i = 0; i < N; i++) {
            int extra = (i < remainder) ? 1 : 0;
            int end = start + baseChunk + extra;
            BlackListSearchThread t = new BlackListSearchThread("Hilo-" + i, skds, ipaddress, start, end);
            threads.add(t);
            start = end;
        }

        for (BlackListSearchThread t : threads) {
            t.start();
        }

        for (BlackListSearchThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        LinkedList<Integer> blackListOcurrences = new LinkedList<>();
        int ocurrencesCount = 0;
        int checkedListsCount = 0;

        for (BlackListSearchThread t : threads) {
            blackListOcurrences.addAll((Collection<? extends Integer>) t.getOcurrences());
            ocurrencesCount += t.getOcurrencesCount();
            checkedListsCount += t.getCheckedCount();
        }

        if (ocurrencesCount >= BLACK_LIST_ALARM_COUNT) {
            skds.reportAsNotTrustworthy(ipaddress);
        } else {
            skds.reportAsTrustworthy(ipaddress);
        }

        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}",
                new Object[] { checkedListsCount, totalServers });

        return blackListOcurrences;
    }

    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
}
