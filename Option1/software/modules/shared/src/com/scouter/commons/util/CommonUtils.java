package com.scouter.commons.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class CommonUtils {

    public static InitialContext getInitialContext() throws NamingException {
        Properties p = new Properties();
        p.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.core.LocalInitialContextFactory");
        p.setProperty(Context.PROVIDER_URL, "http://127.0.0.1:4204/openejb/ejb");
        p.setProperty("openejb.embedded.initialcontext.close", "destroy");
        /*p.setProperty(Context.SECURITY_PRINCIPAL, "agency-1-agent-1");
        p.setProperty(Context.SECURITY_CREDENTIALS, "e10adc3949ba59abbe56e057f20f883e");
        p.setProperty("openejb.authentication.realmName", "SQLLogin");*/

        return new InitialContext(p);
    }
}