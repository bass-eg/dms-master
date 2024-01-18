/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bass.dms.server.common.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * @author moustafa.magdy
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "content_object")
public class ContentObject implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Size(max = 60)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "owner_name")
    private String ownerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "owner_permit")
    private int ownerPermit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "acl_creation_type")
    private String aclCreationType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_folder")
    private boolean isFolder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "modifier")
    private String modifier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_permit")
    private int groupPermit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "world_permit")
    private int worldPermit;
    @Column(name = "page_cnt")
    private Integer pageCnt;
    @Column(name = "content_size")
    private Integer contentSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_locked")
    private boolean isLocked;
    @Size(max = 30)
    @Column(name = "lock_owner")
    private String lockOwner;
    @Column(name = "lock_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockDate;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Size(max = 30)
    @Column(name = "status")
    private String status;
    @Column(name = "resume_state")
    private Integer resumeState;
    @Column(name = "current_state")
    private Integer currentState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chronicle_id")
    private int chronicleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "version_label")
    private String versionLabel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "version_name")
    private String versionName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_current")
    private boolean isCurrent;
    @Column(name = "notify_on_read")
    private Boolean notifyOnRead;
    @Column(name = "notify_on_change")
    private Boolean notifyOnChange;
    @JoinTable(name = "shortcut", joinColumns = {
            @JoinColumn(name = "source", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "shortcut", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ContentObject> sourceContentObjects;
    @ManyToMany(mappedBy = "contentObjectList", fetch = FetchType.LAZY)
    private List<ContentObject> shortcutContentObjects;
    @JoinTable(name = "favorite", joinColumns = {
            @JoinColumn(name = "content_object", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentContentObject", fetch = FetchType.LAZY)
    private List<ContentObject> childrenContentObjects;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContentObject parentContentObject;
    @JoinColumn(name = "lifecycle", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lifecycle lifecycle;
    @JoinColumn(name = "object_type", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ObjectType objectType;
    @JoinColumn(name = "acl", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PermissionSet acl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contentObject", fetch = FetchType.LAZY)
    private List<Author> authors;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contentObject", fetch = FetchType.LAZY)
    private List<Notification> notifications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contentObject", fetch = FetchType.LAZY)
    private List<AuditTrail> auditTrails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contentObject", fetch = FetchType.LAZY)
    private List<Rendition> renditions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contentObject", fetch = FetchType.LAZY)
    private List<Comment> comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contentObject", fetch = FetchType.LAZY)
    private List<Keyword> keywords;


}
