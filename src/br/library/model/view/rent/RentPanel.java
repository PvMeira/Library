
package br.library.model.view.rent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.library.domain.profile.Book;
import br.library.model.controller.BookController;
import br.library.model.controller.ClientController;
import br.library.model.controller.RentController;

public class RentPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private ClientController clientController;
	private RentController rentController;
	private BookController bookController;

	public RentPanel(RentController controller) {
		initComponents();
		this.rentController = controller;
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		viewButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		booksTable = new javax.swing.JTable();
		insertButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		removeButton = new javax.swing.JButton();

		viewButton.setText("Visualizar");
		viewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewButtonActionPerformed(evt);
			}
		});

		booksTable.setModel(new RentTableModel());
		jScrollPane1.setViewportView(booksTable);

		insertButton.setText("Alugar");
		insertButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				insertButtonActionPerformed(evt);
			}
		});

		editButton.setText("Procurar livro por titulo");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editButtonActionPerformed(evt);
			}
		});

		removeButton.setText("Procurar livro por isbn");
		removeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(insertButton).addGap(18, 18, 18)
								.addComponent(editButton).addGap(18, 18, 18).addComponent(removeButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(viewButton))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(
														jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(insertButton).addComponent(editButton)
																.addComponent(removeButton).addComponent(viewButton))
												.addGap(19, 19, 19)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 494, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
	}

	private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {
		rentController.view();
	}

	private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String[] options = { "sim", "não" };
			String cpf = JOptionPane.showInputDialog("Digite seu CPF");
			clientController = new ClientController();
			if (clientController.clientExist(Long.parseLong(cpf))) {
				int option = JOptionPane.showOptionDialog(this, "Deseja alugar este livro?", "Cliente encontrado!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (option == 0) {
					JOptionPane.showMessageDialog(this, "Processando Dados...");
					rentController.save(Long.parseLong(cpf));
				} else {
					JOptionPane.showMessageDialog(this, "Livro não pode ser alugado!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Campo inválido");
		}
	}

	private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String[] opcoes = { "sim", "não" };
			String name = JOptionPane.showInputDialog("Digite o titulo desejado:");
			bookController = new BookController();
			if (bookController.BookExist(name)) {
				Book booktemp = bookController.searchBookByName(name);
				JOptionPane.showMessageDialog(this, "Livro Encontrado! \nTitulo: " + booktemp.getName() + "\nAutor: "
						+ booktemp.getWriter() + "\nAno de Publicação: " + booktemp.getYear());
				int option = JOptionPane.showOptionDialog(this, "Deseja alugar este livro?", "Livro encontrado!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (option == 0) {
					String cpf = JOptionPane.showInputDialog("Digite seu RG: ");
					clientController = new ClientController();
					if (clientController.clientExist(Long.parseLong(cpf))) {
						rentController.save(Long.parseLong(cpf));
					}
				} else {
					JOptionPane.showMessageDialog(this, "Livro não foi alugado!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Livro não encontrado!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Campo inválido!");
		}
	}

	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String[] options = { "sim", "não" };
			String isbn = JOptionPane.showInputDialog("Digite o ISBN desejado:");
			bookController = new BookController();
			if (bookController.BookExist(Long.parseLong(isbn))) {
				Book bookTemp = bookController.searchBookByIsbn(Long.parseLong(isbn));
				JOptionPane.showMessageDialog(this, "Livro Encontrado! \nTitulo: " + bookTemp.getName() + "\nAutor: "
						+ bookTemp.getWriter() + "\nAno de Publicação: " + bookTemp.getYear());
				int option = JOptionPane.showOptionDialog(this, "Deseja alugar este livro?", "Livro encontrado!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (option == 0) {
					String cpf = JOptionPane.showInputDialog("Digite seu CPF: ");
					clientController = new ClientController();
					if (clientController.clientExist(Long.parseLong(cpf))) {
						rentController.save(Long.parseLong(cpf));
					}
				} else {
					JOptionPane.showMessageDialog(this, "Livro não foi alugado!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Livro não encontrado!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Campo inválido");
		}
	}

	public JButton getEditButton() {
		return editButton;
	}

	public JButton getInsertButton() {
		return insertButton;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public JButton getViewButton() {
		return viewButton;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public JTable getRentTable() {
		return booksTable;
	}

	private javax.swing.JButton editButton;
	private javax.swing.JButton insertButton;
	private javax.swing.JButton removeButton;
	private javax.swing.JButton viewButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable booksTable;
}
