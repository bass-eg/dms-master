package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "formats", schema = "public", catalog = "dms")
public class Format {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 200)
    private String description;
    @Basic
    @Column(name = "extension", nullable = true, length = 100)
    private String extension;
    @Basic
    @Column(name = "mime_type", nullable = false, length = 100)
    private String mimeType;
    @Basic
    @Column(name = "can_index", nullable = false)
    private Boolean canIndex;
    @OneToMany(mappedBy = "format")
    private Collection<Rendition> renditions;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Boolean getCanIndex() {
        return canIndex;
    }

    public void setCanIndex(Boolean canIndex) {
        this.canIndex = canIndex;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Format format = (Format) object;
        return Objects.equals(id, format.id) && Objects.equals(name, format.name) && Objects.equals(description, format.description) && Objects.equals(extension, format.extension) && Objects.equals(mimeType, format.mimeType) && Objects.equals(canIndex, format.canIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, extension, mimeType, canIndex);
    }

    public Collection<Rendition> getRenditions() {
        return renditions;
    }

    public void setRenditions(Collection<Rendition> renditions) {
        this.renditions = renditions;
    }
}
