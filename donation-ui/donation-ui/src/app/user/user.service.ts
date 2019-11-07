import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl='http://localhost:8080';

  constructor(private httpClient: HttpClient) {

  }

  createUser(user: User) {
    // return this.http.post(this.baseUrl + '/api/account');
  }
}
