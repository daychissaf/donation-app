import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Video} from "./video";

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  constructor(private http : HttpClient) { }

  getVideo(): Promise<Video> {
    return this.http.get('/api/video/1')
      .toPromise()
      .then(response => response as Video)
      .catch(this.handleError);
  }

  getVideos(): Promise<Video[]> {
    return this.http.get('/api/')
      .toPromise()
      .then(response => response as Video[])
      .catch(this.handleError);
  }

  private handleError(error: any) : Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
