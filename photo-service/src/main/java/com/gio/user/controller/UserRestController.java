package com.gio.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gio.model.user.User;
import com.gio.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserService userService;

	// -------------------Retrieve All Users----------------------------------
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listUser() {
		List<User> users = userService.listUser();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single User------------------
	@RequestMapping(value = "/single/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		LOGGER.info("Fetching User with id {}", id);
		User user = userService.getUserById(id);
		if (user == null) {
			LOGGER.error("User with id {} not found.", id);
			return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// -------------------Create User-------------------------
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		LOGGER.info("Creating User : {}", user);
		if (userService.isUserExist(user)) {
			LOGGER.error("Unable to create. A User with name {} already exist", user.getName());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		userService.addUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	// ------------------- Update a User-----------------------
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody User user) {
		LOGGER.info("Updating User with id {}", id);
		User userId = userService.findById(id);

		if (userId == null) {
			LOGGER.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userId.setName(user.getName());
		userId.setApaterno(user.getApaterno());

		userService.update(userId);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	//------------------- Delete a User ------------------------
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
		LOGGER.info("Fetching & Deleting User with id {}", id);
		User user = userService.findById(id);

		if(user == null){
			 LOGGER.error("Unable to delete. User with id {} not found.", id);
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}


}
