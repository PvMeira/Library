
package br.library.model.view.devolution;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import br.library.domain.profile.Book;

public class DevolutionTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String header[];
	private List<Book> books;

	public DevolutionTableModel() {
		this.header = new String[] { "ISBN", "Nome", "Editora", "Autor(es)", "Ano de Publicação", "Disponibilidade" };
		this.books = new ArrayList<Book>();
	}

	public DevolutionTableModel(String[] header, List<Book> books) {
		this.header = header;
		this.books = books;

	}

	@Override
	public int getRowCount() {
		return (this.books.size());
	}

	@Override
	public int getColumnCount() {
		return (6);
	}

	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return (this.books.get(rowIndex).getIsbn());
		else if (columnIndex == 1)
			return (this.books.get(rowIndex).getName());
		else if (columnIndex == 2)
			return (this.books.get(rowIndex).getPublishingCompany());
		else if (columnIndex == 3)
			return (this.books.get(rowIndex).getWriter());
		else if (columnIndex == 4)
			return (this.books.get(rowIndex).getYear());
		else if (columnIndex == 5)
			return (this.books.get(rowIndex).isAvaliable());
		else
			return null;
	}

	public void setBook(List<Book> books) {
		this.books = books;
	}

	public Book getBook(int line) {
		return (books.get(line));
	}
}
