import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  template: `
    <section class="form-card"><h1>{{ editing ? 'Edit employee' : 'Add employee' }}</h1><p *ngIf="error" class="error">{{ error }}</p>
      <form (ngSubmit)="save()"><label>Name<input name="empName" [(ngModel)]="employee.empName" required></label><label>Department<input name="department" [(ngModel)]="employee.department" required></label><label>Salary<input name="salary" type="number" min="0" [(ngModel)]="employee.salary" required></label><div class="actions"><a routerLink="/employees">Cancel</a><button [disabled]="saving">{{ saving ? 'Saving...' : 'Save employee' }}</button></div></form>
    </section>
  `,
  styles: [`
    .form-card{max-width:540px;background:#fff;padding:28px;border-radius:10px;box-shadow:0 2px 10px #0001}.form-card h1{margin-top:0}label{display:block;margin-top:16px;font-weight:600}input{display:block;width:100%;box-sizing:border-box;margin-top:6px;padding:10px;border:1px solid #cbd5e1;border-radius:6px}.actions{display:flex;justify-content:space-between;align-items:center;margin-top:24px}.actions a{color:#2563eb}.actions button{padding:10px 14px;border:0;border-radius:6px;background:#2563eb;color:#fff;font-weight:700}.error{color:#b91c1c}
  `]
})
export class EmployeeFormComponent implements OnInit {
  employee: Employee = { empName: '', department: '', salary: 0 }; editing = false; saving = false; error = ''; private id?: number;
  constructor(private route: ActivatedRoute, private router: Router, private employeesApi: EmployeeService) {}
  ngOnInit(): void { const rawId = this.route.snapshot.paramMap.get('id'); if (rawId) { this.id = Number(rawId); this.editing = true; this.employeesApi.getById(this.id).subscribe({ next: e => this.employee = e, error: () => this.error = 'Employee not found.' }); } }
  save(): void { this.saving = true; const request = this.editing && this.id ? this.employeesApi.update(this.id, this.employee) : this.employeesApi.create(this.employee); request.subscribe({ next: () => this.router.navigateByUrl('/employees'), error: () => { this.error = 'Save failed.'; this.saving = false; } }); }
}