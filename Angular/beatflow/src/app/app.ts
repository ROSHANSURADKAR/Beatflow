import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router'; // <-- Add this

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet], // <-- Add this here
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App { }
