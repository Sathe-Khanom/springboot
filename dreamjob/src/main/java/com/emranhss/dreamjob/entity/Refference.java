package com.emranhss.dreamjob.entity;

import jakarta.persistence.*;

@Entity
public class Refference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private String relation;

    @ManyToOne
    private JobSeeker jobSeeker;


}
