/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.library.model.view.client;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import br.library.domain.profile.Client;


public class ClientTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String header[];
    private List<Client> clients;

    public ClientTableModel()
    {
        this.header = new String[]{"CPF","Nome","Telefone","Matricula","Livros em posse","Quantidade de livros alugados","Quantidade de Atrasos"};
        this.clients = new ArrayList<Client>();
    }
 
    public ClientTableModel(String[] header, List<Client> clients)
    {
        this.header = header;
        this.clients = clients;

    }

    @Override
    public int getRowCount() {
        return(this.clients.size());
    }

    @Override
    public int getColumnCount() {
        return(7);
    }

    @Override
    public String getColumnName(int column) {
        return header[column]; 
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(this.clients.get(rowIndex).getCpf());
        else if(columnIndex == 1)
            return(this.clients.get(rowIndex).getName());
        else if(columnIndex == 2)
            return(this.clients.get(rowIndex).getPhone());
        else if(columnIndex == 3)
            return(this.clients.get(rowIndex).getRegister());
        else if(columnIndex == 4)
            return(this.clients.get(rowIndex).getBooksRent());
        else if(columnIndex == 5)
            return(this.clients.get(rowIndex).getQuantityOfBooksRent());
        else if(columnIndex == 6)
            return(this.clients.get(rowIndex).getLate());
        else 
           return null;
    }

    public void setClient(List<Client> clients)
    {
        this.clients = clients;
    }

    public Client getClient(int line)
    {
        return(clients.get(line));
    }
}
