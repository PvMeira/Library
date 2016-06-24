
package br.library.model.view.book;

/**
 * @author Pedro
 *
 */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.library.infra.util.messengerJFrame;
import br.library.model.controller.BookController;

public class RegisterBookPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private BookController controller;
	private BookCRUDWindow window;

	public RegisterBookPanel(BookController controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {

		jLabel4 = new javax.swing.JLabel();
		registerPanelLabel = new javax.swing.JLabel();
		saveButton = new javax.swing.JButton();
		backButton = new javax.swing.JButton();
		textISBN = new javax.swing.JTextField();
		textName = new javax.swing.JTextField();
		textPublishingCompany = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		textWriter = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		textYear = new javax.swing.JTextField();

		jLabel4.setText("Editora:");

		registerPanelLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
		registerPanelLabel.setText("Cadastro de Livros");

		saveButton.setText("Cadastrar");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});

		backButton.setText("Voltar");
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backButtonActionPerformed(evt);
			}
		});

		jLabel1.setText("ISBN:");

		jLabel2.setText("Titulo:");

		jLabel5.setText("Autor(es):");

		jLabel6.setText("Ano de Publica��o:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(registerPanelLabel).addGap(116, 116, 116))
				.addGroup(layout.createSequentialGroup().addGap(63, 63, 63)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addComponent(saveButton).addGap(102, 102, 102)
										.addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(layout.createSequentialGroup().addComponent(jLabel6)
														.addGap(21, 21, 21).addComponent(textYear))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup().addComponent(jLabel5)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(textWriter,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 199,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel2).addComponent(jLabel1))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(textISBN).addComponent(textName,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup().addComponent(jLabel4)
																.addGap(21, 21, 21).addComponent(textPublishingCompany,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(78, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(registerPanelLabel)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textISBN, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textPublishingCompany, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textWriter, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textYear, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(saveButton).addComponent(backButton))
						.addGap(30, 30, 30)));
	}

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.textISBN.getText().equals("") || this.textName.getText().equals("")
				|| this.textPublishingCompany.getText().equals("") || this.textWriter.getText().equals("")
				|| this.textYear.getText().equals("")) {
			messengerJFrame.printErrorMessage(window, "Todos os campos devem ser preenchidos!");
		} else {
			controller.save(this.textISBN.getText(), this.textName.getText(), this.textPublishingCompany.getText(),
					this.textWriter.getText(), this.textYear.getText());
		}
	}

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.backToMainScreen();
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JTextField getTextYear() {
		return textYear;
	}

	public JTextField getTextWriter() {
		return textWriter;
	}

	public JTextField getTextPublishingCompany() {
		return textPublishingCompany;
	}

	public JTextField getTextISBN() {
		return textISBN;
	}

	public JTextField getTextName() {
		return textName;
	}

	public JLabel getRegisterPanelLabel() {
		return registerPanelLabel;
	}

	public void clean() {
		this.textISBN.setText("");
		this.textName.setText("");
		this.textPublishingCompany.setText("");
		this.textWriter.setText("");
		this.textYear.setText("");
	}

	public void loadData(String isbn, String name, String publishingCompany, String writer, String year) {
		this.textISBN.setText(isbn);
		this.textName.setText(name);
		this.textPublishingCompany.setText(publishingCompany);
		this.textWriter.setText(writer);
		this.textYear.setText(year);
	}

	public void toggleBookFormEdit(boolean value) {
		this.textISBN.setEditable(value);
		this.textName.setEditable(value);
		this.textPublishingCompany.setEditable(value);
		this.textWriter.setEditable(value);
		this.textYear.setEditable(value);
	}

	private javax.swing.JButton saveButton;
	private javax.swing.JButton backButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel registerPanelLabel;
	private javax.swing.JTextField textYear;
	private javax.swing.JTextField textWriter;
	private javax.swing.JTextField textPublishingCompany;
	private javax.swing.JTextField textISBN;
	private javax.swing.JTextField textName;
}
