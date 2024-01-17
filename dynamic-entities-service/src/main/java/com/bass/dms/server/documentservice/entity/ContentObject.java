package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "content_objects", schema = "public", catalog = "dms")
public class ContentObject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @Column(name = "title", nullable = true, length = 60)
    private String title;
    @Basic
    @Column(name = "subject", nullable = true, length = 100)
    private String subject;
    @Basic
    @Column(name = "owner_name", nullable = false, length = 30)
    private String ownerName;
    @Basic
    @Column(name = "owner_permit", nullable = false)
    private Integer ownerPermit;
    @Basic
    @Column(name = "acl_creation_type", nullable = false, length = 10)
    private String aclCreationType;
    @Basic
    @Column(name = "is_folder", nullable = false)
    private Boolean isFolder;
    @Basic
    @Column(name = "create_date", nullable = false)
    private Timestamp createDate;
    @Basic
    @Column(name = "modifier", nullable = false, length = 30)
    private String modifier;
    @Basic
    @Column(name = "modify_date", nullable = false)
    private Timestamp modifyDate;
    @Basic
    @Column(name = "group_name", nullable = false, length = 30)
    private String groupName;
    @Basic
    @Column(name = "group_permit", nullable = false)
    private Integer groupPermit;
    @Basic
    @Column(name = "world_permit", nullable = false)
    private Integer worldPermit;
    @Basic
    @Column(name = "page_cnt", nullable = true)
    private Integer pageCnt;
    @Basic
    @Column(name = "content_size", nullable = true)
    private Integer contentSize;
    @Basic
    @Column(name = "is_locked", nullable = false)
    private Boolean isLocked;
    @Basic
    @Column(name = "lock_owner", nullable = true, length = 30)
    private String lockOwner;
    @Basic
    @Column(name = "lock_date", nullable = true)
    private Timestamp lockDate;
    @Basic
    @Column(name = "is_deleted", nullable = true)
    private Boolean isDeleted;
    @Basic
    @Column(name = "status", nullable = true, length = 30)
    private String status;
    @Basic
    @Column(name = "resume_state", nullable = true)
    private Integer resumeState;
    @Basic
    @Column(name = "current_state", nullable = true)
    private Integer currentState;
    @Basic
    @Column(name = "chronicle_id", nullable = false)
    private Integer chronicleId;
    @Basic
    @Column(name = "version_lable", nullable = false, length = 30)
    private String versionLable;
    @Basic
    @Column(name = "version_name", nullable = false, length = 30)
    private String versionName;
    @Basic
    @Column(name = "is_current", nullable = false)
    private Boolean isCurrent;
    @Basic
    @Column(name = "notify_on_read", nullable = true)
    private Boolean notifyOnRead;
    @Basic
    @Column(name = "notify_on_change", nullable = true)
    private Boolean notifyOnChange;
    @OneToMany(mappedBy = "contentObject")
    private Collection<AuditTrail> auditTrails;
    @OneToMany(mappedBy = "contentObject")
    private Collection<Author> authors;
    @OneToMany(mappedBy = "contentObject")
    private Collection<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName = "id", nullable = false)
    private ContentObject parent;
    @OneToMany(mappedBy = "parent")
    private Collection<ContentObject> children;
    @ManyToOne
    @JoinColumn(name = "object_type", referencedColumnName = "id", nullable = false)
    private ObjectType objectType;
    @ManyToOne
    @JoinColumn(name = "acl", referencedColumnName = "id", nullable = false)
    private PermissionSet acl;
    @ManyToOne
    @JoinColumn(name = "lifecycle", referencedColumnName = "id", nullable = false)
    private Lifecycle lifecycle;
    @OneToMany(mappedBy = "contentObject")
    private Collection<Favorite> favorites;
    @OneToMany(mappedBy = "contentObject")
    private Collection<Keyword> keywords;
    @OneToMany(mappedBy = "contentObject")
    private Collection<Notification> notifications;
    @OneToMany(mappedBy = "contentObject")
    private Collection<Rendition> renditions;
    @OneToMany(mappedBy = "content")
    private Collection<Shortcut> shortcutContents;
    @OneToMany(mappedBy = "location")
    private Collection<Shortcut> shortcutLocations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getOwnerPermit() {
        return ownerPermit;
    }

    public void setOwnerPermit(Integer ownerPermit) {
        this.ownerPermit = ownerPermit;
    }

    public String getAclCreationType() {
        return aclCreationType;
    }

    public void setAclCreationType(String aclCreationType) {
        this.aclCreationType = aclCreationType;
    }

    public Boolean getFolder() {
        return isFolder;
    }

    public void setFolder(Boolean folder) {
        isFolder = folder;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupPermit() {
        return groupPermit;
    }

    public void setGroupPermit(Integer groupPermit) {
        this.groupPermit = groupPermit;
    }

    public Integer getWorldPermit() {
        return worldPermit;
    }

    public void setWorldPermit(Integer worldPermit) {
        this.worldPermit = worldPermit;
    }

    public Integer getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(Integer pageCnt) {
        this.pageCnt = pageCnt;
    }

    public Integer getContentSize() {
        return contentSize;
    }

    public void setContentSize(Integer contentSize) {
        this.contentSize = contentSize;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public String getLockOwner() {
        return lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public Timestamp getLockDate() {
        return lockDate;
    }

    public void setLockDate(Timestamp lockDate) {
        this.lockDate = lockDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getResumeState() {
        return resumeState;
    }

    public void setResumeState(Integer resumeState) {
        this.resumeState = resumeState;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    public Integer getChronicleId() {
        return chronicleId;
    }

    public void setChronicleId(Integer chronicleId) {
        this.chronicleId = chronicleId;
    }

    public String getVersionLable() {
        return versionLable;
    }

    public void setVersionLable(String versionLable) {
        this.versionLable = versionLable;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Boolean getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Boolean current) {
        isCurrent = current;
    }

    public Boolean getNotifyOnRead() {
        return notifyOnRead;
    }

    public void setNotifyOnRead(Boolean notifyOnRead) {
        this.notifyOnRead = notifyOnRead;
    }

    public Boolean getNotifyOnChange() {
        return notifyOnChange;
    }

    public void setNotifyOnChange(Boolean notifyOnChange) {
        this.notifyOnChange = notifyOnChange;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ContentObject that = (ContentObject) object;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(title, that.title) && Objects.equals(subject, that.subject) && Objects.equals(ownerName, that.ownerName) && Objects.equals(ownerPermit, that.ownerPermit) && Objects.equals(aclCreationType, that.aclCreationType) && Objects.equals(isFolder, that.isFolder) && Objects.equals(createDate, that.createDate) && Objects.equals(modifier, that.modifier) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(groupName, that.groupName) && Objects.equals(groupPermit, that.groupPermit) && Objects.equals(worldPermit, that.worldPermit) && Objects.equals(pageCnt, that.pageCnt) && Objects.equals(contentSize, that.contentSize) && Objects.equals(isLocked, that.isLocked) && Objects.equals(lockOwner, that.lockOwner) && Objects.equals(lockDate, that.lockDate) && Objects.equals(isDeleted, that.isDeleted) && Objects.equals(status, that.status) && Objects.equals(resumeState, that.resumeState) && Objects.equals(currentState, that.currentState) && Objects.equals(chronicleId, that.chronicleId) && Objects.equals(versionLable, that.versionLable) && Objects.equals(versionName, that.versionName) && Objects.equals(isCurrent, that.isCurrent) && Objects.equals(notifyOnRead, that.notifyOnRead) && Objects.equals(notifyOnChange, that.notifyOnChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, subject, ownerName, ownerPermit, aclCreationType, isFolder, createDate, modifier, modifyDate, groupName, groupPermit, worldPermit, pageCnt, contentSize, isLocked, lockOwner, lockDate, isDeleted, status, resumeState, currentState, chronicleId, versionLable, versionName, isCurrent, notifyOnRead, notifyOnChange);
    }

    public Collection<AuditTrail> getAuditTrails() {
        return auditTrails;
    }

    public void setAuditTrails(Collection<AuditTrail> auditTrails) {
        this.auditTrails = auditTrails;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public ContentObject getParent() {
        return parent;
    }

    public void setParent(ContentObject parent) {
        this.parent = parent;
    }

    public Collection<ContentObject> getChildren() {
        return children;
    }

    public void setChildren(Collection<ContentObject> children) {
        this.children = children;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public PermissionSet getAcl() {
        return acl;
    }

    public void setAcl(PermissionSet acl) {
        this.acl = acl;
    }

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public Collection<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Collection<Favorite> favorites) {
        this.favorites = favorites;
    }

    public Collection<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Collection<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Collection<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Notification> notifications) {
        this.notifications = notifications;
    }

    public Collection<Rendition> getRenditions() {
        return renditions;
    }

    public void setRenditions(Collection<Rendition> renditions) {
        this.renditions = renditions;
    }

    public Collection<Shortcut> getShortcutContents() {
        return shortcutContents;
    }

    public void setShortcutContents(Collection<Shortcut> shortcutContents) {
        this.shortcutContents = shortcutContents;
    }

    public Collection<Shortcut> getShortcutLocations() {
        return shortcutLocations;
    }

    public void setShortcutLocations(Collection<Shortcut> shortcutLocations) {
        this.shortcutLocations = shortcutLocations;
    }
}
