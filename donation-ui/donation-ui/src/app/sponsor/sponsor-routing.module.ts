import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {SponsorDetailComponent} from "./sponsor-detail/sponsor-detail.component";
import {SponsorEditComponent} from "./sponsor-edit/sponsor-edit.component";
import {SponsorAddComponent} from "./sponsor-add/sponsor-add.component";

const routes: Routes = [
  {path: 'sponsor/:id', component: SponsorDetailComponent},
  {path: 'editSponsor/:id', component: SponsorEditComponent},
  {path: 'addSponsor', component: SponsorAddComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class SponsorRoutingModule {
}
