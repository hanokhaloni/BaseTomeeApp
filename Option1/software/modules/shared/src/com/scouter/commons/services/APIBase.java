package com.scouter.commons.services;

import com.google.gson.Gson;
import org.apache.openejb.util.LogCategory;
import org.apache.openejb.util.Logger;
import javax.naming.*;
import java.util.HashMap;
import java.util.Map;

public abstract class APIBase<F> {

    private static final Logger LOGGER = Logger.getInstance(LogCategory.OPENEJB_STARTUP_CONFIG, APIBase.class);

    protected F facade;

    @SuppressWarnings("unchecked")
    public APIBase() {
        try {

            InitialContext initialContext = new InitialContext();
            LOGGER.info(new Gson().toJson(toMap(initialContext)));
            facade = (F) initialContext.lookup(getFacadeJndiName());
        } catch (NamingException e) {
            LOGGER.error("Fail to lookup for " + getFacadeJndiName(), e);
        }
    }

    protected abstract String getFacadeJndiName();


    public static Map toMap(Context ctx) throws NamingException {
        String namespace = ctx instanceof InitialContext ? ctx.getNameInNamespace() : "";
        HashMap<String, Object> map = new HashMap<String, Object>();
        LOGGER.info("> Listing namespace: " + namespace);
        NamingEnumeration<NameClassPair> list = ctx.list(namespace);
        while (list.hasMoreElements()) {
            NameClassPair next = list.next();
            String name = next.getName();
            String jndiPath = namespace + name;
            Object lookup;
            try {
                LOGGER.info("> Looking up name: " + jndiPath);
                Object tmp = ctx.lookup(jndiPath);
                if (tmp instanceof Context) {
                    lookup = toMap((Context) tmp);
                } else {
                    lookup = tmp.toString();
                }
            } catch (Throwable t) {
                lookup = t.getMessage();
            }
            map.put(name, lookup);

        }
        return map;
    }


}