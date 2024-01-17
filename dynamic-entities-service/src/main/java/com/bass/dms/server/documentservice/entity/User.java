package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "dms")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "user_id", nullable = false, length = 30)
    private String userId;
    @Basic
    @Column(name = "password", nullable = true, length = 30)
    private String password;
    @Basic
    @Column(name = "full_name", nullable = false, length = 60)
    private String fullName;
    @Basic
    @Column(name = "initials", nullable = true, length = 3)
    private String initials;
    @Basic
    @Column(name = "description", nullable = true, length = 300)
    private String description;
    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Basic
    @Column(name = "acl_recordid", nullable = false)
    private Integer aclRecordid;
    @Basic
    @Column(name = "default_folder", nullable = true, length = 100)
    private String defaultFolder;
    @Basic
    @Column(name = "last_login_utc_time", nullable = false)
    private Timestamp lastLoginUtcTime;
    @Basic
    @Column(name = "user_state", nullable = false, length = 30)
    private String userState;
    @Basic
    @Column(name = "client_capability", nullable = false)
    private Integer clientCapability;
    @Basic
    @Column(name = "privilage", nullable = false)
    private Integer privilage;
    @Basic
    @Column(name = "disable_workflow", nullable = false)
    private Boolean disableWorkflow;
    @Basic
    @Column(name = "disable_auth_failure", nullable = false)
    private Boolean disableAuthFailure;
    @Basic
    @Column(name = "user_source", nullable = false, length = 30)
    private String userSource;
    @OneToMany(mappedBy = "user")
    private Collection<Comment> comments;
    @OneToMany(mappedBy = "user")
    private Collection<Favorite> favorites;
    @OneToMany(mappedBy = "user")
    private Collection<GroupMember> groupMembers;
    @OneToMany(mappedBy = "owner")
    private Collection<Group> Owners;
    @OneToMany(mappedBy = "groupAdmin")
    private Collection<Group> groupAdmins;
    @OneToMany(mappedBy = "user")
    private Collection<Notification> notifications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAclRecordid() {
        return aclRecordid;
    }

    public void setAclRecordid(Integer aclRecordid) {
        this.aclRecordid = aclRecordid;
    }

    public String getDefaultFolder() {
        return defaultFolder;
    }

    public void setDefaultFolder(String defaultFolder) {
        this.defaultFolder = defaultFolder;
    }

    public Timestamp getLastLoginUtcTime() {
        return lastLoginUtcTime;
    }

    public void setLastLoginUtcTime(Timestamp lastLoginUtcTime) {
        this.lastLoginUtcTime = lastLoginUtcTime;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public Integer getClientCapability() {
        return clientCapability;
    }

    public void setClientCapability(Integer clientCapability) {
        this.clientCapability = clientCapability;
    }

    public Integer getPrivilage() {
        return privilage;
    }

    public void setPrivilage(Integer privilage) {
        this.privilage = privilage;
    }

    public Boolean getDisableWorkflow() {
        return disableWorkflow;
    }

    public void setDisableWorkflow(Boolean disableWorkflow) {
        this.disableWorkflow = disableWorkflow;
    }

    public Boolean getDisableAuthFailure() {
        return disableAuthFailure;
    }

    public void setDisableAuthFailure(Boolean disableAuthFailure) {
        this.disableAuthFailure = disableAuthFailure;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(id, user.id) && Objects.equals(userId, user.userId) && Objects.equals(password, user.password) && Objects.equals(fullName, user.fullName) && Objects.equals(initials, user.initials) && Objects.equals(description, user.description) && Objects.equals(email, user.email) && Objects.equals(aclRecordid, user.aclRecordid) && Objects.equals(defaultFolder, user.defaultFolder) && Objects.equals(lastLoginUtcTime, user.lastLoginUtcTime) && Objects.equals(userState, user.userState) && Objects.equals(clientCapability, user.clientCapability) && Objects.equals(privilage, user.privilage) && Objects.equals(disableWorkflow, user.disableWorkflow) && Objects.equals(disableAuthFailure, user.disableAuthFailure) && Objects.equals(userSource, user.userSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, password, fullName, initials, description, email, aclRecordid, defaultFolder, lastLoginUtcTime, userState, clientCapability, privilage, disableWorkflow, disableAuthFailure, userSource);
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Collection<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Collection<GroupMember> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Collection<GroupMember> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Collection<Group> getOwners() {
        return Owners;
    }

    public void setOwners(Collection<Group> owners) {
        Owners = owners;
    }

    public Collection<Group> getGroupAdmins() {
        return groupAdmins;
    }

    public void setGroupAdmins(Collection<Group> groupAdmins) {
        this.groupAdmins = groupAdmins;
    }

    public Collection<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Notification> notifications) {
        this.notifications = notifications;
    }
}
