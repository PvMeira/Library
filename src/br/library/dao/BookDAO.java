package br.library.dao;

import java.util.List;

import br.library.domain.profile.Book;

public interface BookDAO extends dao<Book>{
	public Book searchByIsbc(int rg);
    public List<Book> searchByName(String nome);
}
