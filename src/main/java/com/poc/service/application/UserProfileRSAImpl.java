package com.poc.service.application;

import com.poc.mapper.UserProfileMapper;
import com.poc.model.dto.UserProfileDTO;
import com.poc.service.business.UserProfileRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserProfileRSAImpl implements UserProfileRSA {

    private final UserProfileRSM userProfileRSM;
    private final UserProfileMapper userProfileMapper;

    @Override
    public UserProfileDTO getUserProfileById(Long id) {
        return userProfileMapper.toDTO(userProfileRSM.getUserProfileById(id));
    }

    @Override
    public HelpPage<UserProfileDTO> getAllUserProfiles(String address, Pageable pageable) {
        return userProfileMapper.toDTO(userProfileRSM.getAllUserProfiles(address, pageable), pageable);
    }

}
