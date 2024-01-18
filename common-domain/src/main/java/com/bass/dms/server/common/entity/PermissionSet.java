/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bass.dms.server.common.entity;

import java.io.Serial;
import java.io.Serializable;
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
@Table(name = "permission_set")
public class PermissionSet implements Serializable {

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
    @Column(name = "acl_name")
    private String aclName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "owner")
    private String owner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_internal")
    private boolean isInternal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_public")
    private boolean isPublic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acl", fetch = FetchType.LAZY)
    private List<ContentObject> contentObjects;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acl", fetch = FetchType.LAZY)
    private List<Permission> permissions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acl", fetch = FetchType.LAZY)
    private List<User> users;


}
