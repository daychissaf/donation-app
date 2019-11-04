import { Component, OnInit } from '@angular/core';
import {Association} from "../association";
import {AssociationService} from "../association.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-association-add',
  templateUrl: './association-add.component.html',
  styleUrls: ['./association-add.component.css']
})
export class AssociationAddComponent implements OnInit {

  association = new Association();

  constructor(private associationService: AssociationService,
              private modalService: NgbModal,
              ) { }

  ngOnInit() {
  }

  onSubmit() {
    this.associationService.createAssociation(this.association)
      .subscribe(data => alert(JSON.stringify(data)), error => alert(error));
  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true });
  }
}
