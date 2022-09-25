package com.transaction.management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "information_log")
public class LogEntity {

    @Id
    @Column(name = "info_log_pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoPkId;
    @Column(name = "error_message")
    private String errorMessage;
    @Column(name = "created_date")
    private Date createdDate;
}
