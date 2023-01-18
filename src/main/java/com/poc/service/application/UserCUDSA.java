package com.poc.service.application;

import com.poc.model.dto.UserDTO;

public interface UserCUDSA {
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO updateUser(UserDTO userDTO);
    public void deleteUserById(Long id);
}
