package br.library.controller.service;

import java.util.List;

import br.library.dao.impl.BookDaoBd;
import br.library.dao.interf.BookDAO;
import br.library.domain.profile.Book;

public class BookService {

	private BookDAO bookDAO;

	public BookService() {

		bookDAO = new BookDaoBd();
	}

	public void save(Book book) throws Exception {
		this.validateObliguefields(book);
		this.validateISBC(book);
		bookDAO.save(book);

	}

	public Book SerachByCode(int ISBC) throws Exception {
		if (ISBC == 0) {
			throw new Exception("Campo codigo ISBC nao informado");
		}
		Book b = bookDAO.searchByIsbc(ISBC);
		if (b == null) {
			throw new Exception("Livro nao encontrando");
		}
		return (b);
	}

	public List<Book> list() {

		return (bookDAO.list());
	}

	public void delete(Book book) throws Exception {
		if (book == null || book.getIsbnCode() == null) {
			throw new Exception("Livro não existe");
		}
		bookDAO.delete(book);
	}

	public void update(Book book) throws Exception {
		if (book == null || book.getIsbnCode() == null) {
			throw new Exception("Livro não existe");
		}
		this.validateObliguefields(book);
		bookDAO.update(book);

	}

	public List<Book> SerachByName(String name) throws Exception {
		if (name == null || name.isEmpty()) {
			throw new Exception("campo nome nao informado");
		}

		return (bookDAO.searchByName(name));
	}

	public boolean bookExist(int isbc) {
		Book b = bookDAO.searchByIsbc(isbc);
		return (b != null);
	}

	private void validateObliguefields(Book b) throws Exception {
		if (b.getBookName() == null || b.getBookName().isEmpty()) {
			throw new Exception("Campo nome nao preenchido");
		}

		if (b.getIsbnCode() == 0) {
			throw new Exception("Campo codigo ISBC  nao preenchido");
		}
		if (b.getWriters() == null || b.getWriters().isEmpty()) {
			throw new Exception("Campo Autor  nao preenchido");
		}
		if (b.getPublishingCompany() == null || b.getPublishingCompany().isEmpty()) {
			throw new Exception("Campo Editora  nao preenchido");
		}
		if (b.getReleaseyear() == 0) {
			throw new Exception("Campo ano  nao preenchido");
		}
	}

	private void validateISBC(Book b) throws Exception {
		if (bookExist(b.getIsbnCode())) {
			throw new Exception("ISBC ja existente");
		}

	}
}
