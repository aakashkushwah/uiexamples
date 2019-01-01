import { DataService } from './data.service';
import { BadInput } from './../common/bad-input';
import { AppError } from './../common/app-errors';
import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import { NotFoundError } from '../common/not-found-error';

@Injectable()
export class PostService extends DataService{

  constructor(http: Http) {
    super('https://jsonplaceholder.typicode.com/posts', http);
  }
}
