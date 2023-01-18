package com.poc.service.business;

import com.poc.model.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRSM {
    public User getUserById(Long id);
    public Page<User> getAllUsers(String name, Pageable pageable);
}
