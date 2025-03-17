package cl.previred.task.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.previred.task.management.entities.User;
import cl.previred.task.management.service.UserService;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> allUsers() {
		List<User> users = userService.allUsers();

		return ResponseEntity.ok(users);
	}
}
