package com.example.validator.validation.validator;

import com.example.validator.validation.annotation.Birthday;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;

/**
 * 生日格式校验器
 *
 * @author zhangbin.
 * @date 2020/6/5.
 */
public class BirthdayValidator implements ConstraintValidator<Birthday, String> {

    private Birthday birthday;

    public void initialize(Birthday birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        String fmt = birthday.format();
        if (value.length() != fmt.length()) {
            return false;
        }
        String[] items = value.split("-");
        if (StringUtils.isEmpty(items[0]) || items[0].length() != 4) {
            return false;
        }
        if (StringUtils.isEmpty(items[1]) || items[1].length() != 2) {
            return false;
        }
        if (StringUtils.isEmpty(items[2]) || items[2].length() != 2) {
            return false;
        }

        try {
            DateUtils.parseDate(value, fmt);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
