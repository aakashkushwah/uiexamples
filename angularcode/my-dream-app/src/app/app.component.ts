import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-dream-app';
  courses;
  isValid = true;

  onAdd(){
    this.courses.push({id:4, name:'course 4'});
  }

  onChange(course){
    //let index = this.courses.indexOf(course);
    //this.courses.splice(index, 1);
    course.name="Changed";
  }

  loadCourse(){
    this.courses = [
      {id:1,name:'course 1 '},
      {id:2,name:'course 2 '},
      {id:3,name:'course 3 '},
    ];
  }
}
