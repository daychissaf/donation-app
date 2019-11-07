import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AssociationListComponent} from './association-list/association-list.component';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";


@NgModule({

  declarations: [AssociationListComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
  ]
})
export class AssociationModule {
}
