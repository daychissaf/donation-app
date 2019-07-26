package com.donation.donor.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SPONSOR_SQ", sequenceName = "sponsor_sequence")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SPONSOR_SQ")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
