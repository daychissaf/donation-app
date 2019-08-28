import { Component, OnInit } from '@angular/core';
import {Association} from "../association";
import {AssociationService} from "../association.service";

@Component({
  selector: 'app-association-list',
  templateUrl: './association-list.component.html',
  styleUrls: ['./association-list.component.css']
})
export class AssociationListComponent implements OnInit {

  associations: Association[];

  constructor(private associationService : AssociationService) { }

  ngOnInit() {
    this.getAssociations();
  }

  private getAssociations() {
    this.associationService.getAssociations()
      .then(associations => this.associations = associations);
  }

}
