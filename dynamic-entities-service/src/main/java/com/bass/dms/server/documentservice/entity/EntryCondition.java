package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "entry_conditions", schema = "public", catalog = "dms")
public class EntryCondition {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "condtion_order", nullable = false)
    private Integer condtionOrder;
    @Basic
    @Column(name = "logical_operator", nullable = true, length = 3)
    private String logicalOperator;
    @Basic
    @Column(name = "attribute_name", nullable = true, length = 60)
    private String attributeName;
    @Basic
    @Column(name = "relational_operator", nullable = true, length = 3)
    private String relationalOperator;
    @Basic
    @Column(name = "attribute_value", nullable = true, length = 60)
    private String attributeValue;
    @Basic
    @Column(name = "is_procedure", nullable = false)
    private Boolean isProcedure;
    @Basic
    @Column(name = "procedure_name", nullable = true, length = 20)
    private String procedureName;
    @ManyToOne
    @JoinColumn(name = "lifecycle_state", referencedColumnName = "id", nullable = false)
    private LifecycleState lifecycleState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCondtionOrder() {
        return condtionOrder;
    }

    public void setCondtionOrder(Integer condtionOrder) {
        this.condtionOrder = condtionOrder;
    }

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getRelationalOperator() {
        return relationalOperator;
    }

    public void setRelationalOperator(String relationalOperator) {
        this.relationalOperator = relationalOperator;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Boolean getProcedure() {
        return isProcedure;
    }

    public void setProcedure(Boolean procedure) {
        isProcedure = procedure;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EntryCondition that = (EntryCondition) object;
        return Objects.equals(id, that.id) && Objects.equals(condtionOrder, that.condtionOrder) && Objects.equals(logicalOperator, that.logicalOperator) && Objects.equals(attributeName, that.attributeName) && Objects.equals(relationalOperator, that.relationalOperator) && Objects.equals(attributeValue, that.attributeValue) && Objects.equals(isProcedure, that.isProcedure) && Objects.equals(procedureName, that.procedureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condtionOrder, logicalOperator, attributeName, relationalOperator, attributeValue, isProcedure, procedureName);
    }

    public LifecycleState getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(LifecycleState lifecycleState) {
        this.lifecycleState = lifecycleState;
    }
}
