package Model;

import java.sql.*;
import java.util.*;

public class CarroDAO implements IDAO {
	private Connection con;
	private Carro carro;

	public CarroDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		carro = (Carro) obj;
		String sql = "insert into carro(placa,cor,descricao)";
		sql += "values(?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getCor());
			ps.setString(3, carro.getDescricao());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";

			} else {
				return "Erro ao inserir";

			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public String alterar(Object obj) {
		carro = (Carro) obj;
		String sql = "update carro set cor =?,descricao =?)";
		sql += "where placa =?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getCor());
			ps.setString(2, carro.getDescricao());
			ps.setString(3, carro.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";

			} else {
				return "Erro ao inserir";

			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public String excluir(Object obj) {
		carro = (Carro) obj;
		String sql = "delete from carro";
		sql += "where placa =?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";

			} else {
				return "Excluido ao inserir";

			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public ArrayList<String> listarTodos(String id) {
		String sql = "Select * from carro";
		sql += "where placa=?";
		ArrayList<String> result = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				result.add(rs.getString(1));
				result.add(rs.getString(2));
				result.add(rs.getString(3));
				return result;
				
			} else {
				return null;

			}

			
		} catch (SQLException e) {
			return null;
		}
	}


}
