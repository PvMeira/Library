package br.library.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.library.dao.interf.ClientDAO;
import br.library.domain.profile.Client;
import br.library.infra.persistence.setup.BDExeption;

public class ClientDAOBd extends AbstractDao<Client> implements ClientDAO {

	 @Override
	    public void insert(Client client) {
	        int id;
	        try {
	            String sql = "INSERT INTO client (nome, rg, telefone, matricula, livrosAlugados, qntdelivrosalugados, qntdeatraso) "
	                    + "VALUES (?,?,?,?,?,?,?)";

	            //Foi criado um novo método conectar para obter o id
	            conectarObtendoId(sql);
	            comando.setString(1, client.getNome());
	            comando.setLong(2, client.getRg());
	            comando.setString(3, client.getTelefone());
	            comando.setLong(4, client.getMatricula());
	            comando.setInt(5, client.getLivrosAlugados());
	            comando.setInt(6, client.getQntdelivrosalugados());
	            comando.setInt(7, client.getQntdeatraso());
	            comando.executeUpdate();
	            //Obtém o resultSet para pegar o id
	            ResultSet resultado = comando.getGeneratedKeys();
	            if (resultado.next()) {
	                //seta o id para o objeto
	                id = resultado.getInt(1);
	                client.setId(id);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	        //Caso queira retornar id:
	        //return (id);
	    }

	    @Override
	    public void deletar(Cliente cliente) {
	        try {
	            String sql = "DELETE FROM cliente WHERE rg = ?";

	            conectar(sql);
	            comando.setLong(1, cliente.getRg());
	            comando.executeUpdate();

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	    }

	    @Override
	    public void editar(Cliente c, String novoX, String coluna) {
	        String sql = "UPDATE cliente SET " + coluna + "=(?) WHERE id=(?)";
	        try {
	            conectar(sql);
	            comando.setString(1, novoX);
	            comando.setInt(2, c.getId());
	            comando.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }
	    }

	    @Override
	    public void editar(Cliente c, long novoX, String coluna) {
	        String sql = "UPDATE cliente SET " + coluna + "=(?) WHERE id=(?)";
	        try {
	            conectar(sql);
	            comando.setLong(1, novoX);
	            comando.setInt(2, c.getId());
	            comando.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }
	    }

	    @Override
	    public List<Cliente> listar() {
	        List<Cliente> listaClientes = new ArrayList<>();

	        String sql = "SELECT * FROM cliente ORDER BY nome";

	        try {
	            conectar(sql);

	            ResultSet resultado = comando.executeQuery();

	            while (resultado.next()) {
	                int id = resultado.getInt("id");
	                String nome = resultado.getString("nome");
	                long rg = resultado.getLong("rg");
	                String telefone = resultado.getString("telefone");
	                long matricula = resultado.getLong("matricula");
	                int livrosAlugados = resultado.getInt("livrosAlugados");
	                int qntdelivrosalugados = resultado.getInt("qntdelivrosalugados");
	                int qntdeatraso = resultado.getInt("qntdeatraso");

	                Cliente cli = new Cliente(id, nome, rg, telefone, matricula, livrosAlugados, qntdelivrosalugados, qntdeatraso);

	                listaClientes.add(cli);

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	        return (listaClientes);
	    }

	    @Override
	    public Cliente procurarPorId(int id) {
	        String sql = "SELECT * FROM cliente WHERE id = ?";

	        try {
	            conectar(sql);
	            comando.setInt(1, id);

	            ResultSet resultado = comando.executeQuery();

	            if (resultado.next()) {
	                String nome = resultado.getString("nome");
	                long rg = resultado.getLong("rg");
	                String telefone = resultado.getString("telefone");
	                long matricula = resultado.getLong("matricula");
	                int livrosAlugados = resultado.getInt("livrosAlugados");
	                int qntdelivrosalugados = resultado.getInt("qntdelivrosalugados");
	                int qntdeatraso = resultado.getInt("qntdeatraso");

	                Cliente cli = new Cliente(id, nome, rg, telefone, matricula, livrosAlugados, qntdelivrosalugados, qntdeatraso);

	                return cli;

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	        return (null);
	    }

	    @Override
	    public Cliente procurarPorRg(long rg) {
	        String sql = "SELECT * FROM cliente WHERE rg = ?";

	        try {
	            conectar(sql);
	            comando.setLong(1, rg);

	            ResultSet resultado = comando.executeQuery();

	            if (resultado.next()) {
	                int id = resultado.getInt("id");
	                String nome = resultado.getString("nome");
	                long rgX = resultado.getLong("rg");
	                String telefone = resultado.getString("telefone");
	                long matricula = resultado.getLong("matricula");
	                int livrosAlugados = resultado.getInt("livrosAlugados");
	                int qntdelivrosalugados = resultado.getInt("qntdelivrosalugados");
	                int qntdeatraso = resultado.getInt("qntdeatraso");

	                Cliente cli = new Cliente(id, nome, rgX, telefone, matricula, livrosAlugados, qntdelivrosalugados, qntdeatraso);

	                return cli;

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	        return (null);
	    }

	    @Override
	    public Cliente procurarPorNome(String nome) {
	        String sql = "SELECT * FROM cliente WHERE nome = ?";

	        try {
	            conectar(sql);
	            comando.setString(1, nome);

	            ResultSet resultado = comando.executeQuery();

	            if (resultado.next()) {
	                int id = resultado.getInt("id");
	                String nomeX = resultado.getString("nome");
	                long rg = resultado.getLong("rg");
	                String telefone = resultado.getString("telefone");
	                long matricula = resultado.getLong("matricula");
	                int livrosAlugados = resultado.getInt("livrosAlugados");
	                int qntdelivrosalugados = resultado.getInt("qntdelivrosalugados");
	                int qntdeatraso = resultado.getInt("qntdeatraso");

	                Cliente cli = new Cliente(id, nomeX, rg, telefone, matricula, livrosAlugados, qntdelivrosalugados, qntdeatraso);

	                return cli;

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	        return (null);
	    }

	    @Override
	    public Cliente procurarPorMatricula(long matricula) {
	        String sql = "SELECT * FROM cliente WHERE matricula = ?";

	        try {
	            conectar(sql);
	            comando.setLong(1, matricula);

	            ResultSet resultado = comando.executeQuery();

	            if (resultado.next()) {
	                int id = resultado.getInt("id");
	                String nome = resultado.getString("nome");
	                long rg = resultado.getLong("rg");
	                String telefone = resultado.getString("telefone");
	                long matriculaX = resultado.getLong("matricula");
	                int livrosAlugados = resultado.getInt("livrosAlugados");
	                int qntdelivrosalugados = resultado.getInt("qntdelivrosalugados");
	                int qntdeatraso = resultado.getInt("qntdeatraso");

	                Cliente cli = new Cliente(id, nome, rg, telefone, matriculaX, livrosAlugados, qntdelivrosalugados, qntdeatraso);

	                return cli;

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	        return (null);
	    }

	    @Override
	    public List<Cliente> listarPorNome(String nome) {
	        List<Cliente> listaClientes = new ArrayList<>();
	        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";

	        try {
	            conectar(sql);
	            comando.setString(1, "%" + nome + "%");
	            ResultSet resultado = comando.executeQuery();

	            while (resultado.next()) {
	                int id = resultado.getInt("id");
	                String nomeX = resultado.getString("nome");
	                long rg = resultado.getLong("rg");
	                String telefone = resultado.getString("telefone");
	                long matricula = resultado.getLong("matricula");
	                int livrosAlugados = resultado.getInt("livrosAlugados");
	                int qntdelivrosalugados = resultado.getInt("qntdelivrosalugados");
	                int qntdeatraso = resultado.getInt("qntdeatraso");

	                Cliente cli = new Cliente(id, nomeX, rg, telefone, matricula, livrosAlugados, qntdelivrosalugados, qntdeatraso);

	                listaClientes.add(cli);

	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            fecharConexao();
	        }

	        return (listaClientes);
	    }

}
