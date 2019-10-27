import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ProjectDetailComponent} from "../project/project-detail/project-detail.component";
import {SponsorDetailComponent} from "./sponsor-detail/sponsor-detail.component";

const routes: Routes = [
  { path: 'sponsor/:id', component: SponsorDetailComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class SponsorRoutingModule {}
