package com.training.controller;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.training.form.LoginForm;
import com.training.model.User;
import com.training.service.UserService;
 
@Controller
public class LoginController {
@Autowired
UserService userService;
 
@GetMapping("/login")
public String login(Model model) {
model.addAttribute("loginForm",new LoginForm());
return "login";
}
@PostMapping("/login")
public String processLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
BindingResult result,
Model model)
{
 
        // Check validation errors
 
        if (result.hasErrors()) {
            return "login";
        }
 
        
User user = userService.isValidUser(loginForm.getEmail(), loginForm.getPassword());
if(user!=null) {
model.addAttribute("user",user);
return "dashboard";
}
// Login failed
        model.addAttribute("error",
                "Invalid email or password");
 
        return "login";
}
 
}