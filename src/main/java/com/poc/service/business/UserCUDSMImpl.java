package com.poc.service.business;

import com.poc.model.domain.User;
import com.poc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserCUDSMImpl implements UserCUDSM {

    private final UserRepository userRepository;

    @Autowired
    private UserRSM userRSM;

    @Override
    public User createUser(User user) {
        try {
            log.info("----- createUser");
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Error createUser : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            log.info("----- updateUser");
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Error updateUser : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        try {
            log.info("----- deleteUserById : {}", id);
            userRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error deleteUserById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
