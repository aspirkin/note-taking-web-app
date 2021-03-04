package com.aspirkin.notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}
	
	public void saveNote(Note note) {
		if (note.getTitle()!=null && !note.getTitle().equals("") ||
			note.getBody()!=null && !note.getBody().equals("")) {
			noteRepository.save(note);
		}
	}
	
	public void deleteNoteById(long id) {
		noteRepository.deleteById(id);
	}
}
