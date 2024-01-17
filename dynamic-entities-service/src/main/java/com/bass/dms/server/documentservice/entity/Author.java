package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "authors", schema = "public", catalog = "dms")
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "author", nullable = false, length = 60)
    private String author;
    @ManyToOne
    @JoinColumn(name = "content_object", referencedColumnName = "id", nullable = false)
    private ContentObject contentObject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Author author1 = (Author) object;
        return Objects.equals(id, author1.id) && Objects.equals(author, author1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author);
    }

    public ContentObject getContentObject() {
        return contentObject;
    }

    public void setContentObject(ContentObject contentObject) {
        this.contentObject = contentObject;
    }
}
