package com.donation.web;

import com.donation.VideoService;
import com.donation.donor.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//@Secured("ROLE_USER")
@RestController
@RequestMapping("/api/video")
public class VideoStreamingController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/stream/{idProject}")
    public StreamingResponseBody stream(@PathVariable Long idProject) throws FileNotFoundException {
        Video video = videoService.getRandomVideo(idProject);
        File videoFile = new File(video.getLink());
        final InputStream videoFileStream = new FileInputStream(videoFile);
        return (os) -> {
            videoService.emitVideoFrames(videoFileStream, os);
        };
    }

    @GetMapping("/{idProject}")
    public Video getVideo(@PathVariable Long idProject){
        Video video = videoService.getRandomVideo(idProject);
        return video;
    }
}
