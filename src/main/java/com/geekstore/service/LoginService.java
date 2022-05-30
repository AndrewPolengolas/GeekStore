package com.geekstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstore.entities.Login;
import com.geekstore.entities.User;
import com.geekstore.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public Login inserir(User usuario) {
		Login login = new Login(null, usuario.getEmail(), usuario.getSenha());
		return loginRepository.save(login);
	}
	
}
