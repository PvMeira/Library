package br.library.model.view.book;
/**
 * @author Pedro
 *
 */
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.library.model.controller.BookController;



public class BookCRUDWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private BookController controller;
    
    public final static String PANELFORM = "Formulario";
    public final static String PANELTABLE = "Tabela";
    private JPanel mainWindow;    
    private RegisterBookPanel registerBookPanel;
    private BookPanel bookPanel;

    public BookCRUDWindow(JFrame jframe, BookController controller) {
        this.controller = controller;
        this.controller.setJanela(this);
        startParam();
        controller.updateTable();
        this.setTitle("Biblioteca");
        this.pack();
        this.setLocationRelativeTo(jframe);
        this.setVisible(true);
    }
  
    private void startParam() {
        mainWindow = new JPanel(new CardLayout());
        bookPanel = new BookPanel(controller);
        mainWindow.add(bookPanel, PANELTABLE);
        registerBookPanel = new RegisterBookPanel(controller);
        mainWindow.add(registerBookPanel, PANELFORM);
        this.add(mainWindow);
    }

    public void showPanel(String panel) {
        CardLayout card = (CardLayout) (mainWindow.getLayout());
        card.show(mainWindow, panel);

    }

    public RegisterBookPanel getRegisterBookPanel() {
        return registerBookPanel;
    }

    public BookPanel getPanelTable() {
        return bookPanel;
    }

    public void setController(BookController controller) {
        this.controller = controller;
    }
    
    

}
