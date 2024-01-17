package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lifecycles", schema = "public", catalog = "dms")
public class Lifecycle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 60)
    private String name;
    @Basic
    @Column(name = "title", nullable = true, length = 60)
    private String title;
    @Basic
    @Column(name = "subject", nullable = true, length = 100)
    private String subject;
    @Basic
    @Column(name = "owner", nullable = false, length = 60)
    private String owner;
    @Basic
    @Column(name = "create_date", nullable = false)
    private Timestamp createDate;
    @Basic
    @Column(name = "modifier", nullable = false, length = 30)
    private String modifier;
    @Basic
    @Column(name = "modify_date", nullable = false)
    private Timestamp modifyDate;
    @OneToMany(mappedBy = "lifecycle")
    private Collection<ContentObject> contentObjects;
    @OneToMany(mappedBy = "lifecycle")
    private Collection<LifecycleState> lifecycleStates;
    @ManyToOne
    @JoinColumn(name = "object_type", referencedColumnName = "id", nullable = false)
    private ObjectType objectType;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Lifecycle lifecycle = (Lifecycle) object;
        return Objects.equals(id, lifecycle.id) && Objects.equals(name, lifecycle.name) && Objects.equals(title, lifecycle.title) && Objects.equals(subject, lifecycle.subject) && Objects.equals(owner, lifecycle.owner) && Objects.equals(createDate, lifecycle.createDate) && Objects.equals(modifier, lifecycle.modifier) && Objects.equals(modifyDate, lifecycle.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, subject, owner, createDate, modifier, modifyDate);
    }

    public Collection<ContentObject> getContentObjects() {
        return contentObjects;
    }

    public void setContentObjects(Collection<ContentObject> contentObjects) {
        this.contentObjects = contentObjects;
    }

    public Collection<LifecycleState> getLifecycleStates() {
        return lifecycleStates;
    }

    public void setLifecycleStates(Collection<LifecycleState> lifecycleStates) {
        this.lifecycleStates = lifecycleStates;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
