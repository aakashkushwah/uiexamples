import { Component, OnInit, Input, Output, EventEmitter, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})

export class FavoriteComponent implements OnInit {
  @Input() isFav : boolean = true;
  @Output() change = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

  onClick(){
    this.isFav = !this.isFav;
    this.change.emit({newValue: this.isFav});
  }
}

export interface FavArgs{
  newValue : boolean
}
