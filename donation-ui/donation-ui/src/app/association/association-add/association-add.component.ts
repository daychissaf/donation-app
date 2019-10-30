import { Component, OnInit } from '@angular/core';
import {Association} from "../association";
import {AssociationService} from "../association.service";

@Component({
  selector: 'app-association-add',
  templateUrl: './association-add.component.html',
  styleUrls: ['./association-add.component.css']
})
export class AssociationAddComponent implements OnInit {

  association = new Association();

  constructor(private associationService: AssociationService,
              ) { }

  ngOnInit() {
  }

  onSubmit() {
    this.associationService.createAssociation(this.association)
      .subscribe(data => alert(data), error => alert(error));
  }
}
