package main.model;



/**
 * A classe Book representa um livro.
 * Cada livro possui um título, autor, ano de publicação, status de aluguel e informações sobre empréstimos atuais.
 */
public class Book {
	
    private String title; // O título do livro
    private Author author; // O autor do livro
    private int year; // O ano de publicação do livro
    private boolean rented; // Indica se o livro está alugado
    private BookLoan currentBookLoan; // O empréstimo atual do livro
    
    /**
     * Construtor da classe Book.
     */
	Book(String name, Author author, int year) {
		this.title = name;
		this.author = author;
		this.year = year;
	}
	
    @Override
    public String toString() {
        return title;
    }
	
	//Getters e Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}


	public BookLoan getCurrentBookLoan() {
		return currentBookLoan;
	}

	public void setCurrentBookLoan(BookLoan currentBookLoan) {
		this.currentBookLoan = currentBookLoan;
	}
	
	
	
}
