package com.geekstore.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekstore.entities.User;
import com.geekstore.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/findCPF/{cpf}")
	public ResponseEntity<User> findByCPF(@PathVariable("cpf") String cpf){
		
		User user = userService.findByCPF(cpf);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping(value="/findAll")
	public ResponseEntity<List<User>> findAll(){
		
		List<User> users = userService.findAll();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PostMapping(value = "/postUser")
	public ResponseEntity<User> insert(@RequestBody User usuario){
		User novoUser = userService.inserir(usuario);
		
		return new ResponseEntity<>(novoUser, HttpStatus.CREATED);
	}
	
}
