package com.aspirkin.notes.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aspirkin.notes.Note;

public class NoteValidator implements ConstraintValidator<ValidNote, Note>{
	
	@Override
	public boolean isValid(Note note, ConstraintValidatorContext context) {
		if ((note.getTitle()!=null && note.getTitle().length() > 0) ||
			(note.getBody()!=null && note.getBody().length() > 0))
			return true;
		else
			return false;
	}

}
