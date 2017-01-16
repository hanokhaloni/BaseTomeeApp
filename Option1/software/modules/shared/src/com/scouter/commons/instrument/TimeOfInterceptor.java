/**
 * Created by IntelliJ IDEA.
 * User: Aviram Dayan
 * Date: 16/02/13
 * Time: 16:56
 *
 *<a href=mailto:avdayan@cs.bgu.ac.il>avdayan@cs.bgu.ac.il</a>
 */
package com.scouter.commons.instrument;

import org.apache.openejb.util.LogCategory;
import org.apache.openejb.util.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.lang.reflect.Method;

@Interceptor
@TimeOf
public class TimeOfInterceptor implements Serializable {

    private static final Logger LOGGER = Logger.getInstance(LogCategory.OPENEJB_STARTUP_CONFIG, TimeOfInterceptor.class);

    @AroundInvoke
    public Object logMethod(InvocationContext ctx) throws Exception {
        Method method = ctx.getMethod();
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        long start = System.currentTimeMillis();
        Object res = ctx.proceed();
        long time = System.currentTimeMillis() - start;
        LOGGER.info("Time took for " + className + '.' + methodName + ": " + time + " millis.");
        return res;
    }
}