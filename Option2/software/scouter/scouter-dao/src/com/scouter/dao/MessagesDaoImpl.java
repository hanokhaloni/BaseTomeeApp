package com.scouter.dao;

import com.scouter.commons.appVo.AppGetMessages;
import com.scouter.commons.util.ScouterLogger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessagesDaoImpl implements MessagesDao {

    @Override
    public List<AppGetMessages> getMessages(EntityManager entityManager, int offset, int count, String search, String role) {
        ScouterLogger.printLog("MessagesDaoImpl", "getMessages");

        String countAndOffestQuery = " LIMIT " + count + " OFFSET " + offset;
        if (offset == 0 && count == 0) {
            countAndOffestQuery = ""; //if offset=0 and count=0 return all messages
        }

        String searchQuery = "";
        if (search != null && !search.equals("")){
            searchQuery = " AND m.name LIKE '%" + search + "%'";
        }

        String queryString = "SELECT DISTINCT m.id, m.name, m.messages_status, m.expiration_time, mc.client_id," +
            " mv.is_medium_viewed, m.created_at, m.updated_at" +
            " FROM (SELECT DISTINCT * FROM messages ORDER BY created_at DESC" + countAndOffestQuery + ") AS m" +
            " LEFT JOIN message_client mc" +
            " ON m.id = mc.message_id" +
            " LEFT JOIN media_viewed mv" +
            " ON mc.client_id = mv.client_id" +
            " WHERE m.role = '" + role + "'" +
            searchQuery +
            " ORDER BY m.id DESC";

        Query query = entityManager.createNativeQuery(queryString);
        List<AppGetMessages> messagesList = convertObjectToGetMessages(query.getResultList(), entityManager);

        return messagesList;
    }

    private List<AppGetMessages> convertObjectToGetMessages(List<Object> rawMessages, EntityManager entityManager) {

        List<AppGetMessages> messagesList = new ArrayList<>();
        List<Integer> msgIdsAlreadyVisited = new ArrayList<>();

        for (Object rawMessage: rawMessages) {
            Object[] rawMessageArray = (Object[]) rawMessage;
            if (!msgIdsAlreadyVisited.contains(rawMessageArray[0])){//New MessageId

                AppGetMessages message = new AppGetMessages();
                message.setNumberOfClients(0);
                message.setNumberOfClientsViewedMessage(0);
                message.setMessageId((Integer) rawMessageArray[0]);
                message.setMessageName((String) rawMessageArray[1]);
                message.setStatus((int) rawMessageArray[2]);
                message.setExpirationTime((Date) rawMessageArray[3]);
                if (message.getCreatedAt() == null) {
                    message.setCreatedAt((Date) rawMessageArray[6]);
                }
                message.setUpdatedAt((Date) rawMessageArray[7]);
                msgIdsAlreadyVisited.add((Integer) rawMessageArray[0]);
                messagesList.add(message);
            }

        }
        return messagesList;
    }

}
