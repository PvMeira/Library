package br.library.infra.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class messengerJFrame {


    public static void printErrorMessage(JFrame window, String mesenge) {
            JOptionPane.showMessageDialog(window, 
                    mesenge,
                    "e r r o r",
                    JOptionPane.ERROR_MESSAGE);        
    }


    public static void printSucessMesenge(JFrame window, String mesenge) {
            JOptionPane.showMessageDialog(window, 
                    mesenge,
                    "s u c e s s o",
                    JOptionPane.PLAIN_MESSAGE);        
    }    
}
