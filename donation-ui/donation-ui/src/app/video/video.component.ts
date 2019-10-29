import {Component, Input, OnInit} from '@angular/core';
import {VideoService} from "./video.service";
import {Video} from "./video";
import {NgbActiveModal, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})
export class VideoComponent implements OnInit {

  private video : Video;
  private barValue = 0;
  private interval: any;
  name: any;
  constructor(private videoService: VideoService,
              private modalService: NgbModal) {

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
    var bar = document.getElementById("myBar");
    vid.play();
    document.getElementById("play").style.display = "none";
    this.move();

  }

  getVideo() {
    this.videoService.getVideo()
      .then(video => this.video = video);
  }

  move() {

    this.interval = setInterval(() => {
      if(this.barValue < 100) {
        this.barValue++;
      }
      else {
        clearInterval(this.interval);
      }
    }, 200);

  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true });
  }

}
