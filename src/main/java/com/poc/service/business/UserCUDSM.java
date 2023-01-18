package com.poc.service.business;

import com.poc.model.domain.User;

public interface UserCUDSM {
    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUserById(Long id);
}
