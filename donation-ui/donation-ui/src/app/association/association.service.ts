import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Association} from "./association";

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  private baseUrl='http://localhost:8080';

  constructor(private http : HttpClient) { }

  getAssociations() : Promise<Association[]> {
    return this.http.get(this.baseUrl + '/api/association')
      .toPromise()
      .then(response => response as Association[])
      .catch(this.handleError);
  }

  getAssociation(id: number): Promise<Association> {
    return this.http.get(this.baseUrl + '/api/associations/'+id)
      .toPromise()
      .then(response => response as Association)
      .catch(this.handleError);
  }

  createAssociation(){}
  updateAssociation(){}
  deleteAssociation(){}

  private handleError(error: any) : Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
