import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../courses.service';

@Component({
  selector: 'app-course',
  template : `
    <table>
      <tr>
        <td [attr.colspan]>
        </td>
      </tr>
    </table>
    <button class="btn btn-primary" [class.active]="isActive">Save</button>
    <button [style.backgroundColor] = "isActive? 'blue' : 'yellow'">Save2</button>
    <br>
    <button (click) = "onSave($event)">Save3</button>
    <br>
    <input [value]="email" (keyup.enter)="email = $event.target.value; onKeyUp()"/>
    <input [(ngModel)] = "email" (keyup.enter) = "onKeyUp()"/>
    <br>
    {{ pipers.title | uppercase}}
    <br>
    {{ pipers.rating | number:'2.1-1'}}
    <br>
    {{ pipers.students |number}}
    <br>
    {{ pipers.price | currency:'INR':true:'3.2-2'}}
    <br>
    {{ pipers.releaseDate |date:'short'}}
    <br>
    {{text | summary}}
  `
})
export class CourseComponent implements OnInit {

  title = "List of courses";
  courses ;
  coursesCount;
  colspan = 2;
  isActive = false;
  email = "me@abc.com";

  pipers = {
    title: "The complete shock",
    rating: 4.978,
    students:34563,
    price:10.95,
    releaseDate: new Date(2018,12,11)
  }

  text =  "List of courses is supposed to be a very long string but I am not sure it is that";
  constructor(service: CoursesService) {
    this.courses = service.getCourses();
    this.coursesCount = service.getCoursesCount();
  }

  onSave($event){
    console.log("Hi from Save3 ",$event);
  }

  onKeyUp(){
    console.log(this.email);
  }


  ngOnInit() {
  }

}
