import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ProjectDetailComponent} from "./project-detail/project-detail.component";
import {ProjectEditComponent} from "./project-edit/project-edit.component";
import {ProjectAddComponent} from "./project-add/project-add.component";

const routes: Routes = [
  {path: 'project/:id', component: ProjectDetailComponent},
  {path: 'editProject/:id', component: ProjectEditComponent},
  {path: 'addProject', component: ProjectAddComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class ProjectRoutingModule {
}
