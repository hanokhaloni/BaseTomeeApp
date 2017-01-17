package com.scouter.commons.services;

import org.apache.openejb.util.LogCategory;
import org.apache.openejb.util.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


public class ServicesContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getInstance(LogCategory.OPENEJB_STARTUP_CONFIG, ServicesContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        unRegisterSqlDrivers();
    }

    private void unRegisterSqlDrivers() {
        /*
        DriverManager, the service provider mechanism and memory leaks:
        <a>http://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html</a>
         */
        LOGGER.info("Un-registering SQL drivers");
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            String driverData = driver.toString();
            LOGGER.info("Un-registering SQL driver " + driverData);
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                LOGGER.error("Can't un-register SQL driver " + driverData, e);
            }
        }
    }
}