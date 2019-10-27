import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { ProjectEditComponent } from './project-edit/project-edit.component';
import {ProjectListComponent} from "./project-list/project-list.component";
import {ProjectDetailComponent} from "./project-detail/project-detail.component";
import {ProjectCrudComponent} from "./project-crud/project-crud.component";
import {ProjectAddComponent} from "./project-add/project-add.component";


@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule
  ]
})
export class ProjectModule {
}
