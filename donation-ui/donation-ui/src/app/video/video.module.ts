import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {VideoComponent} from './video.component';
import {NgbProgressbarModule} from "@ng-bootstrap/ng-bootstrap";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [VideoComponent],
  exports: [
    VideoComponent
  ],
  imports: [
    CommonModule,
    NgbProgressbarModule,
    RouterModule
  ]
})
export class VideoModule {
}
