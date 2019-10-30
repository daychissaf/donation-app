import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {Project} from "../project";
import {Association} from "../../association/association";
import {ActivatedRoute, Router} from "@angular/router";
import {ProjectService} from "../project.service";
import {AssociationService} from "../../association/association.service";
import {VideoService} from "../../video/video.service";
import {Video} from "../../video/video";

@Component({
  selector: 'app-project-add',
  templateUrl: './project-add.component.html',
  styleUrls: ['./project-add.component.css']
})
export class ProjectAddComponent implements OnInit {


  project = new Project();
  associations: Association[];
  videos: Video[];

  constructor(private projectService: ProjectService,
              private associationService: AssociationService,
              private videoService: VideoService) { }

  ngOnInit(): void {
    this.associationService.getAssociations()
      .then(associations => this.associations = associations);
    this.videoService.getVideos()
      .then(videos => this.videos = videos);
  }

  onSubmit() {
    this.project.videos = this.videos;
    this.projectService.createProject(this.project)
      .subscribe(data => alert(data), error => alert(error));
  }

  onChange($event: Event, video: Video) {
    this.videos.push(video);
  }
}
