package com.scouter.services.entrypoint;

import com.scouter.commons.appVo.AppGetMessages;

import java.util.List;

public interface MessagesService<C> {

    List<AppGetMessages> getMessages(C c, int offset, int count, String search);

}
