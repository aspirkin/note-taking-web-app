package com.aspirkin.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/")
	public String showNotesList(Model model) {
		model.addAttribute("notesList", noteService.getAllNotes());
		return "notes_list";
	}
}
