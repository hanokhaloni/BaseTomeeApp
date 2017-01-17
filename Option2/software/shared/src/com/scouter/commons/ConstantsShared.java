package com.scouter.commons;

public class ConstantsShared {
    private static final String JNDI_APP_NAME = System.getProperty("ejb.jndi.name.app");
    private static final String JNDI_APP_NAME_STR = JNDI_APP_NAME == null || JNDI_APP_NAME.isEmpty() ? "" : JNDI_APP_NAME + '/';
    private static final String JNDI_MODULE_NAME = System.getProperty("ejb.jndi.name.scouter.module");
    private static final String JNDI_APP_MODULE_STR = JNDI_MODULE_NAME == null || JNDI_MODULE_NAME.isEmpty() ? "" : JNDI_MODULE_NAME + '/';

    public enum ClassNames {

        ALERTS_GATE_WAY("AlertLogicImpl");

        private final String text;

        ClassNames(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public static final String EJB_JNDI_MESSAGES_FACADE = "java:global/" + JNDI_APP_NAME_STR + JNDI_APP_MODULE_STR + "MessagesLogicImpl";

    private static String getJNDI(ClassNames className) {
        return "java:global/" + JNDI_APP_NAME_STR + JNDI_APP_MODULE_STR + className.toString();
    }

}
