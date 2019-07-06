package com.donation.donor.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="DONATION_SQ", sequenceName="donation_sequence")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DONATION_SQ")
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
