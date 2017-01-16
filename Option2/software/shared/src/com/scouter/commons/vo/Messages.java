package com.scouter.commons.vo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema="", name="messages")
public class Messages {
    @Id
    @Column(columnDefinition="int identity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(columnDefinition="nvarchar", length=30)
    private String name;

    @Basic
    private int messages_status;

    @Column(name="expiration_time", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date expiration_time;

    @Basic
    @Column(columnDefinition="nvarchar", length=50)
    private String role;

    @Column(name="created_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created_at;

    @Column(name="updated_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updated_at;

    public Messages() {
    }

    public Messages(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationTime() {
        return expiration_time;
    }

    public void setExpirationTime(Date expiration_time) {
        this.expiration_time = expiration_time;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getMessagesStatus() {
        return messages_status;
    }

    public void setMessagesStatus(int messages_status) {
        this.messages_status = messages_status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
