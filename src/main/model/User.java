package main.model;

import java.time.LocalDate;

/**
 * A classe User representa um usuário da biblioteca.
 * Cada usuário possui um nome, data de nascimento e pode estar atualmente alugando um livro.
 */
public class User {
	
    private String name; // O nome do usuário
    private LocalDate birth; // A data de nascimento do usuário
    private Book rentedBook; // O livro atualmente alugado pelo usuário
    
    /**
     * Construtor da classe User.
     */
	User(String name, LocalDate birth) {
		this.name = name;
		this.birth = birth;
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

	public Book getRentedBook() {
		return rentedBook;
	}

	public void setRentedBook(Book rentedBook) {
		this.rentedBook = rentedBook;
	}
    

}
