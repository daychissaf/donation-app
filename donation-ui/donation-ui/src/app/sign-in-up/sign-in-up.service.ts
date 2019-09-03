import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Project} from "../project/project";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class SignInUpService {

  private baseUrl='http://localhost:8080';

  constructor(private  http: HttpClient) {

  }

  signIn() {
    // return this.http.
    // get(this.baseUrl + '/api/account')
    //   .toPromise()
    //   .then(response => response as Project[])
    //   .catch(this.handleError);
  }

  signUp(username, password) {
    // return this.http.post(this.baseUrl + '/api/authenticate',{username, password})
    //   .pipe(
    //     map(
    //       userData => {
    //         sessionStorage.setItem('username', username);
    //         let tokenStr = 'Bearer '+userData.token;
    //         sessionStorage.setItem('token', tokenStr);
    //         return userData;
    //       }
    //     )
    //   )
  }

  private handleError(error: any) : Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
