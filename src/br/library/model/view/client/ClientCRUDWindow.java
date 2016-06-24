package br.library.model.view.client;


import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.library.model.controller.ClientController;

public class ClientCRUDWindow extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ClientController controller;
    
    public final static String PANELFORM = "Formulario";
    public final static String PANELTABLE = "Tabela";
    private JPanel mainPanel;    
    private RegisterClientPanel clientRegisterPanel;
    private ClientPanel clientPanel;


    public ClientCRUDWindow(JFrame jframe, ClientController controller) {
        this.controller = controller;
        this.controller.setWindow(this);
        initParam();
        controller.updateTable();
        this.setTitle("Menu Cliente");
        this.pack();
        this.setLocationRelativeTo(jframe);
        this.setVisible(true);
    }

    private void initParam() {
        mainPanel = new JPanel(new CardLayout());
        clientPanel = new ClientPanel(controller);
        mainPanel.add(clientPanel, PANELTABLE);
        clientRegisterPanel = new RegisterClientPanel(controller);
        mainPanel.add(clientRegisterPanel, PANELFORM);
        this.add(mainPanel);
    }

    public void showPanel(String panel) {
        CardLayout card = (CardLayout) (mainPanel.getLayout());
        card.show(mainPanel, panel);

    }

    public RegisterClientPanel getPanelForm() {
        return clientRegisterPanel;
    }

    public ClientPanel getPanelTable() {
        return clientPanel;
    }

    public void setController(ClientController controller) {
        this.controller = controller;
    }
    
    

}
