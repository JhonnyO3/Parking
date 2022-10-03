package Controller;
import java.sql.Connection;
import java.util.ArrayList;

import Model.Carro;
import Model.CarroDAO;
import Model.Conexao;

public class CarroController {
	
	public String insereCarro(String placa, String cor, String descricao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro cb = new Carro();
		
		cb.setPlaca(placa);
		cb.setCor(cor);
		cb.setDescricao(descricao);
		
		resultado = cd.inserir(cb);
		Conexao.fecharConexao(con);
		return resultado;
		
	}
	public String alteraCarro(String placa, String cor, String descricao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro cb = new Carro();
		
		cb.setPlaca(placa);
		cb.setCor(cor);
		cb.setDescricao(descricao);
		
		resultado = cd.alterar(cb);
		Conexao.fecharConexao(con);
		return resultado;
		
	}
	public String excluirCarro(String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro cb = new Carro();
		
		cb.setPlaca(placa);
		
		
		resultado = cd.excluir(cb);
		Conexao.fecharConexao(con);
		return resultado;
		
	}
	public ArrayList<String> listaCarro(String placa) {
		ArrayList<String> resultado = new ArrayList<String>();
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		resultado = cd.listarTodos(placa);
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
			
		} else {
			return null;

		}
		
	}

}
