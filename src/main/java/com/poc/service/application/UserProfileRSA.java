package com.poc.service.application;

import com.poc.model.dto.UserProfileDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface UserProfileRSA {
    public UserProfileDTO getUserProfileById(Long id);
    public HelpPage<UserProfileDTO> getAllUserProfiles(String address, Pageable pageable);
}
