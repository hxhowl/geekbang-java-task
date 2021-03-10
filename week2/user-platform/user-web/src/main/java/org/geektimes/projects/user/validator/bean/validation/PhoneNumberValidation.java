package org.geektimes.projects.user.validator.bean.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author hxhowl
 * @since 2021/3/10
 */
public class PhoneNumberValidation implements ConstraintValidator<PhoneNumber, String> {
    private static final Pattern PATTERN=Pattern.compile( "^1[345678]\\d{9}$");

    @Override
    public void initialize(PhoneNumber phoneNumber) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return false;
        } else {
            return PATTERN.matcher(s).matches();
        }
    }
}
