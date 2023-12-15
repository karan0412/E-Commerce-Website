package com.cs241.Group3.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cs241.Group3.User;
import com.cs241.Group3.Repository.UserRepository;


//@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userRepo.findByEmail(email);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new UserServiceImpl(user);
	}
	

}

