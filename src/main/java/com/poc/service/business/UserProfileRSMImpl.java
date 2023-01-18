package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.UserProfile;
import com.poc.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserProfileRSMImpl implements UserProfileRSM {

    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfile getUserProfileById(Long id) {
        try {
            log.info("----- getUserProfileById : {}", id);
            Optional<UserProfile> optUser = userProfileRepository.findById(id);
            if (optUser.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_PROFILE_NOT_FOUND.getErrorMessage());
            }
            return optUser.get();
        } catch (Exception e) {
            log.error("Error getUserProfileById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<UserProfile> getAllUserProfiles(String address, Pageable pageable) {
        try {
            log.info("----- getAllUserProfiles by address : {}", address);
            if (StringUtils.isBlank(address)) {
                return userProfileRepository.findAll(pageable);
            } else {
                return userProfileRepository.findByAddressIgnoreCase(address, pageable);
            }
        } catch (Exception e) {
            log.error("Error getAllUserProfiles : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
