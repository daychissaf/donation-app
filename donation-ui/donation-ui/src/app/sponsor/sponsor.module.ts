import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SponsorListComponent } from './sponsor-list/sponsor-list.component';
import { SponsorDetailComponent } from './sponsor-detail/sponsor-detail.component';



@NgModule({
  declarations: [SponsorListComponent, SponsorDetailComponent],
  imports: [
    CommonModule
  ]
})
export class SponsorModule { }
