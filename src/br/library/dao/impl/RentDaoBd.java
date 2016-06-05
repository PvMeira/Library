package br.library.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.library.dao.interf.BookDAO;
import br.library.dao.interf.ClientDAO;
import br.library.dao.interf.RentDAO;
import br.library.domain.profile.Book;
import br.library.domain.profile.Client;
import br.library.domain.profile.Rent;

public class RentDaoBd extends AbstractDao<Rent> implements RentDAO{
	@Override
    public void insert(Rent rent) {
        int id;
        try {
            String sql = "INSERT INTO rent (rentDate, id_client, bookCode) "
                    + "VALUES (?,?,?)";
            //Foi criado um novo método conectar para obter o id
            conectUsingId(sql);
            //Trabalhando com data: lembrando dataUtil -> dataSql
            java.sql.Date dataSql = new java.sql.Date(rent.getDataAluguel().getTime());
            comand.setDate(1, dataSql);
            comand.setInt(2, rent.getC().getId());
            comand.setInt(3, rent.getLivrosAlugados().getCod());
            comand.executeUpdate();
            //Obtém o resultSet para pegar o id
            ResultSet resultado = comand.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                id = resultado.getInt(1);
                rent.setId(id);
            }
            updateClient(rent);
            updateBook(rent);
            updateQuntityOfBooks(rent);
            atualizarQntLivrosAlugadosCliente(rent);

        } catch (SQLException ex) {
        	System.err.println("Erro de Sistema - Problema ao atualizar Cliente");
			throw new RuntimeException(ex);
        } finally {
            closeConection();
        }

        //Caso queira retornar id:
        //return (id);
    }

    @Override
    public void updateClient(Rent rent) {
        try {
            String sql = "UPDATE client SET rentedBooks=(rentedBooks+1) "
                    + "WHERE id=?";

            conect(sql);
            comand.setInt(1, rent.getC().getId());
            comand.executeUpdate();

        } catch (SQLException ex) {
        	System.err.println("Erro de Sistema - Problema ao atualizar Cliente");
			throw new RuntimeException(ex);
        } finally {
            closeConection();
        }
    }

    @Override
    public void updateBook(Rent rent) {
        try {
            String sql = "UPDATE book SET avaliable=false "
                    + "WHERE cod=?";
            conect(sql);
            comand.setInt(1, rent.getLivrosAlugados().getCod());
            comand.executeUpdate();

        } catch (SQLException ex) {
        	System.err.println("Erro de Sistema - Problema ao atualizar Livro");
			throw new RuntimeException(ex);
        } finally {
        	closeConection();
        }
    }

    @Override
    public void updateQuntityOfBooks(Rent rent) {
        try {
            String sql = "UPDATE book SET qntdeTotalAlugado=(qntdeTotalAlugado+1) "
                    + "WHERE cod=?";
            conect(sql);
            comand.setInt(1, aluguel.getLivrosAlugados().getCod());
            comand.executeUpdate();

        } catch (SQLException ex) {
        	System.err.println("Erro de Sistema - Problema ao  atualizar quantidade no Livro");
			throw new RuntimeException(ex);
        } finally {
        	closeConection();
        }
    }

    @Override
    public void updateQuantityOfRentBooksByClient(Rent rent) {
        try {
            String sql = "UPDATE cliente SET qntdelivrosalugados=(qntdelivrosalugados+1) "
                    + "WHERE id=?";
            conect(sql);
            comand.setInt(1, rent.getC().getId());
            comand.executeUpdate();

        } catch (SQLException ex) {
        	System.err.println("Erro de Sistema - Problema ao  atualizar quantidade de livros alugados pelo cliente");
			throw new RuntimeException(ex);
        } finally {
        	closeConection();
        }
    }

    @Override
    public List<Rent> list() {
        List<Rent> rentList = new ArrayList<>();
        String sql = "SELECT * FROM rent ORDER BY id";
        try {
            conect(sql);
            ResultSet resultado = comand.executeQuery();
            while (resultado.next()) {
                int idAluguel = resultado.getInt("idAluguel");
                //Trabalhando com data: lembrando dataSql -> dataUtil
                java.sql.Date dataSql = resultado.getDate("rentDate");
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                int id = resultado.getInt("id_cliente");
                int code = resultado.getInt("bookCode");
                ClientDAO clientDao = new ClientDAOBd();
                BookDAO bookDao = new BookDaoBd();
                Client client1 = clientDao.searchById(id);
                Book book = bookDao.searchByIsbn(code);

                Rent aluguel = new Rent(idAluguel, dataUtil, client1, book);
                rentList.add(aluguel);
            }
        } catch (SQLException ex) {
        	System.err.println("Erro de Sistema - Problema ao  atualizar quantidade de livros alugados pelo cliente");
			throw new RuntimeException(ex);
        } finally {
        	closeConection();
        }
        return (rentList);
    }

    @Override
    public Rent searchById(int id) {
        String sql = "SELECT * FROM rent WHERE idAluguel = ?";

        try {
            conect(sql);
            comand.setLong(1, id);

            ResultSet resultado = comand.executeQuery();

            if (resultado.next()) {
               int idAluguel = resultado.getInt("id");
                //Trabalhando com data: lembrando dataSql -> dataUtil
                java.sql.Date dataSql = resultado.getDate("rentDate");
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                int idX = resultado.getInt("id_client");
                int code = resultado.getInt("bookRent");
                ClientDAO clientDao = new ClientDAOBd();
                BookDAO bookDao = new BookDaoBd();
                Client client1 = clientDao.searchById(idX);
                Book book = bookDao.searchByIsbn(code);

                Rent aluguel = new Rent(idAluguel, dataUtil, cli, livro);
                return aluguel;
            }
        } catch (SQLException ex) {
        	System.err.println("Erro de Sistema - Problema ao  atualizar quantidade de livros alugados pelo cliente");
			throw new RuntimeException(ex);
        } finally {
        	closeConection();
        }

        return (null);
    }
   
}
