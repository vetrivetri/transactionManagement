package com.transaction.management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "information")
public class InformationEntity {
    @Id
    @Column(name = "info_pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoPkId;
    @Column(name = "name")
    private String name;
    @Column(name = "information")
    private String information;

}
