import {Injectable} from "@angular/core";
import {Project} from "./project";

import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, retry} from "rxjs/operators";
import {Observable} from "rxjs";
import {AuthenticationService} from "../authentication/authentication.service";
import {User} from "../user/user";

@Injectable()
export class ProjectService {
  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

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

  createProject(project: Project) {

    return this.http.post('/api/projects/', project);

  }

  updateProject(id: number, newProjectData: Project): Observable<unknown> {
    alert("got to service");
    return this.http.put('/api/projects/'+ id, JSON.stringify(newProjectData), this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));

  }

  deleteProject(id: number) {

    return this.http.delete('/api/projects/' + id);

  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }

}
