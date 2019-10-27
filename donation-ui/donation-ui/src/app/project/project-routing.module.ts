import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ProjectDetailComponent} from "./project-detail/project-detail.component";
import {ProjectCrudComponent} from "./project-crud/project-crud.component";
import {ProjectEditComponent} from "./project-edit/project-edit.component";
import {ProjectAddComponent} from "./project-add/project-add.component";
import {AuthGuard} from "../guards";

const routes: Routes = [
  {path: 'project/:id', component: ProjectDetailComponent},
  {path: 'projects/:id', component: ProjectCrudComponent},
  {path: 'editProject/:id', component: ProjectEditComponent},
  {path: 'addProject', component: ProjectAddComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class ProjectRoutingModule {
}
