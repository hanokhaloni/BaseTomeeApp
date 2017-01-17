package com.scouter.dao;

import com.scouter.commons.appVo.AppGetMessages;

import javax.persistence.EntityManager;
import java.util.List;

public interface MessagesDao {

    List<AppGetMessages> getMessages(EntityManager entityManager, int offset, int count, String search, String role);

}
