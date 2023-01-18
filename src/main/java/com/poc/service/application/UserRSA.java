package com.poc.service.application;

import com.poc.model.dto.UserDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface UserRSA {
    public UserDTO getUserById(Long id);
    public HelpPage<UserDTO> getAllUsers(String name, Pageable pageable);
}
