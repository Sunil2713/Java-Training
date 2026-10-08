import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({ providedIn: 'root' })
export class EmployeeService {
  private readonly api = 'http://localhost:8091/api/employees';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Employee[]> { return this.http.get<Employee[]>(this.api); }
  getById(id: number): Observable<Employee> { return this.http.get<Employee>(`${this.api}/${id}`); }
  create(employee: Employee): Observable<Employee> { return this.http.post<Employee>(this.api, employee); }
  update(id: number, employee: Employee): Observable<Employee> { return this.http.put<Employee>(`${this.api}/${id}`, employee); }
  delete(id: number): Observable<string> { return this.http.delete(`${this.api}/${id}`, { responseType: 'text' }); }
}