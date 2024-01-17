package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "audit_trails", schema = "public", catalog = "dms")
public class AuditTrail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "event_name", nullable = false, length = 30)
    private String eventName;
    @Basic
    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;
    @Basic
    @Column(name = "time_stamp", nullable = true)
    private Timestamp timeStamp;
    @Basic
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @Column(name = "acl_name", nullable = false, length = 30)
    private String aclName;
    @ManyToOne
    @JoinColumn(name = "content_object", referencedColumnName = "id", nullable = false)
    private ContentObject contentObject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAclName() {
        return aclName;
    }

    public void setAclName(String aclName) {
        this.aclName = aclName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AuditTrail that = (AuditTrail) object;
        return Objects.equals(id, that.id) && Objects.equals(eventName, that.eventName) && Objects.equals(userName, that.userName) && Objects.equals(timeStamp, that.timeStamp) && Objects.equals(description, that.description) && Objects.equals(name, that.name) && Objects.equals(aclName, that.aclName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, userName, timeStamp, description, name, aclName);
    }

    public ContentObject getContentObject() {
        return contentObject;
    }

    public void setContentObject(ContentObject contentObject) {
        this.contentObject = contentObject;
    }
}
