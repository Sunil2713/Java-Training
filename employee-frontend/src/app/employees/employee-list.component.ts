import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <section class="page-header"><div><h1>Employee Dashboard</h1><p>View, add, edit, and delete employees.</p></div><a routerLink="/employees/new" class="primary">Add employee</a></section>
    <p *ngIf="error" class="error">{{ error }}</p>
    <p *ngIf="loading">Loading employees...</p>
    <div class="table-wrap" *ngIf="!loading && !error"><table><thead><tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th><th>Actions</th></tr></thead><tbody>
      <tr *ngFor="let employee of employees"><td>{{ employee.empId }}</td><td>{{ employee.empName }}</td><td>{{ employee.department }}</td><td>{{ employee.salary | currency:'INR':'symbol':'1.2-2' }}</td><td><a [routerLink]="['/employees', employee.empId, 'edit']">Edit</a><button class="delete" (click)="remove(employee)">Delete</button></td></tr>
      <tr *ngIf="employees.length === 0"><td colspan="5">No employees found.</td></tr>
    </tbody></table></div>
  `,
  styles: [`
    .page-header{display:flex;justify-content:space-between;align-items:center;margin-bottom:24px}.page-header h1{margin:0}.page-header p{margin:.4rem 0;color:#64748b}.primary{background:#2563eb;color:white;padding:10px 14px;border-radius:6px;text-decoration:none}.table-wrap{background:white;border-radius:10px;overflow:auto;box-shadow:0 2px 10px #0001}table{width:100%;border-collapse:collapse}th,td{padding:14px;text-align:left;border-bottom:1px solid #e2e8f0}th{background:#f8fafc}.delete{margin-left:12px;border:0;background:none;color:#dc2626;cursor:pointer;font:inherit}.error{color:#b91c1c}
  `]
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = []; loading = true; error = '';
  constructor(private employeesApi: EmployeeService) {}
  ngOnInit(): void { this.load(); }
  load(): void { this.loading = true; this.employeesApi.getAll().subscribe({ next: employees => { this.employees = employees; this.loading = false; }, error: () => { this.error = 'Could not reach the API. Start employeeapi on port 8091.'; this.loading = false; } }); }
  remove(employee: Employee): void { if (employee.empId && confirm(`Delete ${employee.empName}?`)) this.employeesApi.delete(employee.empId).subscribe({ next: () => this.load(), error: () => this.error = 'Delete failed.' }); }
}