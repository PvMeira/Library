package br.library.model.view.rent;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.library.model.controller.RentController;
/**
 * @author Pedro
 *
 */

public class RentCRUDWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private RentController controller;
    
    public final static String PANELFORM = "Formulario";
    public final static String PANELTABLE = "Tabela";
    private JPanel mainPanel; 
    private RentRegisterPanel rentRegisterPanel;
    private RentPanel rentPanel;

    public RentCRUDWindow(JFrame jframe, RentController controller) {
        this.controller = controller;
        this.controller.setWindow(this);
        startParam();
        controller.updateTable();
        this.setTitle("Biblioteca");
        this.pack();
        this.setLocationRelativeTo(jframe);
        this.setVisible(true);
    }

    private void startParam() {
        mainPanel = new JPanel(new CardLayout());
        rentPanel = new RentPanel(controller);
        mainPanel.add(rentPanel, PANELTABLE);
        rentRegisterPanel = new RentRegisterPanel(controller);
        mainPanel.add(rentRegisterPanel, PANELFORM);
        this.add(mainPanel);
    }

    public void showPanel(String panel) {
        CardLayout card = (CardLayout) (mainPanel.getLayout());
        card.show(mainPanel, panel);

    }

    public RentPanel getRentPanel() {
        return rentPanel;
    }

    public void setController(RentController controller) {
        this.controller = controller;
    }
    
    public RentRegisterPanel getRegisterPanel() {
        return rentRegisterPanel;
    }
}
