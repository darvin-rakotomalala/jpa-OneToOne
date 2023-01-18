package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.UserProfileDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserProfileValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserProfileDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserProfileDTO userProfileDTO = (UserProfileDTO) target;
        if (userProfileDTO.getGender() == null) {
            errors.rejectValue("gender", "gender.value.empty", ErrorsEnum.ERR_MCS_USER_PROFILE_GENDER_EMPTY.getErrorMessage());
        }
        if (StringUtils.isEmpty(userProfileDTO.getAddress())) {
            errors.rejectValue("address", "address.value.empty", ErrorsEnum.ERR_MCS_USER_PROFILE_ADDRESS_EMPTY.getErrorMessage());
        }
    }
}
