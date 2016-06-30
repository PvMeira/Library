
package br.library.model.view.report;

import java.util.ArrayList;

import br.library.domain.profile.Book;
import br.library.model.controller.BookController;
import br.library.model.controller.ClientController;
import br.library.model.view.book.BookTableModel;
import br.library.model.view.client.ClientTableModel;

public class ReportPanel extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private ClientController clientController;
	private BookController bookController;

	public ReportPanel() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		insertButton = new javax.swing.JButton();
		removeButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		clientTable = new javax.swing.JTable();
		viewButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		removeButton1 = new javax.swing.JButton();
		removeButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		insertButton.setText("Clientes que mais alugaram");
		insertButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				insertButtonActionPerformed(evt);
			}
		});

		removeButton.setText("Clientes que mais atrasaram");
		removeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButtonActionPerformed(evt);
			}
		});

		jScrollPane1.setViewportView(clientTable);

		viewButton.setText("Livros disponíveis");
		viewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewButtonActionPerformed(evt);
			}
		});

		editButton.setText("Livros Mais Alugados");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editButtonActionPerformed(evt);
			}
		});

		removeButton1.setText("Todos os Clientes");
		removeButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButton1ActionPerformed(evt);
			}
		});

		removeButton2.setText("Todos os Livros");
		removeButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(185, 185, 185)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(removeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(removeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 907,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(removeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(removeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(22, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(36, 36, 36)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 969, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 381, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));

		pack();
	}

	private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ClientTableModel table = new ClientTableModel();
		clientController = new ClientController();
		table.setClient(clientController.clientsWhoMostRent());
		clientTable.setModel(table);
	}

	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ClientTableModel table = new ClientTableModel();
		clientController = new ClientController();
		table.setClient(clientController.clientesQueMaisAtrasam());
		clientTable.setModel(table);
	}

	private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {
		BookTableModel bookTable = new BookTableModel();
		bookController = new BookController();
		ArrayList<Book> books = new ArrayList<>();
		for (Book l : bookController.listBooks()) {
			if (l.isAvaliable()) {
				books.add(l);
			}
		}
		bookTable.setBook(books);
		clientTable.setModel(bookTable);
	}

	private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
		BookTableModel tableBook = new BookTableModel();
		bookController = new BookController();
		tableBook.setBook(bookController.MostRentedBooks());
		clientTable.setModel(tableBook);
	}

	private void removeButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		ClientTableModel table = new ClientTableModel();
		clientController = new ClientController();
		table.setClient(clientController.listClients());
		clientTable.setModel(table);
	}

	private void removeButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		BookTableModel tableBook = new BookTableModel();
		bookController = new BookController();
		tableBook.setBook(bookController.listBooks());
		clientTable.setModel(tableBook);
	}

	private javax.swing.JButton editButton;
	private javax.swing.JButton insertButton;
	private javax.swing.JButton removeButton;
	private javax.swing.JButton removeButton1;
	private javax.swing.JButton removeButton2;
	private javax.swing.JButton viewButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable clientTable;

}
