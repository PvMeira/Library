
package br.library.model.view.report;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Pedro
 *
 */

public class ReportWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	public final static String PANELFORM = "Formulario";
	public final static String PANELTABLE = "Tabela";
	private JPanel MAIN;

	public ReportWindow(JFrame jframe) {
		initComp();
		this.setTitle("Relátorio");
		this.pack();
		this.setLocationRelativeTo(jframe);
		this.setVisible(true);
	}

	private void initComp() {
		MAIN = new JPanel(new CardLayout());
		MAIN.add(this, PANELTABLE);
		this.add(MAIN);
	}

	public void showPanel(String panel) {
		CardLayout card = (CardLayout) (MAIN.getLayout());
		card.show(MAIN, panel);

	}

}
