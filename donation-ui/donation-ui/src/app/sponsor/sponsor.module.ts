import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SponsorListComponent } from './sponsor-list/sponsor-list.component';
import { SponsorDetailComponent } from './sponsor-detail/sponsor-detail.component';
import { SponsorEditComponent } from './sponsor-edit/sponsor-edit.component';
import {RouterModule} from "@angular/router";



@NgModule({
  declarations: [SponsorListComponent, SponsorDetailComponent, SponsorEditComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class SponsorModule { }
