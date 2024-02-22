package main;

import java.time.LocalDate;

import main.model.Author;
import main.model.Book;
import main.model.BookLoan;
import main.model.Library;
import main.model.Nationality;
import main.model.User;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        
        //Cadastrar autor
        
        Author author = library.createAuthor("J. R. R. Tolkien", LocalDate.of(1892, 1, 3), Nationality.INGLES);
        
        //Cadastrar livros
        
        Book bookSilmarillion = library.createBook("O Silmarillion", author, 1977);
        
        Book bookHobbit = library.createBook("O Hobbit", author, 1937);
        
        //Cadastrar usuário
        
        User user = library.createUser("Taynara Vitorino", LocalDate.of(1999, 6, 11));
        
        //Fazer um empréstimo
        
        LocalDate rentDay = LocalDate.now();
        LocalDate deadline = rentDay.plusDays(7);
 
        BookLoan bookLoanSilmarrilion = library.newLoanBook(user, bookSilmarillion, LocalDate.now(), deadline);
        
        //Tentar fazer mais de um empréstimo.
        
        BookLoan bookLoanHobbit = library.newLoanBook(user, bookHobbit, LocalDate.now(), deadline);
        
        //Tentar fazer um empréstimo de um livro já alugado.
        
        BookLoan newBookLoanSilmarrilion = library.newLoanBook(user, bookSilmarillion, LocalDate.now(), deadline);
        
        //Devolver o livro alugado
        
        library.returnBook(user, LocalDate.now());
        
        //Alugar um novo livro
        
        BookLoan newBookLoanHobbit = library.newLoanBook(user, bookHobbit, LocalDate.now(), deadline);
        
       
    }
    
}