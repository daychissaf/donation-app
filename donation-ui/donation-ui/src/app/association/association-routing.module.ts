import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AssociationEditComponent} from "./association-edit/association-edit.component";
import {AssociationAddComponent} from "./association-add/association-add.component";

const routes: Routes = [
  {path: 'editAssociation/:id', component: AssociationEditComponent},
  {path: 'addAssociation', component: AssociationAddComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AssociationRoutingModule {
}
