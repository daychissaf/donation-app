import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProjectListComponent} from "./project/project-list/project-list.component";
import {SponsorListComponent} from "./sponsor/sponsor-list/sponsor-list.component";
import {AssociationListComponent} from "./association/association-list/association-list.component";
import {VideoComponent} from "./video/video.component";
import {SignInUpComponent} from "./sign-in-up/sign-in-up.component";


const routes: Routes = [
  {path : "projects", component : ProjectListComponent},
  {path : "sponsors", component : SponsorListComponent},
  {path : "associations", component : AssociationListComponent},
  {path : "video", component : VideoComponent},
  {path : "login", component : SignInUpComponent},
  {path : "", redirectTo : "projects", pathMatch : "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
