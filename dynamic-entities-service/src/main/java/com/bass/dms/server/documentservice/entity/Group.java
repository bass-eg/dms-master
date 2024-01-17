package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "groups", schema = "public", catalog = "dms")
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @Column(name = "email", nullable = true, length = 60)
    private String email;
    @Basic
    @Column(name = "description", nullable = true, length = 200)
    private String description;
    @Basic
    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;
    @Basic
    @Column(name = "group_class", nullable = false, length = 6)
    private String groupClass;
    @OneToMany(mappedBy = "group")
    private Collection<GroupMember> groupMembers;
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private User owner;
    @ManyToOne
    @JoinColumn(name = "group_admin", referencedColumnName = "id")
    private User groupAdmin;
    @OneToMany(mappedBy = "defaultGroup")
    private Collection<ObjectType> objectTypes;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(String groupClass) {
        this.groupClass = groupClass;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Group group = (Group) object;
        return Objects.equals(id, group.id) && Objects.equals(name, group.name) && Objects.equals(email, group.email) && Objects.equals(description, group.description) && Objects.equals(isPrivate, group.isPrivate) && Objects.equals(groupClass, group.groupClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, description, isPrivate, groupClass);
    }

    public Collection<GroupMember> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Collection<GroupMember> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(User groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public Collection<ObjectType> getObjectTypes() {
        return objectTypes;
    }

    public void setObjectTypes(Collection<ObjectType> objectTypes) {
        this.objectTypes = objectTypes;
    }
}
