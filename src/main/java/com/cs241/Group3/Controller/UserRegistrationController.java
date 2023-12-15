package com.cs241.Group3.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs241.Group3.User;
import com.cs241.Group3.Repository.UserRepository;



@Controller
@RequestMapping("/CreateAccount")
@SessionAttributes({"user"})
public class UserRegistrationController {
		
		@Autowired
		private UserRepository userepo;
		@ModelAttribute("user")
		public User user() {
			return new User();
		}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "CreateAccount";
	}
	
	@PostMapping
	public String saveDetails(@ModelAttribute("user") User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userepo.save(user);
		return "SignIn";
	}
	
}
