import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ProjectService} from "./project/project.service";
import { ProjectListComponent } from './project/project-list/project-list.component';
import {DashboardComponent} from "./carousel/carousel.component";
import { ProjectDetailComponent } from './project/project-detail/project-detail.component';
import { SponsorRoutingModule } from './sponsor/sponsor-routing.module';
import {ProjectRoutingModule} from "./project/project-routing.module";
import {AssociationRoutingModule} from "./association/association-routing.module";
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import {SponsorModule} from "./sponsor/sponsor.module";
import {AssociationModule} from "./association/association.module";
import {VideoModule} from "./video/video.module";
import { SignInUpComponent } from './sign-in-up/sign-in-up.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ProjectListComponent,
    ProjectDetailComponent,
    NavbarComponent,
    FooterComponent,
    SignInUpComponent
  ],
  imports: [
    BrowserModule,
    SponsorModule,
    AssociationModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    SponsorRoutingModule,
    ProjectRoutingModule,
    AssociationRoutingModule,
    VideoModule
  ],
  providers: [ProjectService],
  bootstrap: [AppComponent]
})
export class AppModule { }
