package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {
    private Logger() {}

    private static final Logger instance = new Logger();

    public static Logger getInstance() {
        return instance;
    }

    private Map<Long, String> log = new ConcurrentHashMap<>();


    public void setRegister(String register, UUID idUser) {
        log.put(System.nanoTime(), register + " -> " + idUser);
    }

    public Map<Long, String> getLog() {
        return log;
    }


}
