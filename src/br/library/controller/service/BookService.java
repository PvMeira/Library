package br.library.controller.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.library.dao.impl.BookDaoBd;
import br.library.dao.interf.BookDAO;
import br.library.domain.profile.Book;

public class BookService {

	private BookDAO dao;

	public BookService() {

		dao = new BookDaoBd();
	}

	public boolean bookExist(String name) {

		Book book = dao.searchByName(name);
		return (book != null);
	}

	public boolean bookExist(long isbn) {

		Book book = dao.searchByIsbn(isbn);
		if (book != null) {
			return true;
		} else {
			return false;
		}
	}

	public void addNewBook(Book book) {
		dao.insert(book);
	}

	public List<Book> listBooks() {
		return dao.list();
	}

	public Book searchBookByIsbn(long isbn) {

		Book book = dao.searchByIsbn(isbn);
		return (book);
	}

	public Book searchByName(String name) {

		Book book = dao.searchByName(name);
		return (book);
	}

	public void editBook(String op, long newX, Book l) {

		if (op.equals("1")) {
			dao.edit(l, newX, "isbn");
		}
	}

	public void editBook(String op, String newX, Book l) {

		if (op.equals("2")) {
			dao.edit(l, newX, "name");
		}
		if (op.equals("3")) {
			dao.edit(l, newX, "publishingCompany");
		}
		if (op.equals("4")) {
			dao.edit(l, newX, "writer");
		}
		if (op.equals("5")) {
			dao.edit(l, newX, "year");
		}
	}

	public void deletarLivro(Book l) {

		dao.delete(l);
	}

	public boolean isbnIsValid(long isbn) {
		Book book = dao.searchByIsbn(isbn);
		if (book != null) {
			return true;
		} else {
			return false;
		}
	}

	public void listAvaliableBooks() {
		List<Book> listBookRank = dao.list();
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-10s", "Isbn: ") + "\t" + String.format("%-20s", "|Nome: ") + "\t"
				+ String.format("%-20s", "|Editora: ") + "\t" + String.format("%-20s", "|Autor(es): ") + "\t"
				+ String.format("%-20s", "|Ano de Publicação: ") + "\t"
				+ String.format("%-20s", "|Quantidade de vezes que foi alugado: "));
		for (Book listOfBook : listBookRank) {
			if (listOfBook.isAvaliable() == true) {
				System.out.println(String.format("%-10s", listOfBook.getIsbn()) + "\t"
						+ String.format("%-20s", "|" + listOfBook.getName()) + "\t"
						+ String.format("%-20s", "|" + listOfBook.getPublishingCompany()) + "\t"
						+ String.format("%-20s", "|" + listOfBook.getWriter()) + "\t"
						+ String.format("%-20s", "|" + listOfBook.getYear()) + "\t"
						+ String.format("%-20s", "|" + listOfBook.getTotalRentQuantity()));
			}
		}
	}

	public boolean validateYearOfTheBook(String data) {
		return data.matches("[0-9]{4}+");
	}

	public void booksWhoGotMostRent() {
		List<Book> listBookRank = dao.list();
		Collections.sort(listBookRank, new bookMostRent());
		System.out.println("-----------------------------\n");
		System.out.println(String.format("%-10s", "Isbn: ") + "\t" + String.format("%-20s", "|Nome: ") + "\t"
				+ String.format("%-20s", "|Editora: ") + "\t" + String.format("%-20s", "|Autor(es): ") + "\t"
				+ String.format("%-20s", "|Ano de Publicação: ") + "\t"
				+ String.format("%-20s", "|Quantidade de vezes que foi alugado: "));
		for (Book listOfBook : listBookRank) {
			System.out.println(String.format("%-10s", listOfBook.getIsbn()) + "\t"
					+ String.format("%-20s", "|" + listOfBook.getName()) + "\t"
					+ String.format("%-20s", "|" + listOfBook.getPublishingCompany()) + "\t"
					+ String.format("%-20s", "|" + listOfBook.getWriter()) + "\t"
					+ String.format("%-20s", "|" + listOfBook.getYear()) + "\t"
					+ String.format("%-20s", "|" + listOfBook.getTotalRentQuantity()));
		}
	}

	public class bookMostRent implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			return book2.getTotalRentQuantity() - book1.getTotalRentQuantity();
		}
	}
}
