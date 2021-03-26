package com.example.validator.validation.validator;

import com.example.validator.validation.annotation.IdentityNum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 身份证号格式校验器
 *
 * @author zhangbin.
 * @date 2020/6/5.
 */
public class IdentityNumValidator implements ConstraintValidator<IdentityNum, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
            return Pattern.matches(REGEX_ID_CARD, value);
        } catch (Exception e) {
            return false;
        }
    }
}
