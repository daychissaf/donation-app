package com.donation;

import com.donation.donor.model.Video;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface VideoService {

    void emitVideoFrames(final InputStream is, OutputStream os) throws IOException;

    List<Video> getVideosByProject(Long idProject);

    Video getRandomVideo(Long idProject);

}
