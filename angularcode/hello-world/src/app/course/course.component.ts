import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CoursesService } from '../courses.service';

@Component({
  selector: 'app-course',
  templateUrl : './course.component.html'
})
export class CourseComponent implements OnInit {

  title = "List of courses";
  courses ;
  coursesCount;
  colspan = 2;
  isActive = false;
  email = "me@abc.com";
  sampleTitle : string;
  @Input('akinput') ix:boolean;
  @Output() change = new EventEmitter();

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

  onClick(){
    this.change.emit();
  }


  ngOnInit() {
  }

}
