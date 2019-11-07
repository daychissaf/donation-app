import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SponsorListComponent} from './sponsor-list/sponsor-list.component';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";


@NgModule({

  declarations: [SponsorListComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ]
})
export class SponsorModule {
}
