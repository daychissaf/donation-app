import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Association} from "./association";
import {catchError, count, retry} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http : HttpClient) { }

  getAssociations() : Promise<Association[]> {
    return this.http.get('/api/association')
      .toPromise()
      .then(response => response as Association[])
      .catch(this.handleError);
  }

  getAssociation(id: number): Promise<Association> {
    return this.http.get('/api/associations/'+id)
      .toPromise()
      .then(response => response as Association)
      .catch(this.handleError);
  }

  createAssociation(association: Association){
    return this.http.post('/api/associations/', JSON.stringify(association), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }
  updateAssociation(id: number, newAssociationData: Association) {
    return this.http.put('/api/associations/'+ id, JSON.stringify(newAssociationData), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }
  deleteAssociation(id: number){
    return this.http.delete('/api/associations/'+ id, this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  private handleError(error: any) : Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
