package com.donation;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface VideoService {

    StreamingResponseBody stream(Long idProject) throws FileNotFoundException;

    void readAndWrite(final InputStream is, OutputStream os) throws IOException;

}
