package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "state_actions", schema = "public", catalog = "dms")
public class StateAction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "action_id", nullable = false, length = 30)
    private String actionId;
    @Basic
    @Column(name = "type", nullable = false, length = 4)
    private String type;
    @Basic
    @Column(name = "execute_order", nullable = false)
    private Integer executeOrder;
    @Basic
    @Column(name = "parameter", nullable = true, length = 50)
    private String parameter;
    @Basic
    @Column(name = "parameter_value", nullable = true, length = 100)
    private String parameterValue;
    @Basic
    @Column(name = "is_procedure", nullable = false)
    private Boolean isProcedure;
    @Basic
    @Column(name = "procedure_name", nullable = true, length = 30)
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

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExecuteOrder() {
        return executeOrder;
    }

    public void setExecuteOrder(Integer executeOrder) {
        this.executeOrder = executeOrder;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
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
        StateAction that = (StateAction) object;
        return Objects.equals(id, that.id) && Objects.equals(actionId, that.actionId) && Objects.equals(type, that.type) && Objects.equals(executeOrder, that.executeOrder) && Objects.equals(parameter, that.parameter) && Objects.equals(parameterValue, that.parameterValue) && Objects.equals(isProcedure, that.isProcedure) && Objects.equals(procedureName, that.procedureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionId, type, executeOrder, parameter, parameterValue, isProcedure, procedureName);
    }

    public LifecycleState getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(LifecycleState lifecycleState) {
        this.lifecycleState = lifecycleState;
    }
}
