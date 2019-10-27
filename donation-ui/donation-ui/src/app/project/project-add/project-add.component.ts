import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {Project} from "../project";
import {Association} from "../../association/association";
import {ActivatedRoute, Router} from "@angular/router";
import {ProjectService} from "../project.service";
import {AssociationService} from "../../association/association.service";

@Component({
  selector: 'app-project-add',
  templateUrl: './project-add.component.html',
  styleUrls: ['./project-add.component.css']
})
export class ProjectAddComponent implements OnInit {


  project: Project;
  associations: Association[];

  constructor(private projectService: ProjectService,
              private associationService: AssociationService,) { }

  ngOnInit(): void {
    this.getAssociations();
  }


  getAssociations() {
    this.associationService.getAssociations()
      .then(associations => this.associations = associations);
  }

  createProject() {
    if (this.project.title != null) {
      this.projectService.createProject(this.project);
    }
  }

}
