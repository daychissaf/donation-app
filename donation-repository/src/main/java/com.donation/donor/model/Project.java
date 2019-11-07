package com.donation.donor.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "PROJECT_SQ", sequenceName = "project_sequence")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PROJECT_SQ")
    private Long id;
    private String title;
    private String description;
    private String imgPath;

    @ManyToOne
    private Association association;

    @ManyToMany
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
