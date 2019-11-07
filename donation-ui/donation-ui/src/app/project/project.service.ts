import {Injectable} from "@angular/core";
import {Project} from "./project";

import {HttpClient} from '@angular/common/http';
import {AuthenticationService} from "../authentication/authentication.service";

@Injectable()
export class ProjectService {

  constructor(private  http: HttpClient,
              private authenticationService: AuthenticationService) {
  }

  getProjects(): Promise<Project[]> {
    return this.http.get('/api/project/')
      .toPromise()
      .then(response => response as Project[])
      .catch(this.handleError);
  }

  getProject(id: number): Promise<Project> {
    return this.http.get('/api/project/' + id)
      .toPromise()
      .then(response => response as Project)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
