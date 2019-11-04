import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AssociationListComponent} from './association-list/association-list.component';
import {RouterModule} from "@angular/router";
import {AssociationAddComponent} from './association-add/association-add.component';
import {AssociationEditComponent} from './association-edit/association-edit.component';
import {FormsModule} from "@angular/forms";


@NgModule({

  declarations: [AssociationListComponent, AssociationAddComponent, AssociationEditComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
  ]
})
export class AssociationModule {
}
