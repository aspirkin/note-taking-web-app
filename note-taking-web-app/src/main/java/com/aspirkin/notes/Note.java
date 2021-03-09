package com.aspirkin.notes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.aspirkin.notes.validator.ValidNote;

@Entity
@Table(name="notes")
@ValidNote(message="Заметка не может быть пустой")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Size(max=127, message="Заголовок слишком длинный. Максимальная длина: 127 символов, введено ${validatedValue.length()}")
	private String title = "";
	@Size(max=1023, message="Заметка слишком длинная. Максимальная длина: 1023 символа, введено ${validatedValue.length()}")
	private String body = "";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
