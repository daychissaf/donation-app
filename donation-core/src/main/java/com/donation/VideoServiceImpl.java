package com.donation;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

@Service
public class VideoServiceImpl implements VideoService {

    @Override
    public void readAndWrite(final InputStream is, OutputStream os) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[2048];
        int read;
        while ((read = is.read(data)) > 0) {
            bos.write(data, 0, read);
        }

        byte[] b = bos.toByteArray();
        int eachSize = b.length / 10;
        byte[] array1 = Arrays.copyOfRange(b, 0, eachSize);
        byte[] array2 = Arrays.copyOfRange(b, eachSize, eachSize * 2);
        byte[] array3 = Arrays.copyOfRange(b, eachSize * 2, eachSize * 3);
        byte[] array4 = Arrays.copyOfRange(b, eachSize * 3, eachSize * 4);
        byte[] array5 = Arrays.copyOfRange(b, eachSize * 4, eachSize * 5);
        byte[] array6 = Arrays.copyOfRange(b, eachSize * 5, eachSize * 6);
        byte[] array7 = Arrays.copyOfRange(b, eachSize * 6, eachSize * 7);
        byte[] array8 = Arrays.copyOfRange(b, eachSize * 7, eachSize * 8);
        byte[] array9 = Arrays.copyOfRange(b, eachSize * 8, eachSize * 9);
        byte[] array10 = Arrays.copyOfRange(b, eachSize * 9, b.length);

        Flux flux = Flux.just(array1, array2, array3, array4, array5, array6, array7, array8, array9, array10);
        flux.subscribe(new Subscriber<byte[]>() {
            private Subscription s;

            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
                Assets.videoStopped = false;
                s.request(1);

            }

            @Override
            public void onNext(byte[] list) {
                System.out.println("sending");
                try {
                    for (byte byt : (byte[]) list) {
                        os.write(byt);
                    }
                } catch (IOException e) {
                    Assets.videoStopped = true;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Assets.videoStopped = true;
                }
                if (Assets.videoStopped == false) {
                    s.request(1);
                }
            }

            @Override
            public void onError(Throwable t) {
                Assets.videoStopped = true;
            }

            @Override
            public void onComplete() {

                System.out.println("video watched");
                Assets.videoWatched = true;
            }
        });
    }
}
