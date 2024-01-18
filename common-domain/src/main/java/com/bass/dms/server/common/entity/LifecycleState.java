/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bass.dms.server.common.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * @author moustafa.magdy
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "lifecycle_state")
public class LifecycleState implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state_number")
    private int stateNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "desc")
    private String desc;
    @Column(name = "is_base_state")
    private Boolean isBaseState;
    @Column(name = "is_exception")
    private Boolean isException;
    @Size(max = 200)
    @Column(name = "entry_condition")
    private String entryCondition;
    @Column(name = "has_action_before")
    private Boolean hasActionBefore;
    @Column(name = "has_action_after")
    private Boolean hasActionAfter;
    @Column(name = "demote_checkin")
    private Boolean demoteCheckin;
    @Column(name = "demote_save")
    private Boolean demoteSave;
    @Column(name = "demote_save_as_new")
    private Boolean demoteSaveAsNew;
    @JoinColumn(name = "lifecycle", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lifecycle lifecycle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lifecycleState", fetch = FetchType.LAZY)
    private List<EntryCondition> entryConditions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lifecycleState", fetch = FetchType.LAZY)
    private List<StateAction> stateActions;


}
