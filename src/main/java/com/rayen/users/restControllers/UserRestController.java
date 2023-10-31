package com.rayen.users.restControllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rayen.users.entities.Role;
import com.rayen.users.entities.User;
import com.rayen.users.repos.UserRepository;
import com.rayen.users.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

	
	
	@Autowired
	UserRepository userRep;
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/all",method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRep.findAll();
	 }
	
	

	@RequestMapping(path = "/{id}",method = RequestMethod.GET)
	public Optional<User> getUserById(@PathVariable("id") Long id) {
	return userRep.findById(id);
	 }
	
	@RequestMapping(path="/getByusername/{username}",method = RequestMethod.GET)
	public User getUserByUsername(@PathVariable("username") String username) {
	return userService.findUserByUsername(username);
	 }
	
	
	
	
	@RequestMapping(path="/createUser",method = RequestMethod.POST)
	public User createUser(@RequestBody User u) {
		
		
		
		//ajouter le user
			User newU  = userService.saveUser(new User(null,u.getUsername(),u.getPassword(),true,null));
			
			//ajouter les rôles au user	
		
		
			if (u.getRoles() != null) {
		        for (Role r : u.getRoles()) {
		            newU = userService.addRoleToUser(newU.getUsername(), r.getRole());
		        }
		    }
		
		
		
		return newU;
	}
	
	@RequestMapping(path="/updateUser", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User u) {

		//ajouter le user
		User newU  = userService.updateUser(new User(u.getUser_id(),u.getUsername(),u.getPassword(),true,null));
		
		//ajouter les rôles au user	
	
	     newU.setRoles(null);
		if (u.getRoles() != null) {
			
	        for (Role r : u.getRoles()) {
	            newU = userService.addRoleToUser(newU.getUsername(), r.getRole());
	        }
	    }
	
	
	
	return newU;
		
		
	}
	
	@RequestMapping(path="/deleteUser/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id)
	{
		//System.out.println("delete");
		userService.deleteUserById(id);
	}
	
	
	@RequestMapping(path="/register",method = RequestMethod.POST)
	public User registerUser(@RequestBody User u) {
		
		System.out.println("register");
		
		//ajouter le user
			User newU  = userService.saveUser(new User(null,u.getUsername(),u.getPassword(),true,null));
			
			//ajouter les rôles au user	
		
		
			//if (u.getRoles() != null) {
		      //  for (Role r : u.getRoles()) {
		            newU = userService.addRoleToUser(newU.getUsername(), "USER");
		      //  }
		   // }
		
		
		
		return newU;
	}
	
	
	@RequestMapping(path="/changePassword/{id}",method = RequestMethod.PUT)
	public User ChangePassword(@RequestParam("oldPass") String oldPass,@RequestParam("newPass") 
	String newPass,@PathVariable("id") Long id) {
		
		System.out.println("old = "+oldPass + " new = "+newPass);
		
			return  userService.ChangePassword(oldPass,newPass,id);
				
		
	}
	
}