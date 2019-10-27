import {Association} from "../association/association";
import {Video} from "../video/video";

export class Project{
  id: number;
  title: string;
  description: string;
  imgPath: String;
  association: Association;
  videos: Video[];

  constructor() {

  }
}

