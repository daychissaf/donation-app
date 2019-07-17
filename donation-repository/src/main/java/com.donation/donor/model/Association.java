package com.donation.donor.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "ASSOCIATION_SQ", sequenceName = "association_sequence")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ASSOCIATION_SQ")
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
