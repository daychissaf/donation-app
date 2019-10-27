import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AssociationListComponent } from './association-list/association-list.component';
import { AssociationDetailComponent } from './association-detail/association-detail.component';
import {RouterModule} from "@angular/router";



@NgModule({
  declarations: [AssociationListComponent, AssociationDetailComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class AssociationModule { }
