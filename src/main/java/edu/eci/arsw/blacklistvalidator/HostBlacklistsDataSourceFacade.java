package edu.eci.arsw.blacklistvalidator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HostBlacklistsDataSourceFacade {

    private static final int SERVERS_COUNT = 3000;

    private static final HostBlacklistsDataSourceFacade instance = new HostBlacklistsDataSourceFacade();

    private final ConcurrentHashMap<String, String> localDB = new ConcurrentHashMap<>();

    private HostBlacklistsDataSourceFacade() {
    }

    public static HostBlacklistsDataSourceFacade getInstance() {
        return instance;
    }

    public int getRegisteredServersCount() {
        return SERVERS_COUNT;
    }

    public boolean isInBlackListServer(int blserverIndex, String host) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        switch (host) {
            case "200.24.34.55":

                return blserverIndex < 10;

            case "202.24.34.55":

                return blserverIndex % 550 == 0;

            case "212.24.24.55":

                return false;

            default:

                return (host.hashCode() + blserverIndex) % 700 == 0;
        }
    }

    public void reportAsTrustworthy(String host) {
        localDB.put(host, "trustworthy");
        LOG.log(Level.INFO, "HOST {0} Reported as trustworthy", host);
    }

    public void reportAsNotTrustworthy(String host) {
        localDB.put(host, "not-trustworthy");
        LOG.log(Level.INFO, "HOST {0} Reported as NOT trustworthy", host);
    }

    private static final Logger LOG = Logger.getLogger(HostBlacklistsDataSourceFacade.class.getName());
}