import { Routes } from '@angular/router';
import { EmployeeListComponent } from './employees/employee-list.component';
import { EmployeeFormComponent } from './employees/employee-form.component';

export const routes: Routes = [
  { path: '', component: EmployeeListComponent },
  { path: 'employees/new', component: EmployeeFormComponent },
  { path: 'employees/:id/edit', component: EmployeeFormComponent },
  { path: '**', redirectTo: '' }
];