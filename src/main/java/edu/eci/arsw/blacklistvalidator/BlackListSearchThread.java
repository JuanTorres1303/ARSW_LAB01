package edu.eci.arsw.blacklistvalidator;

import java.util.LinkedList;
import java.util.List;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class BlackListSearchThread extends Thread {

    private final HostBlacklistsDataSourceFacade skds;
    private final String ipaddress;
    private final int startIndex;
    private final int endIndex;

    private final LinkedList<Integer> ocurrencesFound = new LinkedList<>();
    private int checkedCount = 0;

    public BlackListSearchThread(String name, HostBlacklistsDataSourceFacade skds, String ipaddress,
            int startIndex, int endIndex) {
        super(name);
        this.skds = skds;
        this.ipaddress = ipaddress;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.println(getName() + " -> INICIA. Rango asignado: [" + startIndex + ", " + endIndex + ")");

        for (int i = startIndex; i < endIndex; i++) {
            checkedCount++;
            if (skds.isInBlackListServer(i, ipaddress)) {
                ocurrencesFound.add(i);
                System.out.println(getName() + " -> encontró ocurrencia en la lista #" + i);
            }
        }

        System.out.println(getName() + " -> TERMINA. Revisó " + checkedCount +
                " listas, encontró " + ocurrencesFound.size() + " ocurrencias.");
    }

    public int getOcurrencesCount() {
        return ocurrencesFound.size();
    }

    public List<Integer> getOcurrences() {
        return ocurrencesFound;
    }

    public int getCheckedCount() {
        return checkedCount;
    }
}
