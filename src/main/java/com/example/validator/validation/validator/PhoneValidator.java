package com.example.validator.validation.validator;

import com.example.validator.validation.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号格式校验器
 *
 * @author zhangbin.
 * @date 2020/6/5.
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");
        try {
            Matcher m = regex.matcher(value);
            return m.matches();
        } catch (Exception e) {
            return false;
        }
    }
}
