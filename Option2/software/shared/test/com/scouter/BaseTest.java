package com.scouter;

import com.scouter.commons.util.CommonUtils;
import com.scouter.commons.util.JvmParams;
import org.apache.openejb.util.LogCategory;
import org.apache.openejb.util.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.InitialContext;
import java.util.concurrent.Callable;

public abstract class BaseTest {

    private static final Logger LOGGER = Logger.getInstance(LogCategory.OPENEJB_STARTUP_CONFIG, BaseTest.class);

    protected InitialContext initialContext;

    @BeforeClass
    public void before() throws Exception {
        parseVMArgs();

        EJBContainer.createEJBContainer().getContext().bind("inject", this);
        initialContext = CommonUtils.getInitialContext();
    }

    @AfterClass
    public void after() throws Exception {
        if (initialContext != null) {
            initialContext.close();
        }
    }

    private void parseVMArgs(){
        JvmParams annotation = getClass().getAnnotation(JvmParams.class);
        if (annotation == null)
            return;

        String[] params = annotation.jvmParam();
        for (String param : params) {
            String[] keyVal = param.split("=");
            if (keyVal.length != 2){
                LOGGER.warning("VM arg " + param + " is not length 2.");
                continue;
            }

            String key = keyVal[0].trim();
            String val = keyVal[1].trim();

            String checkingVal = System.getProperty(key);
            if (checkingVal != null){
                LOGGER.info("System property " + key + " already exist: " + checkingVal);
                continue;
            }

            LOGGER.info("Setting system property " + key + '=' + val);
            System.setProperty(key, val);
        }
    }

    @EJB(name = "AdminBean")
    private Caller admin;

    protected abstract class TestAs<U> {

        public void testAsAdmin() throws Exception {
            admin.call(new Callable() {
                public U call() throws Exception {
                    return doTest();
                }
            });
        }

        protected abstract U doTest();
    }

    public static interface Caller<U> {
        public U call(Callable<U> callable) throws Exception;
    }

    @Stateless
    @RunAs("admin")
    public static class AdminBean<U> implements Caller<U> {
        public U call(Callable<U> callable) throws Exception {
            return callable.call();
        }
    }
}