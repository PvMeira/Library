package repository;

import java.util.List;

import profile.Book;

public interface BookDAO extends dao<Book>{
	public Book searchByIsbc(int rg);
    public List<Book> searchByName(String nome);
}
