
package br.library.model.view.devolution;

/**
 * @author Pedro
 *
 */

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.library.domain.profile.Book;
import br.library.model.controller.BookController;
import br.library.model.controller.ClientController;
import br.library.model.controller.DevolutionController;
import br.library.model.controller.RentController;

public class DevolutionPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private ClientController clientController;
	private RentController rentController;
	private BookController bookController;
	private DevolutionController controller;

	public DevolutionPanel(DevolutionController controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {

		viewButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		bookstable = new javax.swing.JTable();
		insertButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		removeButton = new javax.swing.JButton();

		viewButton.setText("Visualizar");
		viewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewButtonActionPerformed(evt);
			}
		});

		bookstable.setModel(new DevolutionTableModel());
		jScrollPane1.setViewportView(bookstable);

		insertButton.setText("Devovler");
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

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup().addComponent(insertButton).addGap(10, 10, 10)
												.addComponent(editButton).addGap(18, 18, 18).addComponent(removeButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(viewButton))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(insertButton).addComponent(editButton).addComponent(removeButton)
								.addComponent(viewButton))
						.addGap(19, 19, 19)));
	}

	private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.view();
	}

	private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String idRent = "";
			String[] options = { "sim", "não" };
			String cpf = JOptionPane.showInputDialog("Digite seu CPF:");
			clientController = new ClientController();
			if (clientController.clientExist(Long.parseLong(cpf))) {
				idRent = JOptionPane.showInputDialog("Digite o isbn do livro:");
				rentController = new RentController();
				if (rentController.codeExist(Integer.parseInt(idRent))) {
					int op = JOptionPane.showOptionDialog(this, "Deseja devolver este livro?", "Código encontrado!",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (op == 0) {
						JOptionPane.showMessageDialog(this, "Processando Dados...");
						controller.save(Long.parseLong(cpf), Integer.parseInt(idRent));
					} else {
						JOptionPane.showMessageDialog(this, "Livro não pode ser devolvido!");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Código não encontrado!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Campo inválido!");
		}
	}

	private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String idRent = "";
			String[] options = { "sim", "não" };
			String bookName = JOptionPane.showInputDialog("Digite o titulo desejado:");
			bookController = new BookController();
			if (bookController.BookExist(bookName)) {
				Book bookTemp = bookController.searchBookByName(bookName);
				JOptionPane.showMessageDialog(this, "Livro Encontrado! \nTitulo: " + bookTemp.getName() + "\nAutor: "
						+ bookTemp.getName() + "\nANo de Publicação: " + bookTemp.getYear());
				int op = JOptionPane.showOptionDialog(this, "Deseja devolver este livro?", "Livro encontrado!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (op == 0) {
					String rg = JOptionPane.showInputDialog("Digite seu RG: ");
					clientController = new ClientController();
					if (clientController.clientExist(Long.parseLong(rg))) {
						idRent = JOptionPane.showInputDialog("Digite o isbn do livro:");
						rentController = new RentController();
						if (rentController.codeExist(Integer.parseInt(idRent))) {
							JOptionPane.showMessageDialog(this, "Processando Dados...");
							controller.save(Long.parseLong(rg), Integer.parseInt(idRent));
						} else {
							JOptionPane.showMessageDialog(this, "Código não encontrado!");
						}
					} else {
						JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
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
			String idRent = "";
			String[] options = { "sim", "não" };
			String isbn = JOptionPane.showInputDialog("Digite o ISBN desejado:");
			bookController = new BookController();
			if (bookController.BookExist(Long.parseLong(isbn))) {
				Book bookTemp = bookController.searchBookByIsbn(Long.parseLong(isbn));
				JOptionPane.showMessageDialog(this, "Livro Encontrado! \nTitulo: " + bookTemp.getName() + "\nAutor: "
						+ bookTemp.getWriter() + "\nAno de Publicação: " + bookTemp.getYear());
				int op = JOptionPane.showOptionDialog(this, "Deseja devolver este livro?", "Livro encontrado!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (op == 0) {
					String cpf = JOptionPane.showInputDialog("Digite seu RG: ");
					clientController = new ClientController();
					if (clientController.clientExist(Long.parseLong(cpf))) {
						idRent = JOptionPane.showInputDialog("Digite o ID do livro:");
						rentController = new RentController();
						if (rentController.codeExist(Integer.parseInt(idRent))) {
							JOptionPane.showMessageDialog(this, "Processando Dados...");
							controller.save(Long.parseLong(cpf), Integer.parseInt(idRent));
						} else {
							JOptionPane.showMessageDialog(this, "Código não encontrado!");
						}
					} else {
						JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
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

	public JTable getDevolutionTable() {
		return bookstable;
	}

	private javax.swing.JButton editButton;
	private javax.swing.JButton insertButton;
	private javax.swing.JButton removeButton;
	private javax.swing.JButton viewButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable bookstable;

}
