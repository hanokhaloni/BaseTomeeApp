package com.scouter.logic;

import com.scouter.commons.appVo.AppGetMessages;
import com.scouter.commons.util.ScouterLogger;
import com.scouter.dao.MessagesDao;
import commons.Constants;
import commons.config.ConfigurationManager;
import org.apache.commons.configuration.Configuration;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Stateless
public class MessagesLogicImpl implements MessagesLogic {

    @PersistenceContext(unitName = "scouter-pu")
    protected EntityManager entityManager;

    @Inject
    private MessagesDao messagesDao;

    Configuration configuration = ConfigurationManager.loadLocalConfiguration("scouter-logic", "Scouter", Constants.FileExt.properties);

    @Override
    public List<AppGetMessages> getMessages(HttpServletRequest request, int offset, int count, String search) {
        ScouterLogger.printLog("MessagesLogicImpl", "getMessages");
        return messagesDao.getMessages(entityManager, offset, count, search, "role");
    }

}
