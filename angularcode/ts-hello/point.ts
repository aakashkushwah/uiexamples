export class Point{
    
    constructor(private x?:number,public y?:number){
    }

    draw(){
        console.log("drawing "+this.x+" "+this.y);
    }

}