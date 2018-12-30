import { ChangeFormValidators } from './changeFormValidators';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Component } from '@angular/core';

@Component({
  selector: 'change-form',
  templateUrl: './change-form.component.html',
  styleUrls: ['./change-form.component.css']
})
export class ChangeFormComponent {
  form: FormGroup;
  constructor(fb: FormBuilder) {
    this.form = fb.group({
      curPwd: ['',Validators.required, ChangeFormValidators.validOldPwd],
      newPwd: ['',Validators.required],
      cnfPwd: ['',Validators.required]
    }, {
      validator: ChangeFormValidators.shouldPwdMatch
    })
   }

   get curPwd(){
     return this.form.get('curPwd');
   }

   get newPwd(){
    return this.form.get('newPwd');
   }

   get cnfPwd(){
    return this.form.get('cnfPwd');
   }


}
