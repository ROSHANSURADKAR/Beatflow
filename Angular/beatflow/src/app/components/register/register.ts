import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { ApiService } from '../../services/api-service';

@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {


  user = { name: '', email: '', password: '', role: 'USER' };

  constructor(private api: ApiService, private router: Router) {}

  onRegister() {
    this.api.register(this.user).subscribe({
      next: () => {
        alert('Registration Successful! Please Login.');
        this.router.navigate(['/login']);
      },
      error: (err) => alert('Registration Failed: ' + err.error)
    });
  }
}
