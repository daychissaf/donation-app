import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {ProjectService} from "../project.service";
import {Subscription} from "rxjs";
import {Project} from "../project";


@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {

  private sub : Subscription;
  project: Project;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private projectService: ProjectService) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      let id = +params['id'];
      this.getProject(id);
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  getProject(id: number) {
    this.projectService.getProject(id)
      .then(project => this.project = project);
  }

}
