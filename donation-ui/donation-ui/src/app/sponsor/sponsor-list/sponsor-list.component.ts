import { Component, OnInit } from '@angular/core';
import {Sponsor} from "../sponsor";
import {SponsorService} from "../sponsor.service";

@Component({
  selector: 'app-sponsor-list',
  templateUrl: './sponsor-list.component.html',
  styleUrls: ['./sponsor-list.component.css']
})
export class SponsorListComponent implements OnInit {

  sponsors : Sponsor[];

  constructor(private sponsorService : SponsorService) { }

  ngOnInit() {
    this.getSponsors();
  }

  private getSponsors() {
    this.sponsorService.getSponsors()
      .then(sponsors => this.sponsors = sponsors);
  }
}
