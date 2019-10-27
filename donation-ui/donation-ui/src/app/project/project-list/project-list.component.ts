import { Component, OnInit } from '@angular/core';
import { Project} from "../project";
import {ProjectService} from "../project.service";
import {User} from "../../user/user";

@Component({
  selector: 'project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  projects: Project[];

  constructor(
    private projectService: ProjectService,
  ) {}


  ngOnInit(): void{
    this.getProjects();
  }


  private getProjects() {
    this.projectService.getProjects()
      .then(projects => this.projects = projects);
  }

}
