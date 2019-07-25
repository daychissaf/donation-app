package com.donation;

import com.donation.crud.ProjectCrudService;
import com.donation.crud.VideoCrudService;
import com.donation.donor.model.Video;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoCrudService videoCrudService;

    @Autowired
    ProjectCrudService projectCrudService;


    @Override
    public List<Video> getVideosByProject(Long idProject) {

        return projectCrudService.getById(idProject).getVideos();
    }

    @Override
    public Video getRandomVideo(Long idProject) {
        Random random = new Random();
        List<Video> videos = getVideosByProject(idProject);
        Video video = videos.get(random.nextInt(videos.size()));
        return video;
    }

    public byte[] videoToBinaryData(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[2048];
        int read;
        while ((read = is.read(data)) > 0) {
            bos.write(data, 0, read);
        }
        byte[] b = bos.toByteArray();
        return b;
    }

    public List<byte[]> divideVideo(byte[] b) {

        int eachSize = b.length / 520;
        List<byte[]> listOfArrays = new ArrayList<>();
        for (int index = 0; index < 519; index++) {
            listOfArrays.add(Arrays.copyOfRange(b, eachSize * index, eachSize * (index + 1)));
        }
        listOfArrays.add(Arrays.copyOfRange(b, eachSize * 519, b.length));
        return listOfArrays;
    }

    @Override
    public void emitVideoFrames(final InputStream is, OutputStream os) throws IOException {

        byte[] b = videoToBinaryData(is);
        List<byte[]> videoChunks = divideVideo(b);
        Flux flux = Flux.just(videoChunks.toArray());

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
                if (!Assets.videoStopped) {
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
