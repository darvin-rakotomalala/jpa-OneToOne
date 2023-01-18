package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.UserMapper;
import com.poc.model.dto.UserDTO;
import com.poc.service.business.UserRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserRSAImpl implements UserRSA {

    private final UserRSM userRSM;
    private final UserMapper userMapper;

    @Override
    public UserDTO getUserById(Long id) {
        if (id == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_OBJECT_EMPTY.getErrorMessage());
        }
        return userMapper.toDTO(userRSM.getUserById(id));
    }

    @Override
    public HelpPage<UserDTO> getAllUsers(String name, Pageable pageable) {
        return userMapper.toDTO(userRSM.getAllUsers(name, pageable), pageable);
    }

}
