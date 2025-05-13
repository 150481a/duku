package org.duku.mall.framework.starter.common.common.validation.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.duku.mall.framework.starter.common.common.validation.EnumValue;

public class EnumValuesValidator implements ConstraintValidator<EnumValue, Object> {
    private String[] strValues;
    private int[] intValues;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o instanceof String) {
            for (String s : strValues) {
                if (s.equals(o)) {
                    return true;
                }
            }
        } else if (o instanceof Integer) {
            for (int s : intValues) {
                if (s == ((Integer) o).intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        strValues = constraintAnnotation.strValues();
        intValues = constraintAnnotation.intValues();
    }
}
