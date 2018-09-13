package com.ebebek.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ebebek.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "username", "user.username.empty");
		ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");
		ValidationUtils.rejectIfEmpty(err, "password", "user.password.empty");
		ValidationUtils.rejectIfEmpty(err, "confirmPassword", "user.confirmPassword.empty");

		User user = (User) obj;

		if (user.getUsername().length() < 3) {
			err.rejectValue("username", "user.username.invalid");
		}
		validatePassword(user.getPassword(), err);
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			err.rejectValue("confirmPassword", "user.confirmPassword.invalid");
		}
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getEmail()).matches())) {
			err.rejectValue("email", "user.email.invalid");
		}
	}

	private void validatePassword(String pass, Errors err) {
		Pattern upperCasePatten = Pattern.compile("[A-Z ]");
		Pattern lowerCasePatten = Pattern.compile("[a-z ]");
		Pattern digitCasePatten = Pattern.compile("[0-9 ]");
		if (pass.length() < 8 || !upperCasePatten.matcher(pass).find() || !lowerCasePatten.matcher(pass).find()
				|| !digitCasePatten.matcher(pass).find()) {
			err.rejectValue("password", "user.password.invalid");
		}
	}

}
