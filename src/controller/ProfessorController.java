package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProfessorController implements ActionListener {
	private JTextField tfCpf;
	private JTextField tfNomeProfessor;
	private JTextField tfAreaConhecimentoProfessor;
	private JTextArea taProfessoresLista;
	
	public ProfessorController(JTextField tfCpf, JTextField tfNome, JTextField tfAreaConhecimento, JTextArea taProfessoresLista) {
		super();
		this.tfCpf = tfCpf;
		this.tfNomeProfessor = tfNome;
		this.tfAreaConhecimentoProfessor = tfAreaConhecimento;
		this.taProfessoresLista = taProfessoresLista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		 try {
	            if (cmd.equals("Cadastrar")) {
	                cadastrar();
	            } else if (cmd.equals("Buscar")) {
	                buscar();
	            }
	        } catch (IOException ex) {
	            taProfessoresLista.setText("Erro: " + ex.getMessage());
	        }
	}

	private void buscar()  throws IOException{
		// TODO Auto-generated method stub
		
	}

	private void cadastrar()  throws IOException {
		// TODO Auto-generated method stub
		
	}
}
