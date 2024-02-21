package main.model;



import java.time.LocalDate;

/**
 * A classe BookLoan representa um empréstimo de livro realizado por um usuário.
 * Cada empréstimo possui informações sobre o usuário, o livro, a data de locação, a data de devolução e o prazo de devolução.
 */
public class BookLoan {
	
    private User user; // O usuário que realizou o empréstimo
    private Book book; // O livro emprestado
    private LocalDate rentalDate; // A data em que o livro foi emprestado
    private LocalDate returnDate; // A data em que o livro foi devolvido
    private LocalDate deadline; // A data limite para a devolução do livro
	
    /**
     * Construtor da classe BookLoan.
     */
	BookLoan(User user, Book book, LocalDate rentalDate, LocalDate deadline) {
		this.user = user;
		this.book = book;
		this.rentalDate = rentalDate;
		this.deadline = deadline;
	}

	//Getters e Setters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}


	
}
