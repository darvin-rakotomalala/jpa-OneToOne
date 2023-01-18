package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.UserMapper;
import com.poc.model.dto.UserDTO;
import com.poc.service.business.UserCUDSM;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCUDSAImpl implements UserCUDSA {

    private final UserCUDSM userCUDSM;
    private final UserRSA userRSA;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_OBJECT_EMPTY.getErrorMessage());
        }
        return userMapper.toDTO(userCUDSM.createUser(userMapper.toDO(userDTO)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        if (userDTO == null || userDTO.getId() == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_OBJECT_EMPTY.getErrorMessage());
        }
        UserDTO userFound = userRSA.getUserById(userDTO.getId());
        return userMapper.toDTO(userCUDSM.updateUser(userMapper.toDO(userDTO)));
    }

    @Override
    public void deleteUserById(Long id) {
        UserDTO userFound = userRSA.getUserById(id);
        userCUDSM.deleteUserById(userFound.getId());
    }
}
