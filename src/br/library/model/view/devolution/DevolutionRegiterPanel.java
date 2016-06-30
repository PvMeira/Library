
package br.library.model.view.devolution;

/**
 * @author Pedro
 *
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.library.model.controller.ClientController;
import br.library.model.controller.DevolutionController;
import br.library.model.controller.RentController;
@SuppressWarnings(value = { "all" })
public class DevolutionRegiterPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private DevolutionController devolutionController;
	private DevolutionCRUDWindow window;
	private ClientController clientController;
	private RentController rentController;

	public DevolutionRegiterPanel(DevolutionController controller) {
		this.devolutionController = controller;
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
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
		registerPanelLabel.setText("Dados do Livro");

		saveButton.setText("Devolver");
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

		jLabel6.setText("Ano de Publicação:");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addGap(0, 139, Short.MAX_VALUE).addComponent(registerPanelLabel).addGap(129, 129, 129))
				.addGroup(
						jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout
												.createSequentialGroup().addGap(63, 63, 63).addGroup(jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addComponent(jLabel6).addGap(21, 21, 21)
																.addComponent(textYear))
														.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
																jPanel2Layout
																		.createSequentialGroup().addComponent(jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(textWriter,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				199,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addGroup(jPanel2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel2).addComponent(jLabel1))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGroup(jPanel2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(textISBN).addComponent(textName,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				200,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
																jPanel2Layout.createSequentialGroup()
																		.addComponent(jLabel4).addGap(21, 21, 21)
																		.addComponent(textPublishingCompany,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				200,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(backButton,
																javax.swing.GroupLayout.PREFERRED_SIZE, 87,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(jPanel2Layout.createSequentialGroup().addGap(81, 81, 81).addComponent(
												saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(78, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(registerPanelLabel)
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textISBN, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textPublishingCompany, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textWriter, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textYear, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));

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
						devolutionController.save(Long.parseLong(cpf), Integer.parseInt(idRent));
					} else {
						JOptionPane.showMessageDialog(this, "Livro não pode ser devolvido!");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Código Não encontrado!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Campo inválido!");
		}
	}

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
		devolutionController.backToMainMenu();
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

	public void carregaDados(String isbn, String name, String publishingCompany, String writer, String year) {
		this.textISBN.setText(isbn);
		this.textName.setText(name);
		this.textPublishingCompany.setText(publishingCompany);
		this.textWriter.setText(writer);
		this.textYear.setText(year);
	}

	private javax.swing.JButton saveButton;
	private javax.swing.JButton backButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel registerPanelLabel;
	private javax.swing.JTextField textYear;
	private javax.swing.JTextField textWriter;
	private javax.swing.JTextField textPublishingCompany;
	private javax.swing.JTextField textISBN;
	private javax.swing.JTextField textName;
}
