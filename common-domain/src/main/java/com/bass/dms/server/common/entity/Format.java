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
@Table(name = "format")
public class Format implements Serializable {

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
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "extension")
    private String extension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mime_type")
    private String mimeType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "can_index")
    private boolean canIndex;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "format", fetch = FetchType.LAZY)
    private List<Rendition> renditions;


}
