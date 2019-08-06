import {Injectable} from "@angular/core";
import {Project} from "../models/project";

import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable()
export class ProjectService {
  private baseUrl='http://localhost:8080';
  constructor( private  http: HttpClient) {}

  getProjects(): Promise<Project[]> {
    return this.http.get(this.baseUrl + '/api/project/')
      .toPromise()
      .then(response => response as Project[])
      .catch(this.handleError);
  }

  private handleError(error: any) : Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
