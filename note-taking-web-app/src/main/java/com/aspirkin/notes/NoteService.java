package com.aspirkin.notes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}
	
	public List<Note> getNotesContainingText(String searchString) {
		return noteRepository.findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(searchString, searchString);
	}
	
	public void saveNote(Note note) {
		noteRepository.save(note);
	}
	
	public void deleteNoteById(long id) {
		noteRepository.deleteById(id);
	}
	
	public Note getNoteById(long id) throws Exception
		{Optional<Note> optional = noteRepository.findById(id);
		Note note = null;
		if (optional.isPresent()) {
			note = optional.get();
		} else {
			throw new Exception("Note not found by id ::" + id);
		}
		return note;
	}
}
