import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Association} from "./association";

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  constructor(private http: HttpClient) {
  }

  getAssociations(): Promise<Association[]> {
    return this.http.get('/api/association')
      .toPromise()
      .then(response => response as Association[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
