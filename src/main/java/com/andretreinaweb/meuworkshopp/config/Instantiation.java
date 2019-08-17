package com.andretreinaweb.meuworkshopp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andretreinaweb.meuworkshopp.domain.User;
import com.andretreinaweb.meuworkshopp.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		userRepository.deleteAll();

		User x = new User(null, "Maria Cândia", "maria@gmail.com");
		User y = new User(null, "Pedro Santana", "pedro@gmail.com");
		User z = new User(null, "Anderson Santana", "anderson@gmail.com");
		
		userRepository.saveAll(Arrays.asList(x, y, z ));	
	}
}

