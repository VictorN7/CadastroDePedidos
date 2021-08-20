package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senai.sp.model.Cliente;
import br.senai.sp.model.DetalheDaNota;
import br.senai.sp.model.DetalhePedido;
import br.senai.sp.model.FecharNota;
import br.senai.sp.model.Item;



public class ClienteDao {

	private String stringConexao = "jdbc:mysql://localhost/AVALIACAODB?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "root";
	
	private Connection conexao = null;

	public boolean conectar() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conexao = DriverManager.getConnection(stringConexao, usuario, senha);
			
			return true;
		}catch(SQLException e1) {
			return false;
		}

	}
	
public List<Cliente> listarCliente() {
		
		if (conectar()) {
			String sql = "SELECT id_cliente, cpf, nome, sobrenome FROM AVALIACAODB.clientes";
			
			List<Cliente> lista = new ArrayList<Cliente>();
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
			
				ResultSet rs = acaoSql.getResultSet();
				while (rs.next()) {
					
					Cliente a = new Cliente(rs.getInt("id_cliente"),rs.getString("cpf"),rs.getString("nome"), rs.getString("sobrenome"));
					
					lista.add(a);
					
				}
				
			} catch (SQLException e) {
				return null;
			}
						
			return lista;
		}
		
		return null;
	}

public List<Item> listarItens() {
	
	if (conectar()) {
		String sql = "SELECT id_item, descricao, vlr_unitario FROM AVALIACAODB.tbl_itens";
		
		List<Item> lista = new ArrayList<Item>();
		try {
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);
		
			ResultSet rs = acaoSql.getResultSet();
			while (rs.next()) {
				
				Item item = new Item(rs.getInt("id_item"),rs.getString("descricao"),rs.getFloat("vlr_unitario"));
				
				lista.add(item);
				
			}
			
		} catch (SQLException e) {
			return null;
		}
					
		return lista;
	}
	
	return null;
}

public boolean novoDetItem(DetalheDaNota detNota) {
	
		
	if (conectar()) {
		String sql = "INSERT INTO tbl_det_itens (cod_pedidos, id_item, qtd)"
				+ " VALUES('"+ detNota.getCod_pedidos()
				+ "', '" + detNota.getId_item()
				+ "', '" + detNota.getQuantidade() + "')";
		
		
		try {
			
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);

		
		} catch (SQLException e) {
		return false;
		}	
	return true;
	}
	else {return false;}
}


	
public List<DetalhePedido> listarDetItens(String cod) {
	
	if (conectar()) {
		String sql = "SELECT cod_pedidos, descricao, qtd, vlr_unitario, vlr_total FROM AVALIACAODB.uv_VlrTotalItens WHERE cod_pedidos="+cod;
		
		List<DetalhePedido> lista = new ArrayList<DetalhePedido>();
		try {
			
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);
		
			ResultSet rs = acaoSql.getResultSet();
			while (rs.next()) {
				
				DetalhePedido detPedido = new DetalhePedido (rs.getString("cod_pedidos"),rs.getString("descricao"),rs.getInt("qtd"),rs.getFloat("vlr_unitario"), rs.getFloat("vlr_total"));
				
				lista.add(detPedido);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error catch");
			return null;
		
		}
					
		return lista;
	}
	return null;
}

public String BuscarPorCodigo(String codigo) {
	
	if (conectar()) {
		String sql = "SELECT sum(vlr_total) FROM uv_VlrTotalItens WHERE cod_pedidos="+codigo;
		
		try {
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);
			
			ResultSet rs = acaoSql.getResultSet();
			
			if (rs.next()) {
		
				String valorTotal = rs.getString("sum(vlr_total)");
				
				return valorTotal;
			}

			return null;
			
		} catch (SQLException e) {
			return null;
		}	
		
	}
	return null;	
  }


public Cliente BuscarCliPorId(int id_cliente) {
	
	if (conectar()) {
		String sql = "SELECT * FROM clientes WHERE id_cliente="+id_cliente;
		
		try {
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);
			
			ResultSet rs = acaoSql.getResultSet();
			
			if (rs.next()) {
		
				Cliente cliente = new Cliente (rs.getInt("id_cliente"),rs.getString("cpf"),rs.getString("nome"),rs.getString("sobrenome"));
				
				return cliente;
			}

			return null;
			
		} catch (SQLException e) {
			return null;
		}	
		
	}
	return null;	
  }

public boolean salvarNota(String codigo, int cli ) {
	
	
	if (conectar()) {
		String sql = "INSERT INTO  tbl_nota_fiscal (id_cliente, cod_pedidos)"
				+ " VALUES('"+ cli
				+ "', '" + codigo + "')";
		
		
		try {
			Statement acaoSql = conexao.createStatement();
			acaoSql.execute(sql);

		
		} catch (SQLException e) {
			System.out.println("Error catch");
		return false;
		}	
	return true;
	}
	else {return false;}
 }

}
