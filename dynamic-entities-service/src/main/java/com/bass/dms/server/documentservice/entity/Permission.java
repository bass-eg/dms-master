package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "permissions", schema = "public", catalog = "dms")
public class Permission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "accessor_name", nullable = false, length = 30)
    private String accessorName;
    @Basic
    @Column(name = "base_permissions", nullable = false)
    private Integer basePermissions;
    @Basic
    @Column(name = "extended_permissions", nullable = true)
    private Integer extendedPermissions;
    @Basic
    @Column(name = "is_group", nullable = false)
    private Boolean isGroup;
    @ManyToOne
    @JoinColumn(name = "acl", referencedColumnName = "id", nullable = false)
    private PermissionSet acl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessorName() {
        return accessorName;
    }

    public void setAccessorName(String accessorName) {
        this.accessorName = accessorName;
    }

    public Integer getBasePermissions() {
        return basePermissions;
    }

    public void setBasePermissions(Integer basePermissions) {
        this.basePermissions = basePermissions;
    }

    public Integer getExtendedPermissions() {
        return extendedPermissions;
    }

    public void setExtendedPermissions(Integer extendedPermissions) {
        this.extendedPermissions = extendedPermissions;
    }

    public Boolean getGroup() {
        return isGroup;
    }

    public void setGroup(Boolean group) {
        isGroup = group;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Permission that = (Permission) object;
        return Objects.equals(id, that.id) && Objects.equals(accessorName, that.accessorName) && Objects.equals(basePermissions, that.basePermissions) && Objects.equals(extendedPermissions, that.extendedPermissions) && Objects.equals(isGroup, that.isGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accessorName, basePermissions, extendedPermissions, isGroup);
    }

    public PermissionSet getAcl() {
        return acl;
    }

    public void setAcl(PermissionSet acl) {
        this.acl = acl;
    }
}
