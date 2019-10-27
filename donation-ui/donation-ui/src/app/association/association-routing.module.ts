import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AssociationDetailComponent} from "./association-detail/association-detail.component";

const routes: Routes = [
  {path : 'association/:id', component : AssociationDetailComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AssociationRoutingModule {}
