package com.andretreinaweb.meuworkshopp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andretreinaweb.meuworkshopp.domain.User;
import com.andretreinaweb.meuworkshopp.dto.UserDTO;
import com.andretreinaweb.meuworkshopp.repository.UserRepository;
import com.andretreinaweb.meuworkshopp.services.exception.ObjectNotfoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
        return repo.findAll();
		
	}
	
	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
		throw new ObjectNotfoundException("Objeto não encontrado");
		}
		return user;
			
		}
		
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);		
	}
	
	public User update(User obj) {
		User newObj = repo.findOne(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

//		
	public User fromDTO(UserDTO objDto) {
		return new User (objDto.getId(), objDto.getNome(), objDto.getEmail());
		
	}
		}

		
	


	

	
	

		

