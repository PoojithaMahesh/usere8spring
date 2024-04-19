package com.jsp.usere8.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.usere8.dto.User;
import com.jsp.usere8.repo.UserRepo;

import jakarta.persistence.EntityManagerFactory;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUser(int id) {
	Optional<User> optional=repo.findById(id);
	if(optional.isPresent()) {
//		id is present
		User user=optional.get();
		return user;
	}else {
//		optional is empty
		return null;
	}
		
	}

	public User updateUser(int id, User user) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			id present then i can update the data;
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

	public User deleteUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			id is present then you can delete the data
			User user=optional.get();
//			repo.delete(user);
			repo.deleteById(id);
			return user;
		}
		return null;
	}

	
}
