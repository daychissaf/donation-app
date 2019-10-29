import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Project} from "../project/project";
import {Sponsor} from "./sponsor";
import {catchError, retry} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class SponsorService {
  private baseUrl='http://localhost:8080';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

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

  updateSponsor(id: number, newSponsorData: Sponsor) {
    return this.http.put('/api/sponsors/'+ id, JSON.stringify(newSponsorData), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  deleteSponsor(){}

  private handleError(error: any) : Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
