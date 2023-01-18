package com.poc.controller;

import com.poc.model.dto.UserProfileDTO;
import com.poc.service.application.UserProfileRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "userProfiles")
public class UserProfileController {
    private final UserProfileRSA userProfileRSA;

    @Operation(summary = "WS used to get user profile by id")
    @GetMapping("/{id}")
    public UserProfileDTO getUserProfileById(@PathVariable("id") Long id) {
        return userProfileRSA.getUserProfileById(id);
    }

    @Operation(summary = "WS used to get all userProfiles")
    @GetMapping
    public HelpPage<UserProfileDTO> getAllUserProfiles(
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {

        Pageable pageable = PageRequest.of(page, size);
        return userProfileRSA.getAllUserProfiles(address, pageable);
    }

}
