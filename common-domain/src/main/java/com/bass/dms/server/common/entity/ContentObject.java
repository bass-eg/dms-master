/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bass.dms.server.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Size(max = 60)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "subject")
    private String subject;
    @Size(min = 1, max = 30)
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "owner_permit")
    private Integer ownerPermit;
    @Size(min = 1, max = 10)
    @Column(name = "acl_creation_type")
    private String aclCreationType;
    @Column(name = "is_folder")
    private Boolean isFolder;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate;

    @Size(min = 1, max = 30)
    @Column(name = "modifier")
    private String modifier;

    @Column(name = "modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifyDate;

    @Size(min = 1, max = 30)
    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_permit")
    private Integer groupPermit;

    @Column(name = "world_permit")
    private Integer worldPermit;
    @Column(name = "page_cnt")
    private Integer pageCnt;
    @Column(name = "content_size")
    private Integer contentSize;

    @Column(name = "is_locked")
    private Boolean isLocked;
    @Size(max = 30)
    @Column(name = "lock_owner")
    private String lockOwner;
    @Column(name = "lock_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lockDate;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Size(max = 30)
    @Column(name = "status")
    private String status;
    @Column(name = "resume_state")
    private Integer resumeState;
    @Column(name = "current_state")
    private Integer currentState;

    @Column(name = "chronicle_id")
    private Integer chronicleId;

    @Size(min = 1, max = 30)
    @Column(name = "version_label")
    private String versionLabel;

    @Size(min = 1, max = 30)
    @Column(name = "version_name")
    private String versionName;

    @Column(name = "is_current")
    private Boolean isCurrent;
    @Column(name = "notify_on_read")
    private Boolean notifyOnRead;
    @Column(name = "notify_on_change")
    private Boolean notifyOnChange;
    @JoinTable(name = "shortcut", joinColumns = {
            @JoinColumn(name = "source", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "shortcut", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ContentObject> sourceContentObjects;
    @ManyToMany(mappedBy = "sourceContentObjects", fetch = FetchType.LAZY)
    private List<ContentObject> shortcutContentObjects;

    @JoinTable(name = "favorite", joinColumns = {
            @JoinColumn(name = "content_object", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;
    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentContentObject", fetch = FetchType.LAZY)
//    private List<ContentObject> childrenContentObjects;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
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
