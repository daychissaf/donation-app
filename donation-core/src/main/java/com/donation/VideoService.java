package com.donation;

import com.donation.donor.model.Video;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface VideoService {

    void emitVideoFrames(final InputStream is, OutputStream os) throws IOException;
    void normalEmitVideoFrames(final InputStream is, OutputStream os) throws IOException;

    Video getRandomVideo(Long idProject);

}
