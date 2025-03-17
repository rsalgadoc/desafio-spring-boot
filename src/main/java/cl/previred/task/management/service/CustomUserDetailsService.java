package cl.previred.task.management.service;

import cl.previred.task.management.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import cl.previred.task.management.repository.UserRepository;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found with email: " + email);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Collections.emptyList());
	}
}
