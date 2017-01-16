package com.scouter.commons.appVo;

import java.util.Date;

public class AppGetMessages {

    private int messageId;
    private String messageName;
    private int status;
    private Date expirationTime;
    private int numberOfClients;
    private int numberOfClientsViewedMessage;
    private Date createdAt;
    private Date lastStatusUpdate;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public int getNumberOfClientsViewedMessage() {
        return numberOfClientsViewedMessage;
    }

    public void setNumberOfClientsViewedMessage(int numberOfClientsViewedMessage) {
        this.numberOfClientsViewedMessage = numberOfClientsViewedMessage;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return lastStatusUpdate;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.lastStatusUpdate = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
