package com.example.library.testlog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Demo {
    private static Log logger = LogFactory.getLog(Demo.class);

    public static void main(String[] args) {
        logger.info("jcl");
    }
}
