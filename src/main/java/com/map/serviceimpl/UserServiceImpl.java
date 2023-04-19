package com.map.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.dto.StatusDto;
import com.map.dto.UserDto;
import com.map.entity.User;
import com.map.repository.UserRepository;
import com.map.service.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	public Object saveUserInformation(UserDto userdto) {
		User users = new User();
		users.setUsername(userdto.getUsername());
		users.setUseraddress(userdto.getUseraddress());
		users.setMail(userdto.getMail());
		users.setPassword(userdto.getPassword());
		return userRepository.save(users);
	}

	public Object findUserById(int id) throws Exception {

		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			return ("User is Not Available");
		}
		List<UserDto> userDto = user.stream().map(User -> modelMapper.map(User, UserDto.class))
				.collect(Collectors.toList());
		return userDto;
	}

	public List<UserDto> getAlluser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(User -> modelMapper.map(User, UserDto.class)).collect(Collectors.toList());
	}

	public String deleteUserbyid(int id) {

		Optional<User> user1 = userRepository.findById(id);
		if (user1.isEmpty()) {
			return "User Not Found !!";
		}
		userRepository.deleteById(id);
		return "User deleted successfully";
	}

	public User updateUserById(int id, UserDto userDTO) throws Exception {
		User user1 = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

		if (Objects.nonNull(userDTO.getUsername())) {
			user1.setUsername(userDTO.getUsername());
		}
		if (Objects.nonNull(userDTO.getUseraddress())) {
			user1.setUseraddress(userDTO.getUseraddress());
		}
		return userRepository.save(user1);
	}

	public String updateUserStatus(int id, StatusDto statusDto) throws Exception {
		userRepository.updateById(statusDto.getStatus(), id);
		return "user's status is updated";
	}
}