/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bass.dms.server.common.entity;

import java.io.Serial;
import java.io.Serializable;

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
@Table(name = "entry_condition")
public class EntryCondition implements Serializable {

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
    @Column(name = "condition_order")
    private int conditionOrder;
    @Size(max = 3)
    @Column(name = "logical_operator")
    private String logicalOperator;
    @Size(max = 60)
    @Column(name = "attribute_name")
    private String attributeName;
    @Size(max = 3)
    @Column(name = "relational_operator")
    private String relationalOperator;
    @Size(max = 60)
    @Column(name = "attribute_value")
    private String attributeValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_procedure")
    private boolean isProcedure;
    @Size(max = 20)
    @Column(name = "procedure_name")
    private String procedureName;
    @JoinColumn(name = "lifecycle_state", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LifecycleState lifecycleState;


}
