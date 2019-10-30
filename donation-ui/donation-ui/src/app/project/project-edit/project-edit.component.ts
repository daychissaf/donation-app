import {Component, OnInit} from '@angular/core';
import {ProjectService} from "../project.service";
import {Project} from "../project";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {AssociationService} from "../../association/association.service";
import {Association} from "../../association/association";
import {Video} from "../../video/video";
import {VideoService} from "../../video/video.service";

@Component({
  selector: 'app-project-edit',
  templateUrl: './project-edit.component.html',
  styleUrls: ['./project-edit.component.css']
})
export class ProjectEditComponent implements OnInit {
  project: Project = new Project();
  res: any;
  associations: Association[];

  private sub: Subscription;
  videos: Video[];
  newVideos: Video[];

  constructor(
    private projectService: ProjectService,
    private route: ActivatedRoute,
    private router: Router,
    private associationService: AssociationService,
    private videoService: VideoService,
  ) {

  }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      let id = +params['id'];
      this.projectService.getProject(id)
        .then(project => this.project = project);
    });

    this.associationService.getAssociations()
      .then(associations => this.associations = associations);
    this.videoService.getVideos()
      .then(videos => this.videos = videos);
  }

  onSubmit() {
    this.updateProject();
  }

  updateProject() {
    this.project.videos = this.newVideos;
    this.projectService.updateProject(this.project.id, this.project)
      .subscribe(data => alert(data), error => alert(error));
  }

  deleteProject() {
    this.projectService.deleteProject(this.project.id)
      .subscribe(data => alert(data), error => alert(error));
  }

  onChange($event: Event, video: Video) {
    this.newVideos.push(video);
  }
}
