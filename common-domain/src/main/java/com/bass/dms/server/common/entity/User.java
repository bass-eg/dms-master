package com.bass.dms.server.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 30)
    @NotNull
    @Column(name = "user_id", nullable = false, length = 30)
    private String userId;

    @Size(max = 30)
    @Column(name = "password", length = 30)
    private String password;

    @Size(max = 60)
    @NotNull
    @Column(name = "full_name", nullable = false, length = 60)
    private String fullName;

    @Size(max = 3)
    @Column(name = "initials", length = 3)
    private String initials;

    @Size(max = 300)
    @Column(name = "description", length = 300)
    private String description;

    @Size(max = 60)
    @NotNull
    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "acl", nullable = false)
    private PermissionSet acl;

    @Size(max = 100)
    @Column(name = "default_folder", length = 100)
    private String defaultFolder;

    @NotNull
    @Column(name = "last_login_utc_time", nullable = false)
    private Instant lastLoginUtcTime;

    @Size(max = 30)
    @NotNull
    @Column(name = "user_state", nullable = false, length = 30)
    private String userState;

    @NotNull
    @Column(name = "client_capability", nullable = false)
    private Integer clientCapability;

    @NotNull
    @Column(name = "privilege", nullable = false)
    private Integer privilege;

    @NotNull
    @Column(name = "disable_workflow", nullable = false)
    private Boolean disableWorkflow = false;

    @NotNull
    @Column(name = "disable_auth_failure", nullable = false)
    private Boolean disableAuthFailure = false;

    @Size(max = 30)
    @NotNull
    @Column(name = "user_source", nullable = false, length = 30)
    private String userSource;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(name = "favorite",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "content_object"))
    private List<ContentObject> facouriteContentObjects ;

    @ManyToMany
    @JoinTable(name = "group_member",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "group"))
    private List<UserGroup> memeberInGroup;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "owner")
    private List<UserGroup> ownedGroups ;

    @OneToMany(mappedBy = "groupAdmin")
    private List<UserGroup> administratingGroups ;

}
