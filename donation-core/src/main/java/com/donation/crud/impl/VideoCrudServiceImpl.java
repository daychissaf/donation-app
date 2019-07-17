package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.ProjectCrudService;
import com.donation.crud.VideoCrudService;
import com.donation.donor.ProjectCrudRepository;
import com.donation.donor.VideoCrudRepository;
import com.donation.donor.model.Project;
import com.donation.donor.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoCrudServiceImpl extends CrudServiceImpl<Video> implements VideoCrudService {

    @Autowired
    private VideoCrudRepository videoCrudRepository;

    @Autowired
    private ProjectCrudService projectCrudService;

    @Override
    protected CrudRepository<Video, Long> repository() {
        return videoCrudRepository;
    }

    @Override
    public List<Video> getVideosByProject(Long idProject) {

        return projectCrudService.getById(idProject).getVideos();
    }
}
