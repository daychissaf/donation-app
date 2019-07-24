package com.donation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface VideoService {

    void readAndWrite(final InputStream is, OutputStream os) throws IOException;

}
