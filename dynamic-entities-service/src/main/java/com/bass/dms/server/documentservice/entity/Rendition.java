package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "renditions", schema = "public", catalog = "dms")
public class Rendition {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "format_name", nullable = true, length = 100)
    private String formatName;
    @Basic
    @Column(name = "set_time", nullable = false)
    private Timestamp setTime;
    @Basic
    @Column(name = "content_size", nullable = false)
    private Integer contentSize;
    @Basic
    @Column(name = "is_primary", nullable = false)
    private Boolean isPrimary;
    @Basic
    @Column(name = "is_default", nullable = true)
    private Boolean isDefault;
    @ManyToOne
    @JoinColumn(name = "content_object", referencedColumnName = "id", nullable = false)
    private ContentObject contentObject;
    @ManyToOne
    @JoinColumn(name = "format", referencedColumnName = "id", nullable = false)
    private Format format;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public Timestamp getSetTime() {
        return setTime;
    }

    public void setSetTime(Timestamp setTime) {
        this.setTime = setTime;
    }

    public Integer getContentSize() {
        return contentSize;
    }

    public void setContentSize(Integer contentSize) {
        this.contentSize = contentSize;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Rendition rendition = (Rendition) object;
        return Objects.equals(id, rendition.id) && Objects.equals(formatName, rendition.formatName) && Objects.equals(setTime, rendition.setTime) && Objects.equals(contentSize, rendition.contentSize) && Objects.equals(isPrimary, rendition.isPrimary) && Objects.equals(isDefault, rendition.isDefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formatName, setTime, contentSize, isPrimary, isDefault);
    }

    public ContentObject getContentObject() {
        return contentObject;
    }

    public void setContentObject(ContentObject contentObject) {
        this.contentObject = contentObject;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
