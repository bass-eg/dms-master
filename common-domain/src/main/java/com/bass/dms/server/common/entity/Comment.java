/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bass.dms.server.common.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


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
@Table(name = "comment")
public class Comment implements Serializable {

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
    @Size(min = 1, max = 250)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    @JoinColumn(name = "content_object", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContentObject contentObject;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;


}
