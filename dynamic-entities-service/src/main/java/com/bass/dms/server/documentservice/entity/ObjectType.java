package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "object_types", schema = "public", catalog = "dms")
public class ObjectType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "type_name", nullable = false, length = 30)
    private String typeName;
    @Basic
    @Column(name = "default_acl", nullable = true, length = 30)
    private String defaultAcl;
    @OneToMany(mappedBy = "objectType")
    private Collection<Category> categories;
    @OneToMany(mappedBy = "objectType")
    private Collection<ContentObject> contentObjects;
    @OneToMany(mappedBy = "objectType")
    private Collection<Lifecycle> lifecycles;
    @ManyToOne
    @JoinColumn(name = "default_group", referencedColumnName = "id")
    private Group defaultGroup;
    @ManyToOne
    @JoinColumn(name = "super_type", referencedColumnName = "id")
    private ObjectType superType;
    @OneToMany(mappedBy = "superType")
    private Collection<ObjectType> objectTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDefaultAcl() {
        return defaultAcl;
    }

    public void setDefaultAcl(String defaultAcl) {
        this.defaultAcl = defaultAcl;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ObjectType that = (ObjectType) object;
        return Objects.equals(id, that.id) && Objects.equals(typeName, that.typeName) && Objects.equals(defaultAcl, that.defaultAcl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, defaultAcl);
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<ContentObject> getContentObjects() {
        return contentObjects;
    }

    public void setContentObjects(Collection<ContentObject> contentObjects) {
        this.contentObjects = contentObjects;
    }

    public Collection<Lifecycle> getLifecycles() {
        return lifecycles;
    }

    public void setLifecycles(Collection<Lifecycle> lifecycles) {
        this.lifecycles = lifecycles;
    }

    public Group getDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(Group defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    public ObjectType getSuperType() {
        return superType;
    }

    public void setSuperType(ObjectType superType) {
        this.superType = superType;
    }

    public Collection<ObjectType> getObjectTypes() {
        return objectTypes;
    }

    public void setObjectTypes(Collection<ObjectType> objectTypes) {
        this.objectTypes = objectTypes;
    }
}
