
import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../user/user";

@Injectable({
  providedIn: 'root'
})
export class SignInUpService {

  constructor(private  http: HttpClient) {

  }

  signIn() {

  }

  signUp(user: User) {
    return this.http.post('/api/account', {user});
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
