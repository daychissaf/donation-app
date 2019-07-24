package com.donation.web;

import com.donation.VideoService;
import com.donation.crud.VideoCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.FileNotFoundException;

@Secured("ROLE_USER")
@RestController
@RequestMapping("/api/stream")
public class VideoStreamingController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/{idProject}")
    public StreamingResponseBody stream(@PathVariable Long idProject) throws FileNotFoundException {
        return videoService.stream(idProject);
    }
}
