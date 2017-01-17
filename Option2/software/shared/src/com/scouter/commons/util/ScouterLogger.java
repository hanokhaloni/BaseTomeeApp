package com.scouter.commons.util;

import com.scouter.commons.services.APIBase;
import org.apache.openejb.util.LogCategory;
import org.apache.openejb.util.Logger;

public class ScouterLogger {

    private static final Logger LOGGER = Logger.getInstance(LogCategory.OPENEJB_STARTUP_CONFIG, APIBase.class);

    public static void printLog(String moduleName, String serviceName) {
        LOGGER.info("Invoking: " + moduleName + ", " + serviceName);
    }

}