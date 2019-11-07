import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Sponsor} from "./sponsor";

@Injectable({
  providedIn: 'root'
})
export class SponsorService {

  constructor(private http: HttpClient) {
  }

  getSponsors(): Promise<Sponsor[]> {
    return this.http.get('/api/sponsor')
      .toPromise()
      .then(response => response as Sponsor[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
