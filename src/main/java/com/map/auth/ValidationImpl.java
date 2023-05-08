package com.map.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

import com.map.entity.User;
import com.map.repository.UserRepository;
import com.map.util.JwtTokenGenerator;

import java.util.Objects;
import java.util.Optional;

@Component
public class ValidationImpl {

  @Autowired
  UserRepository userRepository;
  
  public String authorize(String authorization) {
    try {
      if (Objects.isNull(authorization)) {
    	  return HttpStatus.UNAUTHORIZED.toString();
      }
      String usernameFromJwt = JwtTokenGenerator.getUsernameFromJwt(authorization);
      Optional<User> optionaluser  = userRepository.findUserBymail(usernameFromJwt);  
      if(optionaluser.isEmpty()) {
		return HttpStatus.NOT_FOUND.toString();
    	}
      return usernameFromJwt;
    } catch (Exception ex) {
      return null;
    }
  }
}

