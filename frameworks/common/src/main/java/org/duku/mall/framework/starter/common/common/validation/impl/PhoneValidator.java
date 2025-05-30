package org.duku.mall.framework.starter.common.common.validation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.duku.mall.framework.starter.common.common.validation.Phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号校验
 *
 * @author Bulbasaur
 * @since 2021/7/9 1:42 上午
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final Pattern pattern = Pattern.compile("^0?(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

    @Override
    public void initialize(Phone constraintAnnotation) {

    }
}
