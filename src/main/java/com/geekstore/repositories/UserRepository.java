package com.geekstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geekstore.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByCpfContaining(String cpf);
	
}
