package com.donation.web;

import com.donation.crud.VideoCrudService;
import com.donation.donor.model.Video;
import com.donation.web.crud.Assets;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import reactor.core.publisher.Flux;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/stream")
public class VideoStreamingController {

    @Autowired
    private VideoCrudService videoCrudService;

    private List<Video> videos = new ArrayList<Video>();

    @GetMapping("/{idProject}")
    public StreamingResponseBody stream(@PathVariable Long idProject) throws FileNotFoundException {
        Random random = new Random();
        videos = videoCrudService.getVideosByProject(idProject);
        Video video = videos.get(random.nextInt(videos.size()));
        File videoFile = new File(video.getLink());
        final InputStream videoFileStream = new FileInputStream(videoFile);
        return (os) -> {
            readAndWrite(videoFileStream, os);
        };
    }

    private void readAndWrite(final InputStream is, OutputStream os)
            throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[2048];
        int read;
        while ((read = is.read(data)) > 0) {
            bos.write(data, 0, read);
        }
        //******************************
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
                    Assets.videoStopped=true;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Assets.videoStopped=true;
                }
                if (Assets.videoStopped == false) {
                    s.request(1);
                }
            }

            @Override
            public void onError(Throwable t) {
                Assets.videoStopped=true;
            }

            @Override
            public void onComplete() {

                System.out.println("video watched");
                Assets.videoWatched = true;
            }
        });
    }
}
