package com.jfb.hruser.services;

import java.util.Optional;

import com.jfb.hruser.dto.UserDTO;
import com.jfb.hruser.entities.User;
import com.jfb.hruser.repositories.UserRepository;
import com.jfb.hruser.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  @Transactional(readOnly = true)
  public UserDTO findById(Long id) {
    Optional<User> obj = repo.findById(id);
    User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
    return new UserDTO(entity);
  }

  @Transactional(readOnly = true)
  public User findByEmail(String email) {
    User obj = repo.findByEmail(email);
    return obj;
  }

}
