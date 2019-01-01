import { BadInput } from './../common/bad-input';
import { NotFoundError } from './../common/not-found-error';
import { AppError } from './../common/app-errors';
import { Component, OnInit } from '@angular/core';
import { post } from 'selenium-webdriver/http';
import { PostService } from '../services/post.service';

@Component({
  selector: 'posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit{
  ngOnInit(): void {
    this.service.getAll()
      .subscribe(response => this.posts = response);
  }

  posts: any[];
  

  constructor(private service: PostService) {
    
  }

  createPost(titleInput : HTMLInputElement){
    let post:any = {title: titleInput.value};
    titleInput.value = '';
    this.service.create(post)
      .subscribe(response => {
        post.id = response.json().id;
        this.posts.splice(0, 0, post);
        console.log(response.json())
      }, (error : AppError) => {
        if(error instanceof BadInput)
          console.log(error.originalError);
        else
          throw error;
      });
  }

  updatePost(post){
    this.service.update(post)
      .subscribe(response=>{
        console.log(response.json());
      });
  }

  deletePost(post){
    this.service.delete(post.id)
      .subscribe(
        response=> {
        console.log(response.json());
        let index = this.posts.indexOf(post);
        this.posts.splice(index, 1);
         }, 
        (error : AppError) => {
          if(error instanceof NotFoundError){
            alert("post is already deleted");
          }else{
            throw error;
          }
        }
      );
  }

}
