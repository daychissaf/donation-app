package com.donation.crud;

import com.donation.common.CrudService;
import com.donation.donor.model.Video;

import java.util.List;

public interface VideoCrudService extends CrudService<Video> {

    List<Video> getVideosByProject(Long idProject);

    Video getRandomVideo(Long idProject);
}
