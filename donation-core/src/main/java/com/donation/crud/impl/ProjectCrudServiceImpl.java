package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.ProjectCrudService;
import com.donation.donor.ProjectCrudRepository;
import com.donation.donor.model.Association;
import com.donation.donor.model.Project;
import com.donation.donor.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectCrudServiceImpl extends CrudServiceImpl<Project> implements ProjectCrudService {

    @Autowired
    private ProjectCrudRepository projectCrudRepository;

    @Autowired
    private AssociationCrudServiceImpl associationCrudService;

    @Autowired
    private VideoCrudServiceImpl videoCrudService;

    @Override
    protected CrudRepository<Project, Long> repository() {
        return projectCrudRepository;
    }

    @Override
    public Project add(Project project) {

        Association association = associationCrudService.getById(project.getAssociation().getId());
        List<Video> videos = project.getVideos();
        List<Video> projectVideos = new ArrayList<>();

        for (Video video : videos) {
            projectVideos.add(videoCrudService.getById(video.getId()));
        }

        project.setAssociation(association);
        project.setVideos(projectVideos);

        projectCrudRepository.save(project);
        return project;
    }

    @Override
    public Project update(Project objectToUpdate, Project newObjectData) {

        if (newObjectData.getTitle() != null) {
            objectToUpdate.setTitle(newObjectData.getTitle());
        }

        if (newObjectData.getDescription() != null) {
            objectToUpdate.setDescription(newObjectData.getDescription());
        }

        if (newObjectData.getAssociation() != null) {
            objectToUpdate.setAssociation(associationCrudService.getById(newObjectData.getAssociation().getId()));
        }

        List<Video> videos = newObjectData.getVideos();
        if (videos != null) {
            List<Video> newVideos = new ArrayList<>();
            for (Video video : videos) {
                newVideos.add(videoCrudService.getById(video.getId()));
            }
            objectToUpdate.setVideos(newVideos);
        }

        projectCrudRepository.save(objectToUpdate);
        return objectToUpdate;
    }
}
