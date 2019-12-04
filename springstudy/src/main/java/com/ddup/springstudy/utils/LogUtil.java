package com.ddup.springstudy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/11/16
 */
public class LogUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger("SpringTest");

    public static Logger getLogger() {
        return LOGGER;
    }
}
