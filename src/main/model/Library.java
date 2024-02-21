package main.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe Library representa uma biblioteca que gerencia um acervo de livros,
 * autores e empréstimos. Ela permite o cadastro de livros e autores, além de
 * possibilitar o empréstimo e devolução de livros para os usuários.
 */
public class Library {

	private List<Book> books; // Lista de livros disponíveis na biblioteca

	/**
	 * Construtor padrão da classe Library. Inicializa a lista de livros.
	 */
	public Library() {
		this.books = new ArrayList<>();
	}

	// Getter and Setters

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * Cria um novo autor com o nome, data de nascimento e nacionalidade.
	 * 
	 * @return O autor criado.
	 */
	public Author createAuthor(String name, LocalDate birth, Nationality nationality) {
		Author author = new Author(name, birth, nationality);
		System.out.printf("O autor %s foi cadastrado com sucesso!\n\n", author.getName());
		
		author.setBooks(new ArrayList<>());
		
		return author;
	}

	/**
	 * Cria um novo livro com o título, autor e ano de publicação.
	 * 
	 * @return O livro criado.
	 */
	public Book createBook(String title, Author author, int year) {

		Book book = new Book(title, author, year);
		System.out.printf("O livro %s foi cadastrado com sucesso!\n\n", book.getTitle());
		
		author.getBooks().add(book);
		books.add(book);
		
		System.out.print("Livros no acervo: \n\n");
		getAllBooks();
		
		return book;
	}

	/**
	 * Cria um novo usuário com o nome e data de nascimento especificados.
	 * 
	 * @return O usuário criado.
	 */
	public User createUser(String name, LocalDate birth) {
		
		User user = new User(name, birth);
		
		return user;
	}

	/**
	 * Realiza o empréstimo de um livro para um usuário, com a data de locação e
	 * data de devolução.
	 * Também trata as exceções: livro já alugado e usuário possui outro livro em posse;
	 * 
	 * @return O empréstimo do livro.
	 */
	public BookLoan newLoanBook(User user, Book book, LocalDate rentalDate, LocalDate deadline) {
		
		if (book.isRented()) {
			
			System.out.printf("O livro %s não está disponível para aluguel.\n\n", book.getTitle());
			
			return null;
			
		} else if (user.getRentedBook() != null) {
			
			System.out.printf(
					"Você já está em posse do livro %s. Para alugar um novo livro é necessário devolvê-lo.\n\n",
					user.getRentedBook().getTitle());
			
			return null;
			
		} else {
			
			BookLoan bookLoan = new BookLoan(user, book, rentalDate, deadline);
			
			user.setRentedBook(book);
			
			book.setRented(true);
			
			book.setCurrentBookLoan(bookLoan);
			
			System.out.printf("Aluguel do livro %s foi realizado com sucesso. A data de devolução é: %s.\n\n",
					book.getTitle(), deadline);
			
			return bookLoan;
		}
	}

	/**
	 * Realiza a devolução de um livro por um usuário, com a data de devolução.
	 */
	public void returnBook(User user, LocalDate returnDate) {
		
		user.getRentedBook().getCurrentBookLoan().setReturnDate(returnDate);
		
		user.getRentedBook().setRented(false);
		
		System.out.printf("Devolução do livro %s realizada com sucesso.\n\n", user.getRentedBook().getTitle());
		
		user.setRentedBook(null);
	}

	/**
	 * Imprime todos os livros no acevo da biblioteca.
	 */
	public void getAllBooks() {
		
		int i = 1;
		List<Book> libraryBooks = getBooks();
		
		for (Book book : libraryBooks) {
			System.out.printf("%d - %s\n", i, book.getTitle());
			i++;
		}
		
		System.out.print("\n");
	}
}