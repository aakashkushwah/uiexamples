import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
    name: 'mytitlecase'
})
export class MyTitleCasePipe implements PipeTransform{
    transform(value: string) {
        if(!value){
            return null;
        }
        
        let words = value.split(" ");
        for(var i=0;i<words.length;i++){
            let word = words[i];
            if(i>0 && this.isPrepos(word)){
                words[i] = word.toLowerCase();
            }else{
                words[i] = this.toTitleCase(word);
            }
        }
        return words.join(' ');
    }

    private isPrepos(word:string):boolean {
        let props = ["of", "the"];
        return props.includes(word.toLowerCase());
    }

    private toTitleCase(word:string):string {
        return word.substr(0,1).toUpperCase()+word.substr(1).toLowerCase();
    }

} 