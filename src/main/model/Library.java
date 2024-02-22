package main.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe Library representa uma biblioteca que gerencia um acervo de livros,
 * autores e empréstimos. Ela permite o cadastro de livros e autores, além de
 * possibilitar o empréstimo e devolução de livros dos usuários.
 */
public class Library {

	private List<Book> books; // Lista de livros cadastrados biblioteca
	private List<Author> authors; // Lista de autores cadastrados no sistema
	private List<BookLoan> rentals; // Lista de empréstimos feitos.
	private List<User> users; // Lista de usuários cadastrados

	/**
	 * Construtor padrão da classe Library. Inicializa as listas de livros, autores, empéstimos e usuários.
	 */
	public Library() {
		this.books = new ArrayList<>();
		this.authors = new ArrayList<>();
		this.rentals = new ArrayList<>();
		this.users = new ArrayList<>();
	}

	// Getter and Setters

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<BookLoan> getRentals() {
		return rentals;
	}

	public void setRentals(List<BookLoan> rentals) {
		this.rentals = rentals;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * Cria um novo autor com o nome, data de nascimento e nacionalidade. Além disso, adiciona  o autor 
	 * criado na lista de autores da livraria.
	 * 
	 * @return O autor criado.
	 */
	public Author createAuthor(String name, LocalDate birth, Nationality nationality) {
		
		Author author = new Author(name, birth, nationality);
		System.out.printf("O autor %s foi cadastrado com sucesso!\n\n", author.getName());
		
		authors.add(author);
		
		System.out.print("Autores cadastrados: \n\n");
		printAll(authors);
		
		return author;
	}

	/**
	 * Cria um novo livro com o título, autor e ano de publicação.Além disso, adiciona  o livro
	 * criado na lista de livros da livraria.
	 * 
	 * @return O livro criado.
	 */
	public Book createBook(String title, Author author, int year) {

		Book book = new Book(title, author, year);
		System.out.printf("O livro %s foi cadastrado com sucesso!\n\n", book.getTitle());
		
		author.getBooks().add(book);
		books.add(book);
		
		System.out.print("Livros no acervo: \n\n");
		printAll(books);
		
		return book;
	}

	/**
	 * Cria um novo usuário com o nome e data de nascimento especificados. Além disso, adiciona  o usuário
	 * criado na lista de usuários da livraria.
	 * 
	 * @return O usuário criado.
	 */
	public User createUser(String name, LocalDate birth) {
		
		User user = new User(name, birth);
		System.out.printf("O usuário %s foi cadastrado com sucesso!\n\n", user.getName());
		
		users.add(user);
		
		System.out.print("Usuários cadastrados: \n\n");
		printAll(users);
		
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
			
			System.out.printf("O livro %s não está disponível para aluguel. A data de devolução está prevista para %s\n\n", book.getTitle(), book.getCurrentBookLoan().getDeadline());
			
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
			
			rentals.add(bookLoan);
			
			System.out.printf("Aluguel do livro %s foi realizado com sucesso. A data de devolução é: %s.\n\n",
					book.getTitle(), deadline);
			
			System.out.print("Empréstimos realizados: \n\n");
			printAll(rentals);
			
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
	 * Imprime todos diferentes objetos da livraria.
	 */
    public void printAll(List<?> objects) {
        int i = 1;
        for (Object obj : objects) {
            System.out.printf("%d - %s\n", i, obj.toString());
            i++;
        }
        System.out.println();
    }
	

}