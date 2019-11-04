import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {SponsorService} from "../sponsor.service";
import {Sponsor} from "../sponsor";

@Component({
  selector: 'app-sponsor-edit',
  templateUrl: './sponsor-edit.component.html',
  styleUrls: ['./sponsor-edit.component.css']
})
export class SponsorEditComponent implements OnInit {

  private sub: Subscription;
  sponsors: Sponsor[];
  private sponsor = new Sponsor();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private sponsorService: SponsorService,
  ) { }

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

  onSubmit() {
    this.sponsorService.updateSponsor(this.sponsor.id, this.sponsor)
      .subscribe(data => alert(JSON.stringify(data)), error => alert(error));
  }

  deleteSponsor() {
    this.sponsorService.deleteSponsor(this.sponsor.id)
      .subscribe(data => alert(JSON.stringify(data)), error => alert(error));
  }
}
