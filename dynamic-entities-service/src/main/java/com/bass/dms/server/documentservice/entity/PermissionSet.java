package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "permission_sets", schema = "public", catalog = "dms")
public class PermissionSet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "acl_name", nullable = false, length = 30)
    private String aclName;
    @Basic
    @Column(name = "description", nullable = false, length = 100)
    private String description;
    @Basic
    @Column(name = "owner", nullable = false, length = 30)
    private String owner;
    @Basic
    @Column(name = "is_internal", nullable = false)
    private Boolean isInternal;
    @Basic
    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;
    @OneToMany(mappedBy = "acl")
    private Collection<ContentObject> contentObjects;
    @OneToMany(mappedBy = "acl")
    private Collection<Permission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAclName() {
        return aclName;
    }

    public void setAclName(String aclName) {
        this.aclName = aclName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getInternal() {
        return isInternal;
    }

    public void setInternal(Boolean internal) {
        isInternal = internal;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PermissionSet that = (PermissionSet) object;
        return Objects.equals(id, that.id) && Objects.equals(aclName, that.aclName) && Objects.equals(description, that.description) && Objects.equals(owner, that.owner) && Objects.equals(isInternal, that.isInternal) && Objects.equals(isPublic, that.isPublic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aclName, description, owner, isInternal, isPublic);
    }

    public Collection<ContentObject> getContentObjects() {
        return contentObjects;
    }

    public void setContentObjects(Collection<ContentObject> contentObjects) {
        this.contentObjects = contentObjects;
    }

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions = permissions;
    }
}
