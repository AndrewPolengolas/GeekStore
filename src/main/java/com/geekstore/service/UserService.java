package com.geekstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekstore.entities.Login;
import com.geekstore.entities.User;
import com.geekstore.repositories.UserRepository;
import com.geekstore.utils.Criptografia;
import com.geekstore.utils.ValidaCPF;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginService loginService;
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	public User findByCPF(String cpf) {
		
		return userRepository.findByCpfContaining(cpf);
	}
	
	public User inserir(User usuario) {
		
		usuario.setCpf(ValidaCPF.imprimeCPF(usuario.getCpf())); 
		 
		String senhaFechada = Criptografia.gerarHashSenha(usuario.getSenha());
		
		usuario.setSenha(senhaFechada);

		Login login = loginService.inserir(usuario);
		
		usuario.setLogin(login);
		
		userRepository.save(usuario);

		return usuario;
	}	
	
}
