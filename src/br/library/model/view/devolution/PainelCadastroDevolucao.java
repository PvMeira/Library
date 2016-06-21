
package br.library.model.view.devolution;

import controller.UI.AluguelControllerUI;
import controller.UI.ClienteControllerUI;
import controller.UI.DevolucaoControllerUI;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PainelCadastroDevolucao extends javax.swing.JPanel {
	private DevolucaoControllerUI controller;
	private JanelaCrudDevolucao janela;
	private ClienteControllerUI controllerCliente;
	private AluguelControllerUI controllerAluguel;

	public PainelCadastroDevolucao(DevolucaoControllerUI controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		labelPainelFormulario = new javax.swing.JLabel();
		botaoSalvar = new javax.swing.JButton();
		botaoVoltar = new javax.swing.JButton();
		textISBN = new javax.swing.JTextField();
		textTitulo = new javax.swing.JTextField();
		textEditora = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		textAutor = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		textAnoPublicacao = new javax.swing.JTextField();

		jLabel4.setText("Editora:");

		labelPainelFormulario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		labelPainelFormulario.setText("Dados do Livro");

		botaoSalvar.setText("Devolver");
		botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoSalvarActionPerformed(evt);
			}
		});

		botaoVoltar.setText("Voltar");
		botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoVoltarActionPerformed(evt);
			}
		});

		jLabel1.setText("ISBN:");

		jLabel2.setText("Titulo:");

		jLabel5.setText("Autor(es):");

		jLabel6.setText("Ano de Publicação:");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout.createSequentialGroup().addGap(0, 139, Short.MAX_VALUE)
										.addComponent(labelPainelFormulario)
										.addGap(129, 129, 129))
						.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(63, 63, 63)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel6)
														.addGap(21, 21, 21).addComponent(textAnoPublicacao))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
														jPanel2Layout.createSequentialGroup().addComponent(jLabel5)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(textAutor,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 199,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														jPanel2Layout.createSequentialGroup()
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
																		.addComponent(textISBN).addComponent(textTitulo,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				200,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
														jPanel2Layout.createSequentialGroup().addComponent(jLabel4)
																.addGap(21, 21, 21).addComponent(textEditora,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(81, 81, 81).addComponent(
										botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(78, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(labelPainelFormulario)
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textISBN, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textEditora, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textAutor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(textAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
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
	}// </editor-fold>//GEN-END:initComponents

	private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoSalvarActionPerformed
		try {
			String idAluguel = "";
			String[] opcoes = { "sim", "não" };
			String rg = JOptionPane.showInputDialog("Digite seu RG:");
			controllerCliente = new ClienteControllerUI();
			if (controllerCliente.clienteExiste(Long.parseLong(rg))) {
				idAluguel = JOptionPane.showInputDialog("Digite o isbn do livro:");
				controllerAluguel = new AluguelControllerUI();
				if (controllerAluguel.CodigoExiste(Integer.parseInt(idAluguel))) {
					int op = JOptionPane.showOptionDialog(this, "Deseja devolver este livro?", "Código encontrado!",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
					if (op == 0) {
						JOptionPane.showMessageDialog(this, "Processando Dados...");
						controller.salvarDevolucao(Long.parseLong(rg), Integer.parseInt(idAluguel));
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
	}// GEN-LAST:event_botaoSalvarActionPerformed

	private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoVoltarActionPerformed
		controller.voltarPrincipal();
	}// GEN-LAST:event_botaoVoltarActionPerformed

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}

	public JTextField getTextAnoPublicacao() {
		return textAnoPublicacao;
	}

	public JTextField getTextAutor() {
		return textAutor;
	}

	public JTextField getTextEditora() {
		return textEditora;
	}

	public JTextField getTextISBN() {
		return textISBN;
	}

	public JTextField getTextTitulo() {
		return textTitulo;
	}

	public JLabel getLabelPainelFormulario() {
		return labelPainelFormulario;
	}

	public void carregaDados(String isbn, String titulo, String editora, String autor, String anoPublicacao) {
		this.textISBN.setText(isbn);
		this.textTitulo.setText(titulo);
		this.textEditora.setText(editora);
		this.textAutor.setText(autor);
		this.textAnoPublicacao.setText(anoPublicacao);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton botaoSalvar;
	private javax.swing.JButton botaoVoltar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel labelPainelFormulario;
	private javax.swing.JTextField textAnoPublicacao;
	private javax.swing.JTextField textAutor;
	private javax.swing.JTextField textEditora;
	private javax.swing.JTextField textISBN;
	private javax.swing.JTextField textTitulo;
	// End of variables declaration//GEN-END:variables
}
