package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	
	public void inserir(Cliente cliente) {
		String sql = "INSERT INTO clientes (nome,email) VALUES(?,?)";
		try (Connection conn = Conexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.executeUpdate();
			
			System.out.println("Cliente inserido com sucesso!");
			
		} catch (SQLException e) {
		    System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
		    throw new RuntimeException("Falha na operação com o banco de dados", e);
		}
	}
	
	public List<Cliente> listarClientes() {
		List<Cliente> lista = new ArrayList<>();
		String sql = "SELECT * FROM clientes";
		
		try (Connection conn = Conexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()) {
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				lista.add(cliente);
			}
			
		} catch (SQLException e) {
		    System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
		    throw new RuntimeException("Falha na operação com o banco de dados", e);
		}
		return lista;
	}
	
	public void atualizar(Cliente cliente) {
		String sql = "UPDATE clientes SET nome=?, email=? WHERE id=?";
		try (Connection conn = Conexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setInt(3, cliente.getId());
			stmt.executeUpdate();
			
			System.out.println("Cliente atualizado com sucesso!");
			
		} catch (SQLException e) {
		    System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
		    throw new RuntimeException("Falha na operação com o banco de dados", e);
		}
	}
	
	public void deletar(int id) {
		String sql = "DELETE FROM clientes WHERE id=?";
		try (Connection conn = Conexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println("Cliente removido com sucesso!");
			
		} catch (SQLException e) {
		    System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
		    throw new RuntimeException("Falha na operação com o banco de dados", e);
		}
	}
	
	public boolean existeCliente(int id) {
	    String sql = "SELECT COUNT(*) FROM clientes WHERE id = ?";
	    try (Connection conn = Conexao.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0;
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao verificar existência do cliente: " + e.getMessage());
	    }
	    return false;
	}
	
	public Cliente buscarPorId(int id) {
	    String sql = "SELECT id, nome, email FROM clientes WHERE id = ?";
	    
	    try (Connection conn = Conexao.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, id);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                Cliente cliente = new Cliente();
	                cliente.setId(rs.getInt("id"));
	                cliente.setNome(rs.getString("nome"));
	                cliente.setEmail(rs.getString("email"));
	                return cliente;
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("[ERRO] Falha ao buscar cliente: " + e.getMessage());
	    }
	    
	    return null;
	}
	
}
