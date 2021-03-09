package com.aspirkin.notes.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {NoteValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNote {
	String message() default "{com.aspirkin.notes.validator.ValidNote.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
