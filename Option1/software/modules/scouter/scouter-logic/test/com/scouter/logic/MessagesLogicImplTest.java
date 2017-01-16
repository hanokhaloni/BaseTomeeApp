package com.scouter.logic;

import com.scouter.BaseTest;
import com.scouter.commons.appVo.AppGetMessages;
import com.scouter.commons.util.JvmParams;
import org.testng.annotations.Test;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import java.util.List;

import static org.testng.Assert.assertNotNull;


@JvmParams(jvmParam = {
        "openejb.home=../../build/openejb",
        "properties.mode=DEVELOP",
        "conf.dir=build/config",
        "root.dir=.."
})
@ManagedBean
public class MessagesLogicImplTest extends BaseTest {

    @EJB
    private MessagesLogic messagesLogic;

    @Test
    public void testGetMessages() throws Exception {
        List<AppGetMessages> messages = messagesLogic.getMessages(null, 1, 1, null);
        assertNotNull(messages);
    }

}