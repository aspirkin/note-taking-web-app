package com.aspirkin.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/")
	public String showNotesList(Model model) {
		model.addAttribute("notesList", noteService.getAllNotes());
		return "notes_list";
	}
	
	@GetMapping("/newNote")
	public String showNewNotePage(Model model) {
		Note note = new Note();
		model.addAttribute("note", note);
		return "new_note";
	}
	
	@PostMapping("/saveNote")
	public String saveStudent(@ModelAttribute("note") Note note) {
		noteService.saveNote(note);
		return "redirect:/";
	}
	
	@GetMapping("/deleteNote/{id}")
	public String deleteNote(@PathVariable(value="id") int id) {
		noteService.deleteNoteById(id);
		return "redirect:/";
	}
}
