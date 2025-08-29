package com.hospital.Mediverse.Website.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "branches")
@Getter
@Setter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private String contact;

    private String email;
}
