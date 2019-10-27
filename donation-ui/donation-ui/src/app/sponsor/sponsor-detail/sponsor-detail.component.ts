import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SponsorService} from "../sponsor.service";
import {Subscription} from "rxjs";
import {Sponsor} from "../sponsor";

@Component({
  selector: 'app-sponsor-detail',
  templateUrl: './sponsor-detail.component.html',
  styleUrls: ['./sponsor-detail.component.css']
})
export class SponsorDetailComponent implements OnInit {

  private sub: Subscription;
  private sponsor: Sponsor;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private sponsorService: SponsorService,) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = +params['id'];
      this.getSponsor(id);
    });
  }

  private getSponsor(id: number) {
    this.sponsorService.getSponsor(id)
      .then(sponsor => this.sponsor = sponsor);
  }

}
