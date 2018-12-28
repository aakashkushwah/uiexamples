import { FavArgs } from './favorite/favorite.component';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Aakash Sample';
  ix = false;
  post = {
    isFavorite : false,
    title:"Title"
  }

  onCourseChanged(){
    console.log('course section was clicked');
  }

  onFavChanged(eventArgs : FavArgs){
    console.log("favorite changed ",eventArgs.newValue);
  }

  tweet = {
    body: '...',
    likesCount: 10,
    isLiked:true
  }
  canSave=true;

  task = {
    title : 'Review App',
    assignee: null
  }
  
}
