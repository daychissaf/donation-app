import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AssociationListComponent } from './association-list/association-list.component';
import { AssociationDetailComponent } from './association-detail/association-detail.component';
import {RouterModule} from "@angular/router";
import { AssociationAddComponent } from './association-add/association-add.component';
import { AssociationEditComponent } from './association-edit/association-edit.component';
import {FormsModule} from "@angular/forms";


@NgModule({

  declarations: [AssociationListComponent, AssociationDetailComponent, AssociationAddComponent, AssociationEditComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModules
  ]
})
export class AssociationModule { }
