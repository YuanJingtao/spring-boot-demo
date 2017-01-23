package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LogHelper
 *
 * @author YuanJingtao
 * @version 1.0
 * @date 2017-01-23 17:31
 */
public class LogHelper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void helpMethod(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
    }
}