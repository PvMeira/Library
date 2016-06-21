
package br.library.model.view.devolution;

import controller.UI.AluguelControllerUI;
import controller.UI.ClienteControllerUI;
import controller.UI.DevolucaoControllerUI;
import controller.UI.LivroControllerUI;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Livro;

public class PainelDevolucao extends javax.swing.JPanel {

	private ClienteControllerUI controllerCliente;
	private AluguelControllerUI controllerAluguel;
	private LivroControllerUI controllerLivro;
	private DevolucaoControllerUI controller;

	public PainelDevolucao(DevolucaoControllerUI controller) {
		this.controller = controller;
		initComponents();
	}

	private void initComponents() {

		botaoVisualizar = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tabelaLivros = new javax.swing.JTable();
		botaoInserir = new javax.swing.JButton();
		botaoEditar = new javax.swing.JButton();
		botaoRemover = new javax.swing.JButton();

		botaoVisualizar.setText("Visualizar");
		botaoVisualizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoVisualizarActionPerformed(evt);
			}
		});

		tabelaLivros.setModel(new DevolucaoTableModel());
		jScrollPane1.setViewportView(tabelaLivros);

		botaoInserir.setText("Devolução");
		botaoInserir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoInserirActionPerformed(evt);
			}
		});

		botaoEditar.setText("Procurar livro por titulo");
		botaoEditar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoEditarActionPerformed(evt);
			}
		});

		botaoRemover.setText("Procurar livro por isbn");
		botaoRemover.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoRemoverActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(botaoInserir).addGap(10, 10, 10)
										.addComponent(botaoEditar).addGap(18, 18, 18).addComponent(botaoRemover)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(botaoVisualizar))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(botaoInserir).addComponent(botaoEditar).addComponent(botaoRemover)
								.addComponent(botaoVisualizar))
						.addGap(19, 19, 19)));
	}

	private void botaoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {
		controller.visualizarLivro();
	}

	private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {
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
	}

	private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String idAluguel = "";
			String[] opcoes = { "sim", "não" };
			String titulo = JOptionPane.showInputDialog("Digite o titulo desejado:");
			controllerLivro = new LivroControllerUI();
			if (controllerLivro.LivroExiste(titulo)) {
				Livro li = controllerLivro.buscarLivroPorTitulo(titulo);
				JOptionPane.showMessageDialog(this, "Livro Encontrado! \nTitulo: " + li.getTitulo() + "\nAutor: "
						+ li.getAutor() + "\nAno de Publicação: " + li.getAnoPublicacao());
				int op = JOptionPane.showOptionDialog(this, "Deseja devolver este livro?", "Livro encontrado!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (op == 0) {
					String rg = JOptionPane.showInputDialog("Digite seu RG: ");
					controllerCliente = new ClienteControllerUI();
					if (controllerCliente.clienteExiste(Long.parseLong(rg))) {
						idAluguel = JOptionPane.showInputDialog("Digite o isbn do livro:");
						controllerAluguel = new AluguelControllerUI();
						if (controllerAluguel.CodigoExiste(Integer.parseInt(idAluguel))) {
							JOptionPane.showMessageDialog(this, "Processando Dados...");
							controller.salvarDevolucao(Long.parseLong(rg), Integer.parseInt(idAluguel));
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

	private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String idAluguel = "";
			String[] opcoes = { "sim", "não" };
			String isbn = JOptionPane.showInputDialog("Digite o ISBN desejado:");
			controllerLivro = new LivroControllerUI();
			if (controllerLivro.LivroExiste(Long.parseLong(isbn))) {
				Livro li = controllerLivro.buscarLivroPorIsbn(Long.parseLong(isbn));
				JOptionPane.showMessageDialog(this, "Livro Encontrado! \nTitulo: " + li.getTitulo() + "\nAutor: "
						+ li.getAutor() + "\nAno de Publicação: " + li.getAnoPublicacao());
				int op = JOptionPane.showOptionDialog(this, "Deseja devolver este livro?", "Livro encontrado!",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (op == 0) {
					String rg = JOptionPane.showInputDialog("Digite seu RG: ");
					controllerCliente = new ClienteControllerUI();
					if (controllerCliente.clienteExiste(Long.parseLong(rg))) {
						idAluguel = JOptionPane.showInputDialog("Digite o isbn do livro:");
						controllerAluguel = new AluguelControllerUI();
						if (controllerAluguel.CodigoExiste(Integer.parseInt(idAluguel))) {
							JOptionPane.showMessageDialog(this, "Processando Dados...");
							controller.salvarDevolucao(Long.parseLong(rg), Integer.parseInt(idAluguel));
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

	public JButton getBotaoEditar() {
		return botaoEditar;
	}

	public JButton getBotaoInserir() {
		return botaoInserir;
	}

	public JButton getBotaoRemover() {
		return botaoRemover;
	}

	public JButton getBotaoVisualizar() {
		return botaoVisualizar;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public JTable getTabelaDevolucao() {
		return tabelaLivros;
	}

	private javax.swing.JButton botaoEditar;
	private javax.swing.JButton botaoInserir;
	private javax.swing.JButton botaoRemover;
	private javax.swing.JButton botaoVisualizar;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tabelaLivros;

}
