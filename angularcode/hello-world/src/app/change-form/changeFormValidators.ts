import { AbstractControl } from '@angular/forms';

export class ChangeFormValidators{

    static validOldPwd(control : AbstractControl){
        return new Promise((resolve) => {
            if(control.value!== '1234'){
                resolve({invalidOldPwd:true});
            }else{
                resolve(null);
            }
        });
    }

    static shouldPwdMatch(control: AbstractControl){
        let newPwd = control.get('newPwd');
        let cnfPwd = control.get('cnfPwd');

        if(newPwd.value!==cnfPwd.value)
            return {pwdShouldMatch:true};
        return null;
    }
}