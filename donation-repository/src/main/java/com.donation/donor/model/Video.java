package com.donation.donor.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="VIDEO_SQ", sequenceName="video_sequence")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "VIDEO_SQ")
    private Long id;
    private String title;
    private String link;

    @ManyToOne
    private Sponsor sponsor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }


}
