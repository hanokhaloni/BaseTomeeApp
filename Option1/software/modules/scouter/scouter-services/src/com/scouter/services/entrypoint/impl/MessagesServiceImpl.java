package com.scouter.services.entrypoint.impl;

import com.scouter.commons.ConstantsShared;
import com.scouter.commons.appVo.AppGetMessages;
import com.scouter.commons.services.APIBase;
import com.scouter.commons.util.ScouterLogger;
import com.scouter.logic.MessagesLogic;
import com.scouter.services.RestProtocol;
import com.scouter.services.entrypoint.MessagesService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path(RestProtocol.SERVICE_MESSAGES)
public class MessagesServiceImpl extends APIBase<MessagesLogic> implements MessagesService<HttpServletRequest> {

    @Context
    private HttpServletRequest req;

    @Override
    @Path(RestProtocol.REQ_GET_MESSAGES)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AppGetMessages> getMessages(@Context HttpServletRequest request,
                                            @QueryParam(RestProtocol.PARAM_OFFSET) int offset,
                                            @QueryParam(RestProtocol.PARAM_COUNT) int count,
                                            @QueryParam(RestProtocol.PARAM_SEARCH) String search) {
        ScouterLogger.printLog("MessageServiceImpl", "getMessages");
        return facade.getMessages(req, offset, count, search);
    }

    @Override
    protected String getFacadeJndiName() {
        return ConstantsShared.EJB_JNDI_MESSAGES_FACADE;
    }


}
