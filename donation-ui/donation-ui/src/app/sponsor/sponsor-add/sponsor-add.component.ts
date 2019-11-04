import { Component, OnInit } from '@angular/core';
import {Sponsor} from "../sponsor";
import {SponsorService} from "../sponsor.service";

@Component({
  selector: 'app-sponsor-add',
  templateUrl: './sponsor-add.component.html',
  styleUrls: ['./sponsor-add.component.css']
})
export class SponsorAddComponent implements OnInit {
  sponsor= new Sponsor();

  constructor(private sponsorService: SponsorService,
              ) { }

  ngOnInit() {
  }

  onSubmit() {
    this.sponsorService.createSponsor(this.sponsor)
      .subscribe(data => alert(JSON.stringify(data)), error => alert(error));
  }
}
