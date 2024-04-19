package com.jsp.usere8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.usere8.dao.UserDao;
import com.jsp.usere8.dto.User;
import com.jsp.usere8.exception.UserIdNotFoundException;
import com.jsp.usere8.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser = dao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User Data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser = dao.findUser(id);
		if(dbUser!=null) {
//			id is present data fetched successu=fully
			ResponseStructure<User> structure=new   ResponseStructure<>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
//			id is not present
			throw new UserIdNotFoundException("Sorry failed to fetch the data");
		}
		
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id,user);
		if(dbUser!=null) {
//			id is present data updated successfully
			ResponseStructure<User> structure=new   ResponseStructure<>();
			structure.setMessage("Data Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}else {
//			id is not present
			throw new UserIdNotFoundException("Sorry failed to Update the data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User dbUser=dao.deleteUserById(id);
		if(dbUser!=null) {
//			id is present data updated successfully
			ResponseStructure<User> structure=new   ResponseStructure<>();
			structure.setMessage("Data Deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
//			id is not present
			throw new UserIdNotFoundException("Sorry failed to delete the data");
		}
	}

	
	
	
}
