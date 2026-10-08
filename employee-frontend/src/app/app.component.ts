import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  template: `
    <header class="topbar"><a routerLink="/">Employee Dashboard</a><a routerLink="/employees/new">Add employee</a></header>
    <main class="content"><router-outlet /></main>
  `,
  styles: [`
    .topbar{height:58px;background:#1e3a8a;color:white;display:flex;align-items:center;justify-content:space-between;padding:0 7vw}.topbar a{color:white;font-size:1rem;font-weight:700;text-decoration:none}.topbar a:first-child{font-size:1.15rem}.content{max-width:1100px;margin:0 auto;padding:32px 24px}
  `]
})
export class AppComponent {}