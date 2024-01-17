package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "shortcuts", schema = "public", catalog = "dms")
public class Shortcut {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @ManyToOne
    @JoinColumn(name = "content", referencedColumnName = "id", nullable = false)
    private ContentObject content;
    @ManyToOne
    @JoinColumn(name = "location", referencedColumnName = "id", nullable = false)
    private ContentObject location;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Shortcut shortcut = (Shortcut) object;
        return Objects.equals(id, shortcut.id) && Objects.equals(name, shortcut.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public ContentObject getContent() {
        return content;
    }

    public void setContent(ContentObject content) {
        this.content = content;
    }

    public ContentObject getLocation() {
        return location;
    }

    public void setLocation(ContentObject location) {
        this.location = location;
    }
}
