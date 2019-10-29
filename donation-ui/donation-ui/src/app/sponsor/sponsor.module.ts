import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SponsorListComponent } from './sponsor-list/sponsor-list.component';
import { SponsorDetailComponent } from './sponsor-detail/sponsor-detail.component';
import { SponsorEditComponent } from './sponsor-edit/sponsor-edit.component';
import {RouterModule} from "@angular/router";
import { SponsorAddComponent } from './sponsor-add/sponsor-add.component';
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [SponsorListComponent, SponsorDetailComponent, SponsorEditComponent, SponsorAddComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ]
})
export class SponsorModule { }
