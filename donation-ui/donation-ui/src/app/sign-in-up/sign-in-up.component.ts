
import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../authentication/authentication.service";
import {NgForm} from "@angular/forms";


@Component({
  selector: 'app-sign-in-up',
  templateUrl: './sign-in-up.component.html',
  styleUrls: ['./sign-in-up.component.css']
})


export class SignInUpComponent implements OnInit {
  email = "didnt change";
  password = "didnt change";

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
  }


  onSignIn(f: NgForm) {
    this.authenticationService.login(this.email, this.password);

  }
}
