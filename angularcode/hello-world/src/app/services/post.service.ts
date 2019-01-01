import { BadInput } from './../common/bad-input';
import { AppError } from './../common/app-errors';
import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import { NotFoundError } from '../common/not-found-error';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private url = "https://jsonplaceholder.typicode.com/posts";
  constructor(private http: Http) {

  }

  getPosts() {
    return this.http.get(this.url)
      .map(response => response.json())
      .catch(this.handleError);
  }

  postSinglePost(post) {
    return this.http.post(this.url, JSON.stringify(post))
      .catch(this.handleError);
  }

  updatePost(post) {
    return this.http.patch(this.url + "/" + post.id, JSON.stringify({ isRead: true })).catch(this.handleError);
  }

  deletePost(id) {
    return this.http.delete(this.url + "/" + id)
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    if (error.status === 400) {
      return Observable.throw(new BadInput(error.json()));
    }
    if (error.status === 404) {
      return Observable.throw(new NotFoundError());
    }
    return Observable.throw(new AppError(error.json()));
  }
}
