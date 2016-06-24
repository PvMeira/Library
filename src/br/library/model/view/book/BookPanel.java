/**
 * @author Pedro
 *
 */
package br.library.model.view.book;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.library.model.controller.BookController;

public class BookPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	private BookController controller;

	public BookPanel(BookController controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {

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

		booksTable.setModel(new BookTableModel());
		jScrollPane1.setViewportView(booksTable);

		insertButton.setText("Inserir");
		insertButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				insertButtonActionPerformed(evt);
			}
		});

		editButton.setText("Editar");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editButtonActionPerformed(evt);
			}
		});

		removeButton.setText("Remover");
		removeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup().addComponent(insertButton).addGap(37, 37, 37)
												.addComponent(editButton).addGap(34, 34, 34).addComponent(removeButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
														Short.MAX_VALUE)
												.addComponent(viewButton))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
		controller.insert();
	}

	private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.edit();
	}

	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.remove();
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

	public JTable getBooksTable() {
		return booksTable;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	private javax.swing.JButton editButton;
	private javax.swing.JButton insertButton;
	private javax.swing.JButton removeButton;
	private javax.swing.JButton viewButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable booksTable;

}
