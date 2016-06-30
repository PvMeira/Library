package br.library.model.view.menu;

import javax.swing.JOptionPane;

import br.library.model.controller.BookController;
import br.library.model.controller.ClientController;
import br.library.model.controller.DevolutionController;
import br.library.model.controller.RentController;
import br.library.model.view.book.BookCRUDWindow;
import br.library.model.view.client.ClientCRUDWindow;
import br.library.model.view.devolution.DevolutionCRUDWindow;
import br.library.model.view.rent.RentCRUDWindow;
import br.library.model.view.report.ReportPanel;

public class PanelMenu extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public PanelMenu() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jInternalFrame1 = new javax.swing.JInternalFrame();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem6 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jInternalFrame1.setVisible(true);

		jButton2.setText("Cliente");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Alugar");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("Devolver");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("Livro");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton1.setText("Pesquisar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jMenu1.setText("Menu");

		jMenuItem1.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
		jMenuItem1.setText("Cliente");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
		jMenuItem2.setText("Livro");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem3.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
		jMenuItem3.setText("Aluguel");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);

		jMenuItem4.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
		jMenuItem4.setText("Devolução");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem4);

		jMenuItem5.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
		jMenuItem5.setText("Pesquisa");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem5);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Informações Adicionais");

		jMenuItem6.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
		jMenuItem6.setText("Sobre o Desenvolvedor");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem6);

		jMenuBar1.add(jMenu2);

		jInternalFrame1.setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
		jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
		jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jInternalFrame1Layout.createSequentialGroup().addGap(18, 18, 18)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jInternalFrame1Layout.createSequentialGroup()
										.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 16, Short.MAX_VALUE)));
		jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(43, 43, 43)
						.addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(73, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jInternalFrame1));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jInternalFrame1));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 558, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 393, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));

		pack();
		setLocationRelativeTo(null);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		ClientController controller = new ClientController();
		ClientCRUDWindow janela = new ClientCRUDWindow(this, controller);
		controller.setWindow(janela);
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		RentController controller = new RentController();
		RentCRUDWindow window = new RentCRUDWindow(this, controller);
		controller.setWindow(window);
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		BookController controller = new BookController();
		BookCRUDWindow window = new BookCRUDWindow(this, controller);
		controller.setJanela(window);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		ReportPanel pr = new ReportPanel();
		pr.pack();
		pr.setLocationRelativeTo(this);
		pr.setVisible(true);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		ClientController controller = new ClientController();
		ClientCRUDWindow window = new ClientCRUDWindow(this, controller);
		controller.setWindow(window);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		BookController controller = new BookController();
		BookCRUDWindow window = new BookCRUDWindow(this, controller);
		controller.setJanela(window);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		RentController controller = new RentController();
		RentCRUDWindow window = new RentCRUDWindow(this, controller);
		controller.setWindow(window);
	}

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "Pedro Vitor Meira Ciria-Java Developemnt");
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		DevolutionController controller = new DevolutionController();
		DevolutionCRUDWindow window = new DevolutionCRUDWindow(this, controller);
		controller.setWindow(window);
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		DevolutionController controller = new DevolutionController();
		DevolutionCRUDWindow window = new DevolutionCRUDWindow(this, controller);
		controller.setWindow(window);
	}

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
		// PainelRelatorio pr = new PainelRelatorio();
		// pr.pack();
		// pr.setLocationRelativeTo(this);
		// pr.setVisible(true);
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PanelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PanelMenu().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JInternalFrame jInternalFrame1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JPanel jPanel1;

}