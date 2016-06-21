
package br.library.model.view.client;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.library.infra.util.messengerJFrame;
import br.library.model.controller.ClientController;

public class RegisterClientPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientController controller;
	private ClientCRUDWindow window;

	public RegisterClientPanel(ClientController controller) {
		this.controller = controller;
		initComponents();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		saveButton = new javax.swing.JButton();
		backButton = new javax.swing.JButton();
		textCPF = new javax.swing.JTextField();
		textName = new javax.swing.JTextField();
		textPhone = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		labelRegisterPanel = new javax.swing.JLabel();

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

		jLabel1.setText("CPF");

		jLabel2.setText("Nome:");

		jLabel4.setText("Telefone:");

		labelRegisterPanel.setFont(new java.awt.Font("Tahoma", 1, 18));
		labelRegisterPanel.setText("Cadastro de Clientes");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout
						.createSequentialGroup().addGap(63, 63, 63).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(jPanel1Layout
												.createSequentialGroup().addComponent(saveButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGroup(
														jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel2).addComponent(jLabel1))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(textCPF, javax.swing.GroupLayout.DEFAULT_SIZE,
																200, Short.MAX_VALUE)
														.addComponent(textName)))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel1Layout.createSequentialGroup().addComponent(jLabel4)
														.addGap(21, 21, 21).addComponent(textPhone,
																javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
										.createSequentialGroup().addComponent(labelRegisterPanel).addGap(34, 34, 34)))
						.addContainerGap(70, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(labelRegisterPanel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textPhone, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addGap(71, 71, 71)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(saveButton).addComponent(backButton))
						.addGap(30, 30, 30)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
	}

	private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.textName.getText().equals("") || this.textCPF.getText().equals("")
				|| this.textPhone.getText().equals("")) {
			messengerJFrame.printSucessMesenge(window, "Todos os campos devem ser preenchidos!");
		} else {
			controller.save(this.textCPF.getText(), this.textName.getText(), this.textPhone.getText());
		}
	}

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.goBackToMainScrenn();
	}

	public JLabel getLabelRegisterPanel() {
		return labelRegisterPanel;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JTextField getTextName() {
		return textName;
	}

	public JTextField getTextCPF() {
		return textCPF;
	}

	public JTextField getTextPhone() {
		return textPhone;
	}

	public void clean() {
		this.textCPF.setText("");
		this.textName.setText("");
		this.textPhone.setText("");
	}

	public void loadData(String cpf, String nome, String telefone) {
		this.textCPF.setText(cpf);
		this.textName.setText(nome);
		this.textPhone.setText(telefone);
	}

	public void toggleClientFormEdit(boolean value) {
		this.textCPF.setEditable(value);
		this.textName.setEditable(value);
		this.textPhone.setEditable(value);
	}

	private javax.swing.JButton saveButton;
	private javax.swing.JButton backButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel labelRegisterPanel;
	private javax.swing.JTextField textName;
	private javax.swing.JTextField textCPF;
	private javax.swing.JTextField textPhone;
}
