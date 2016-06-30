package br.library.model.view.devolution;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.library.model.controller.DevolutionController;

public class DevolutionCRUDWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private DevolutionController controller;

	public final static String PANELFORM = "Formulario";
	public final static String PANELTABLE = "Tabela";
	private JPanel main;
	private DevolutionRegiterPanel devolutionRegiterPanel;
	private DevolutionPanel devolutionPanel;

	public DevolutionCRUDWindow(JFrame jframe, DevolutionController controller) {
		this.controller = controller;
		this.controller.setWindow(this);
		initParam();
		controller.updateWindow();
		this.setTitle("Devolução");
		this.pack();
		this.setLocationRelativeTo(jframe);
		this.setVisible(true);
	}

	private void initParam() {
		main = new JPanel(new CardLayout());
		devolutionPanel = new DevolutionPanel(controller);
		main.add(devolutionPanel, PANELTABLE);
		devolutionRegiterPanel = new DevolutionRegiterPanel(controller);
		main.add(devolutionRegiterPanel, PANELFORM);
		this.add(main);
	}

	public void showPanel(String panel) {
		CardLayout card = (CardLayout) (main.getLayout());
		card.show(main, panel);

	}

	public DevolutionPanel getPanelTable() {
		return devolutionPanel;
	}

	public void setController(DevolutionController controller) {
		this.controller = controller;
	}

	public DevolutionRegiterPanel getRegisterPanel() {
		return devolutionRegiterPanel;
	}
}
