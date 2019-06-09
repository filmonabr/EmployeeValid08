package com.students.mum.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.students.mum.domain.Member;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member) target;
		String[] errorArgs = { "First Name" };
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty", errorArgs);
		errorArgs = new String[] { "Last Name" };
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty", errorArgs);
		if (member.getMemberNumber() == null || member.getMemberNumber() <= 0)
			errors.rejectValue("memberNumber", "Member.Number.lessthan");
		if (member.getMemberNumber() == null || member.getAge() < 18)
			errors.rejectValue("age", "Member.age");
	}

}
