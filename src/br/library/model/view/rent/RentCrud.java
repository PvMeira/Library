package br.library.model.view.rent;



import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class RentCrud extends JFrame {
    private RentController controller;
    
    public final static String PANELFORM = "Form";
    public final static String PANELTABLE = "Table";
    private JPanel mainWindow; 
    private RentRegisterPanel rentRegisterPanel;
    private RentPanel rentPanel;


    public RentCrud(JFrame jframe, RentController controller) {
        this.controller = controller;
        this.controller.setWindow(this);
        StartParam();
        controller.updateTable();
        this.setTitle("Biblioteca");
        this.pack();
        this.setLocationRelativeTo(jframe);
        this.setVisible(true);
    }

    private void StartParam() {
        mainWindow = new JPanel(new CardLayout());
        rentPanel = new RentPanel(controller);
        mainWindow.add(rentPanel, PANELTABLE);
        rentRegisterPanel = new RentRegisterPanel(controller);
        mainWindow.add(rentRegisterPanel, PANELFORM);
        this.add(mainWindow);
    }

    public void showPanel(String panel) {
        CardLayout card = (CardLayout) (mainWindow.getLayout());
        card.show(mainWindow, panel);

    }

    public RentPanel getRentPanel() {
        return rentPanel;
    }

    public void setController(RentController controller) {
        this.controller = controller;
    }
    
    public RentRegisterPanel getRentRegisterPanel() {
        return rentRegisterPanel;
    }
}
