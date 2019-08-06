package com.donation.crud.impl;

import com.donation.common.CrudServiceImpl;
import com.donation.crud.VideoCrudService;
import com.donation.donor.VideoCrudRepository;
import com.donation.donor.model.Sponsor;
import com.donation.donor.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoCrudServiceImpl extends CrudServiceImpl<Video> implements VideoCrudService {

    @Autowired
    private VideoCrudRepository videoCrudRepository;

    @Autowired
    private SponsorCrudServiceImpl sponsorCrudService;

    @Override
    protected CrudRepository<Video, Long> repository() {
        return videoCrudRepository;
    }

    @Override
    public Video add(Video video) {
        Sponsor sponsor = sponsorCrudService.getById(video.getSponsor().getId());
        video.setSponsor(sponsor);
        videoCrudRepository.save(video);
        return video;
    }

    @Override
    public Video update(Video objectToUpdate, Video newObjectData) {

        if (newObjectData.getTitle() != null) {
            objectToUpdate.setTitle(newObjectData.getTitle());
        }

        if (newObjectData.getLink() != null) {
            objectToUpdate.setLink(newObjectData.getLink());
        }

        if (newObjectData.getSponsor() != null) {
            objectToUpdate.setSponsor(sponsorCrudService.getById(newObjectData.getSponsor().getId()));
        }

        videoCrudRepository.save(objectToUpdate);
        return objectToUpdate;
    }

}
