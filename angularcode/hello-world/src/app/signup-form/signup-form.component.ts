import { UsernameValidators } from './username.validators';
import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray, FormBuilder } from '@angular/forms';

@Component({
  selector: 'signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent {
  form = new FormGroup({
    username: new FormControl('',[
      Validators.required,
      Validators.minLength(4),
      UsernameValidators.cannotContainSpace
    ], UsernameValidators.shouldBeUnique),
    password: new FormControl('', Validators.required),
    topics: new FormArray([])
  });

  constructor(fb: FormBuilder){

  }
  get username(){
    return this.form.get('username');
  }

  get password(){
    return this.form.get('password');
  }

  login(){
    this.form.setErrors({
      invalidLogin : false
    });
  }

  get topics(){
    return (this.form.get('topics') as FormArray);
  }

  addTopic(topic: HTMLInputElement){
    this.topics.push(new FormControl(topic.value));
    topic.value='';
  }

  removeTopic(topic: FormControl){
    let index = this.topics.controls.indexOf(topic);
    this.topics.removeAt(index);
  }
}
