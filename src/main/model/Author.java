package main.model;


import java.time.LocalDate;
import java.util.List;

/**
 * A classe Author representa um autor de livros.
 * Cada autor possui um nome, data de nascimento, nacionalidade e uma lista de livros escritos por ele.
 */
public class Author {
	
    private String name; // O nome do autor
    private LocalDate birth; // A data de nascimento do autor
    private List<Book> books; // A lista de livros escritos pelo autor
    private Nationality nationality; // A nacionalidade do autor
    
	/**
	 * Construtor padrão da classe Author.
	 */
	Author(String name, LocalDate birth, Nationality nationality) {
		this.name = name;
		this.birth = birth;
		this.nationality = nationality;
	}
	
	//Getters e Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}


}
