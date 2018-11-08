import { AuthorService } from './../author.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {
  authors;

  constructor(service: AuthorService) {
    this.authors = service.getAuthors();
  }

  ngOnInit() {
  }

}
