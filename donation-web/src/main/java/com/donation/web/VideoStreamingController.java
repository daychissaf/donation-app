package com.donation.web;

import com.donation.VideoService;
import com.donation.crud.VideoCrudService;
import com.donation.donor.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/stream")
public class VideoStreamingController {

    @Autowired
    private VideoCrudService videoCrudService;

    @Autowired
    private VideoService videoService;

    @GetMapping("/{idProject}")
    public StreamingResponseBody stream(@PathVariable Long idProject) throws FileNotFoundException {
        Video video = videoCrudService.getRandomVideo(idProject);
        File videoFile = new File(video.getLink());
        final InputStream videoFileStream = new FileInputStream(videoFile);
        return (os) -> {
            videoService.readAndWrite(videoFileStream, os);
        };
    }
}
