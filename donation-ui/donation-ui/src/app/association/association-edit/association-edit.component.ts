import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Association} from "../association";
import {ActivatedRoute, Router} from "@angular/router";
import {AssociationService} from "../association.service";

@Component({
  selector: 'app-association-edit',
  templateUrl: './association-edit.component.html',
  styleUrls: ['./association-edit.component.css']
})
export class AssociationEditComponent implements OnInit {

  private sub: Subscription;
  private association = new Association();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private associationService: AssociationService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = +params['id'];
      this.associationService.getAssociation(id)
        .then(association => this.association = association);
    });
  }

  onSubmit() {
    this.associationService.updateAssociation(this.association.id, this.association)
      .subscribe(data => alert(data), error => alert(error));
  }

  deleteAssociation() {
    this.associationService.deleteAssociation(this.association.id)
      .subscribe(data => alert(data), error => alert(error));
  }
}
