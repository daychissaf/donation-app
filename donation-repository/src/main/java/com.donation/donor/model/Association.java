package com.donation.donor.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="ASSOCIATION_SQ", sequenceName="association_sequence")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ASSOCIATION_SQ")
    private Long id;

    private String associationName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }
}
