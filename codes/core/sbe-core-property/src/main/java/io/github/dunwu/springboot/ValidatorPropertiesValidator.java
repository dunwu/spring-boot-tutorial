package io.github.dunwu.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class ValidatorPropertiesValidator implements Validator {

    final Pattern pattern = Pattern.compile(
        "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    @Override
    public boolean supports(Class<?> type) {
        return type == ValidatorProperties.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "host", "host.empty");
        ValidationUtils.rejectIfEmpty(errors, "port", "port.empty");
        ValidatorProperties properties = (ValidatorProperties) o;

        if (properties.getHost() != null && !this.pattern.matcher(properties.getHost()).matches()) {
            errors.rejectValue("host", "Invalid host");
        }
    }

}
