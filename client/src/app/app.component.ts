import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, DELETE, PUT'
    })
  };

  constructor(private http: HttpClient) {}


  getAll() {
    this.http.get('http://localhost:8080/student/getAll', this.httpOptions).subscribe(value => {
      console.log(value);
    });
  }
}
