package br.library.model.view.rent;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RentPanel extends javax.swing.JPanel {

    private ClientController clientController;
    private RentController controller;
    private BookController bookController;


    public RentPanel(RentController controller) {
        initComponents();
        this.controller = controller;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        viewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        insertButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        viewButton.setText("Visualizar");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	viewButtonActionPerformed(evt);
            }
        });

        bookTable.setModel(new RentModelTable());
        jScrollPane1.setViewportView(bookTable);

        insertButton.setText("Alugar");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	insertButtonActionPerformed(evt);
            }
        });

        editButton.setText("Procurar livro por titulo");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	editButtonActionPerformed(evt);
            }
        });
}
}