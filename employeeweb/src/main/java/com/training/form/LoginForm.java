package com.training.form;
 
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
public class LoginForm {
@NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
private String email;
@NotBlank(message = "Password is required")
@Size(min = 6, message = "Password must contain at least 6 characters")
private String password;
 
public String getEmail() {
return email;
}
 
public void setEmail(String email) {
this.email = email;
}
 
public String getPassword() {
return password;
}
 
public void setPassword(String password) {
this.password = password;
}
public LoginForm() {
}
 
}