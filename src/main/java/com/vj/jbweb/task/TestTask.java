package com.vj.jbweb.task;


import java.util.logging.Logger;
import java.util.logging.Level;

public class TestTask implements Runnable{

    private final static Logger LOGGER = Logger.getLogger(TestTask.class.getName());

    @Override
    public void run() {
        LOGGER.log(Level.INFO,"**** In Test Task *****");
    }
}
