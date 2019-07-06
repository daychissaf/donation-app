package com.donation.web.crud;

import com.donation.common.CrudService;
import com.donation.crud.VideoCrudService;
import com.donation.donor.model.Video;
import com.donation.web.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/videos")
public class VideoCrudController extends CrudController<Video> {

    @Autowired
    private VideoCrudService videoService;

    @Override
    public CrudService<Video> service() {
        return this.videoService;
    }

}

