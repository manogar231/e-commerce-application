package com.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.dto.StatusDto;
import com.map.dto.UserDto;
import com.map.service.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userservices;

	@PostMapping("/save")
	public ResponseEntity<Object> saveUser(@RequestBody UserDto userdto) {
		return ResponseEntity.ok().body(userservices.saveUserInformation(userdto));
	}
	@GetMapping("/{id}")
	public Object finduserbyid(@PathVariable Integer id ) throws Exception {
		return userservices.findUserById(id);
	}
	@GetMapping("/alluser")
	public List<UserDto> getallUsers(){
		return userservices.getAlluser();
	}
	@PutMapping("/update/{id}")
	public Object updateuser(@PathVariable  int id,@RequestBody UserDto user) throws Exception {
		return userservices.updateUserById(id,user);
	}
	
	@DeleteMapping("/delete/{id}")
	public Object deleteuser(@PathVariable Integer id) {
		return userservices.deleteUserbyid(id);
	}
	@PutMapping("/status/{id}")
	public String updateUserStatus(@PathVariable int id , @RequestBody StatusDto   statusDto) throws Exception {
		
		return userservices.updateUserStatus(id , statusDto);
	}
	
}
