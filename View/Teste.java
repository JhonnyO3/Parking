package View;

import javax.swing.JOptionPane;

import Controller.CarroController;

public class Teste {

	public static void main(String[] args) {
		CarroController carro = new CarroController();
		
		JOptionPane.showMessageDialog
		(null, carro.insereCarro("ABC1234", "Azul-Marinho", "Opala"));
		
		JOptionPane.showMessageDialog
		(null, carro.alteraCarro("ABC1234", "Rosa", "Opala"));
		
		JOptionPane.showMessageDialog
		(null, carro.excluirCarro("ABC1234"));
		
		

	}

}
