import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProjectListComponent} from "./project/project-list/project-list.component";
import {SponsorListComponent} from "./sponsor/sponsor-list/sponsor-list.component";
import {AssociationListComponent} from "./association/association-list/association-list.component";
import {SignInUpComponent} from "./sign-in-up/sign-in-up.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./guards";


const routes: Routes = [
  {path: "projects", component: ProjectListComponent},
  {path: "sponsors", component: SponsorListComponent},
  {path: "associations", component: AssociationListComponent},
  {path: "login", component: LoginComponent},
  {path: "", redirectTo: "projects", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
