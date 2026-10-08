package com.example.employeeapi.exception;
 
public class ResourceNotFoundException extends RuntimeException {
 
   public ResourceNotFoundException(String message) {
       super(message);
   }
}