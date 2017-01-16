package com.scouter.commons.services;

import com.scouter.commons.GenericException;
import org.apache.openejb.util.LogCategory;
import org.apache.openejb.util.Logger;
import javax.ejb.EJBAccessException;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<EJBException> {

    private static final Logger LOGGER = Logger.getInstance(LogCategory.OPENEJB_STARTUP_CONFIG, ExceptionHandler.class);
    private static final int EC_UNKNOWN = GenericException.ERROR_CODE.EC_UNKNOWN.getErrorCode();

    @Override
    public Response toResponse(EJBException ge) {
        LOGGER.error("Caught an exception during a REST request.", ge);
        Throwable cause = ge.getCause();
        int errorCode = EC_UNKNOWN;
        int httpStatus = 500;
        if (cause == null){
            cause = ge;
        }
        if (cause instanceof EJBAccessException)
            return Response.serverError().entity("Action is not allowed").status(403).build();//TODO ask aviram

        if (cause instanceof GenericException) {
            errorCode = ((GenericException) cause).getErrorCode();
            httpStatus = ((GenericException) cause).getHttpStatus();
        }
        if (cause instanceof EJBTransactionRolledbackException) {
            if (cause.getCause() != null && cause.getCause() instanceof GenericException) {
                cause = cause.getCause();
                errorCode = ((GenericException) cause).getErrorCode();
                httpStatus = ((GenericException) cause).getHttpStatus();
            }
        }

        return Response.serverError().entity("Error, see log file for more information, " + " CODE:" + errorCode).status(httpStatus).build();
    }
}