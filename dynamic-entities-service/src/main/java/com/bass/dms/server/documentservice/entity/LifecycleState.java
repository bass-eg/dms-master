package com.bass.dms.server.documentservice.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lifecycle_states", schema = "public", catalog = "dms")
public class LifecycleState {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "state_number", nullable = false)
    private Integer stateNumber;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @Column(name = "desc", nullable = true, length = 200)
    private String desc;
    @Basic
    @Column(name = "is_base_state", nullable = true)
    private Boolean isBaseState;
    @Basic
    @Column(name = "is_exeption", nullable = true)
    private Boolean isExeption;
    @Basic
    @Column(name = "entry_condition", nullable = true, length = 200)
    private String entryCondition;
    @Basic
    @Column(name = "has_action_before", nullable = true)
    private Boolean hasActionBefore;
    @Basic
    @Column(name = "has_action_after", nullable = true)
    private Boolean hasActionAfter;
    @Basic
    @Column(name = "demote_checkin", nullable = true)
    private Boolean demoteCheckin;
    @Basic
    @Column(name = "demote_save", nullable = true)
    private Boolean demoteSave;
    @Basic
    @Column(name = "demote_saveasnew", nullable = true)
    private Boolean demoteSaveasnew;
    @OneToMany(mappedBy = "lifecycleState")
    private Collection<EntryCondition> entryConditions;
    @ManyToOne
    @JoinColumn(name = "lifecycle", referencedColumnName = "id", nullable = false)
    private Lifecycle lifecycle;
    @OneToMany(mappedBy = "lifecycleState")
    private Collection<StateAction> stateActions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(Integer stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getBaseState() {
        return isBaseState;
    }

    public void setBaseState(Boolean baseState) {
        isBaseState = baseState;
    }

    public Boolean getExeption() {
        return isExeption;
    }

    public void setExeption(Boolean exeption) {
        isExeption = exeption;
    }

    public String getEntryCondition() {
        return entryCondition;
    }

    public void setEntryCondition(String entryCondition) {
        this.entryCondition = entryCondition;
    }

    public Boolean getHasActionBefore() {
        return hasActionBefore;
    }

    public void setHasActionBefore(Boolean hasActionBefore) {
        this.hasActionBefore = hasActionBefore;
    }

    public Boolean getHasActionAfter() {
        return hasActionAfter;
    }

    public void setHasActionAfter(Boolean hasActionAfter) {
        this.hasActionAfter = hasActionAfter;
    }

    public Boolean getDemoteCheckin() {
        return demoteCheckin;
    }

    public void setDemoteCheckin(Boolean demoteCheckin) {
        this.demoteCheckin = demoteCheckin;
    }

    public Boolean getDemoteSave() {
        return demoteSave;
    }

    public void setDemoteSave(Boolean demoteSave) {
        this.demoteSave = demoteSave;
    }

    public Boolean getDemoteSaveasnew() {
        return demoteSaveasnew;
    }

    public void setDemoteSaveasnew(Boolean demoteSaveasnew) {
        this.demoteSaveasnew = demoteSaveasnew;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LifecycleState that = (LifecycleState) object;
        return Objects.equals(id, that.id) && Objects.equals(stateNumber, that.stateNumber) && Objects.equals(name, that.name) && Objects.equals(desc, that.desc) && Objects.equals(isBaseState, that.isBaseState) && Objects.equals(isExeption, that.isExeption) && Objects.equals(entryCondition, that.entryCondition) && Objects.equals(hasActionBefore, that.hasActionBefore) && Objects.equals(hasActionAfter, that.hasActionAfter) && Objects.equals(demoteCheckin, that.demoteCheckin) && Objects.equals(demoteSave, that.demoteSave) && Objects.equals(demoteSaveasnew, that.demoteSaveasnew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stateNumber, name, desc, isBaseState, isExeption, entryCondition, hasActionBefore, hasActionAfter, demoteCheckin, demoteSave, demoteSaveasnew);
    }

    public Collection<EntryCondition> getEntryConditions() {
        return entryConditions;
    }

    public void setEntryConditions(Collection<EntryCondition> entryConditions) {
        this.entryConditions = entryConditions;
    }

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public Collection<StateAction> getStateActions() {
        return stateActions;
    }

    public void setStateActions(Collection<StateAction> stateActions) {
        this.stateActions = stateActions;
    }
}
