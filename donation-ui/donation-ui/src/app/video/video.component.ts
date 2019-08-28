import {Component, OnInit} from '@angular/core';
import {VideoService} from "./video.service";
import {Video} from "./video";

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})
export class VideoComponent implements OnInit {

  private video : Video;
  constructor(private videoService: VideoService) {

    document.addEventListener("visibilitychange", function () {
      var vid = <HTMLVideoElement>document.getElementById("myVideo");
      var state = document.visibilityState;
      if (!vid.paused && state == "hidden") {
        vid.pause();
      }
      if (vid.paused && state == "visible" && document.getElementById("play").style.display == "none") {
        vid.play();
      }
    })
  }

  ngOnInit() {
    this.getVideo();
  }

  playVid() {
    var vid = <HTMLVideoElement>document.getElementById("myVideo");
    vid.play();
    document.getElementById("play").style.display = "none";

  }

  getVideo() {
    this.videoService.getVideo()
      .then(video => this.video = video);
  }
}
