package com.example.userapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository userRepo;
		
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "SignUp";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user, BindingResult bindingResult) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		
		BCryptPasswordEncoder confirmpasswordEncoder = new BCryptPasswordEncoder();
		String encodedconfirmPassword = confirmpasswordEncoder.encode(user.getConfirmPassword());
		user.setConfirmPassword(encodedconfirmPassword);
		userRepo.save(user);
		
//		// check if password match
//		if(user.getPassword() != null && user.getConfirmPassword() != null) {
//			if(!user.getPassword().equals(user.getConfirmPassword())) {
//				bindingResult.addError(new FieldError("user", "confirmPassword", "Passwords must match"));;
//			}
//		}
//		if(bindingResult.hasErrors()){
//			return "redirect:/registered_users";
//		}
		
		return "registered_users";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	
	// Update user
	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("/edit/{id}")
	public String updateUser(@PathVariable("id") Long userId, Model model) throws ResourceNotFoundException {
	    User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user id :" + userId));
	    model.addAttribute(user);
	    userRepo.equals(user);
	    return "update_user";
	    
	  }
	
	
	@PostMapping("/edit/{id}")
	public String update_User(User user, BindingResult bindingResult) throws ResourceNotFoundException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		
		BCryptPasswordEncoder confirmpasswordEncoder = new BCryptPasswordEncoder();
		String encodedconfirmPassword = confirmpasswordEncoder.encode(user.getConfirmPassword());
		user.setConfirmPassword(encodedconfirmPassword);
		userRepo.save(user);
		
		return "redirect:/users";
	}
	
	// Delete 
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	    User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    userRepo.delete(user);
	    return "redirect:/users";
	}
}

