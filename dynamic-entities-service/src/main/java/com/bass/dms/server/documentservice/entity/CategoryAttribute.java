package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "category_attributes", schema = "public", catalog = "dms")
public class CategoryAttribute {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "type", nullable = false, length = 10)
    private String type;
    @Basic
    @Column(name = "name", nullable = false, length = 60)
    private String name;
    @Basic
    @Column(name = "lable", nullable = false, length = 30)
    private String lable;
    @Basic
    @Column(name = "position", nullable = false)
    private Integer position;
    @Basic
    @Column(name = "length", nullable = false, precision = 2)
    private BigDecimal length;
    @Basic
    @Column(name = "is_mandatory", nullable = false)
    private Boolean isMandatory;
    @Basic
    @Column(name = "is_displayed", nullable = false)
    private Boolean isDisplayed;
    @Basic
    @Column(name = "has_lov", nullable = false)
    private Boolean hasLov;
    @Basic
    @Column(name = "lov_values", nullable = true, length = 1000)
    private String lovValues;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public Boolean getMandatory() {
        return isMandatory;
    }

    public void setMandatory(Boolean mandatory) {
        isMandatory = mandatory;
    }

    public Boolean getDisplayed() {
        return isDisplayed;
    }

    public void setDisplayed(Boolean displayed) {
        isDisplayed = displayed;
    }

    public Boolean getHasLov() {
        return hasLov;
    }

    public void setHasLov(Boolean hasLov) {
        this.hasLov = hasLov;
    }

    public String getLovValues() {
        return lovValues;
    }

    public void setLovValues(String lovValues) {
        this.lovValues = lovValues;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CategoryAttribute that = (CategoryAttribute) object;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(name, that.name) && Objects.equals(lable, that.lable) && Objects.equals(position, that.position) && Objects.equals(length, that.length) && Objects.equals(isMandatory, that.isMandatory) && Objects.equals(isDisplayed, that.isDisplayed) && Objects.equals(hasLov, that.hasLov) && Objects.equals(lovValues, that.lovValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, lable, position, length, isMandatory, isDisplayed, hasLov, lovValues);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
