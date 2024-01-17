package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "keywords", schema = "public", catalog = "dms")
public class Keyword {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "keyword", nullable = false, length = 60)
    private String keyword;
    @ManyToOne
    @JoinColumn(name = "content_object", referencedColumnName = "id", nullable = false)
    private ContentObject contentObject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Keyword keyword1 = (Keyword) object;
        return Objects.equals(id, keyword1.id) && Objects.equals(keyword, keyword1.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, keyword);
    }

    public ContentObject getContentObject() {
        return contentObject;
    }

    public void setContentObject(ContentObject contentObject) {
        this.contentObject = contentObject;
    }
}
