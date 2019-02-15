package br.com.dorival.petcare._____.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dorival.petcare._____.user.exception.UserNotFoundException;


@RestController
public class UserResource {
	
	
	@Autowired
	private UserDaoService service;
	

	@GetMapping("/api/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/api/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
				
		return resource;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);
	}

	// input - details of user
	// output - CREATED & Return the created URI
	
	@PostMapping("/api/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) { 	//, @RequestHeader Map<String, String> header, @RequestHeader("Accept-Language") String acceptLanguage

		User savedUser = service.save(user);

		/*
		System.out.println("*** Accept-Language: " + header.get("Accept-Language"));
		System.out.println("*** Accept-Language: " + acceptLanguage);
		for (Map.Entry<String,String> pair : header.entrySet()) {
		    System.out.println(pair.getKey() + " --> " + pair.getValue());
		} */

		URI location = ServletUriComponentsBuilder		 // define um resource de saída 
				.fromCurrentRequest()					 // /users 
				.path("/{id}")							 // /{id} 
				.buildAndExpand(savedUser.getId())		 // savedUser.getId()
				.toUri();
		
		return ResponseEntity.created(location).build(); //201 created
	}

}