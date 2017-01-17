package com.scouter.logic;

import com.scouter.commons.appVo.AppGetMessages;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MessagesLogic {

    List<AppGetMessages> getMessages(HttpServletRequest request, int offset, int count, String search);

}
