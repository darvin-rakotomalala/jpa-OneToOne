package com.poc.service.business;

import com.poc.model.domain.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserProfileRSM {
    public UserProfile getUserProfileById(Long id);
    public Page<UserProfile> getAllUserProfiles(String address, Pageable pageable);
}
