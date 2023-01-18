package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.User;
import com.poc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserRSMImpl implements UserRSM {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        try {
            log.info("----- getUserById : {}", id);
            Optional<User> optUser = userRepository.findById(id);
            if (!optUser.isPresent()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NOT_FOUND.getErrorMessage());
            }
            return optUser.get();

        } catch (Exception e) {
            log.error("Error getUserById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<User> getAllUsers(String name, Pageable pageable) {
        try {
            log.info("----- getAllUsers : {}", name);
            if (StringUtils.isBlank(name)) {
                return userRepository.findAll(pageable);
            } else {
                return userRepository.findBySearchText(name, pageable);
            }
        } catch (Exception e) {
            log.error("Error getAllUsers : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
