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
@Table(name = "rendition")
public class Rendition implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;
    @Size(max = 100)
    @Column(name = "format_name")
    private String formatName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "set_time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime setTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "content_size")
    private Integer contentSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_primary")
    private Boolean isPrimary;
    @Column(name = "is_default")
    private Boolean isDefault;
    @JoinColumn(name = "content_object", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContentObject contentObject;
    @JoinColumn(name = "format", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Format format;


}
