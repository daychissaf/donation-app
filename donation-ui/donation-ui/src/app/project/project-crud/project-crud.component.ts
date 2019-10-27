import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {ProjectService} from "../project.service";
import {Subscription} from "rxjs";
import {Project} from "../project";


@Component({
  selector: 'app-project-crud',
  templateUrl: './project-crud.component.html',
  styleUrls: ['./project-crud.component.css']
})
export class ProjectCrudComponent implements OnInit {

  private sub : Subscription;
  project: Project;


  constructor(private route: ActivatedRoute,
              private router: Router,
              private projectService: ProjectService,
              ) {

  }


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

  createProject(newProject: Project) {
    this.projectService.createProject(newProject);
  }


  deleteProject(idProject: number) {
    this.projectService.deleteProject(idProject);
  }

}
