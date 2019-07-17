package com.donation.web;

import com.donation.crud.VideoCrudService;
import com.donation.donor.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/api/stream")
public class VideoStreamingController {

    @Autowired
    private VideoCrudService videoCrudService;

    private List<Video> videos = new ArrayList<Video>();

    @GetMapping("/{idProject}")
    public StreamingResponseBody stream(@PathVariable Long idProject) throws FileNotFoundException {

        Random random = new Random();
        Video video = videoCrudService.getVideosByProject(idProject).get(random.nextInt(videoCrudService.getVideosByProject(idProject).size()));
        System.out.println("\n********************************" + video.getLink() + "\n*************************" + video.getId());
        File videoFile = new File(video.getLink());
        final InputStream videoFileStream = new FileInputStream(videoFile);
        return (os) -> {
            readAndWrite(videoFileStream, os);
        };
    }

    private void readAndWrite(final InputStream is, OutputStream os)
            throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }
}
