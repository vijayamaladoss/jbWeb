package com.vj.jbweb.task;


import java.util.logging.Logger;
import java.util.logging.Level;

public class TestTimerTask implements Runnable{

    private final static Logger LOGGER = Logger.getLogger(TestTimerTask.class.getName());

    @Override
    public void run() {
        LOGGER.log(Level.INFO,"**** In Timer Task *****");
    }
}
