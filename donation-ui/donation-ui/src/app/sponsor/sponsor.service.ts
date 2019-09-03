import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Project} from "../project/project";
import {Sponsor} from "./sponsor";

@Injectable({
  providedIn: 'root'
})
export class SponsorService {
  private baseUrl='http://localhost:8080';

  constructor(private http : HttpClient) { }

  getSponsors(): Promise<Sponsor[]> {
    return this.http.get(this.baseUrl + '/api/sponsor')
      .toPromise()
      .then(response => response as Sponsor[])
      .catch(this.handleError);
  }

  getSponsor(id: number): Promise<Sponsor> {
    return this.http.get(this.baseUrl + '/api/sponsors/'+id)
      .toPromise()
      .then(response => response as Sponsor)
      .catch(this.handleError);
  }

  createSponsor(){}
  updateSponsor(){}
  deleteSponsor(){}

  private handleError(error: any) : Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
