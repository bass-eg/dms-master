/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bass.dms.server.common.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
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
@Table(name = "user")
public class User implements Serializable {

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
    @Column(name = "user_id")
    private String userId;
    @Size(max = 30)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "full_name")
    private String fullName;
    @Size(max = 3)
    @Column(name = "initials")
    private String initials;
    @Size(max = 300)
    @Column(name = "description")
    private String description;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "default_folder")
    private String defaultFolder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_login_utc_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginUtcTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "user_state")
    private String userState;
    @Basic(optional = false)
    @NotNull
    @Column(name = "client_capability")
    private int clientCapability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "privilege")
    private int privilege;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disable_workflow")
    private boolean disableWorkflow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disable_auth_failure")
    private boolean disableAuthFailure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "user_source")
    private String userSource;
    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<UserGroup> userGroups;
    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<ContentObject> contentObjects;
    @OneToMany(mappedBy = "groupAdmin", fetch = FetchType.LAZY)
    private List<UserGroup> adminUserGroups;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<UserGroup> ownerUserGroups;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Notification> notifications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Comment> comments;
    @JoinColumn(name = "acl", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PermissionSet acl;

}
