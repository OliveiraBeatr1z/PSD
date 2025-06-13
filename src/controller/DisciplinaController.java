package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.Lista.Lista;
import br.edu.fateczl.filaObj.Fila;
import model.Disciplina;

public class DisciplinaController implements ActionListener{

    
    private JTextField tfDisciplinaCodigo;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaDiaDaSemana;
	private JTextField tfDisciplinaHorarioDaAula;
	private JTextField tfDisciplinaHorasDiarias;
	private JTextField tfDisciplinaCodigoCurso;
    private JTextArea taDisciplina;
    
 
    public DisciplinaController(JTextField tfDisciplinaCodigo, JTextField tfDisciplinaNome,
			JTextField tfDisciplinaDiaDaSemana, JTextField tfDisciplinaHorarioDaAula,
			JTextField tfDisciplinaHorasDiarias, JTextField tfDisciplinaCodigoCurso, JTextArea taDisciplina) {
		this.tfDisciplinaCodigo = tfDisciplinaCodigo;
		this.tfDisciplinaNome = tfDisciplinaNome;
		this.tfDisciplinaDiaDaSemana = tfDisciplinaDiaDaSemana;
		this.tfDisciplinaHorarioDaAula = tfDisciplinaHorarioDaAula;
		this.tfDisciplinaHorasDiarias = tfDisciplinaHorasDiarias;
		this.tfDisciplinaCodigoCurso = tfDisciplinaCodigoCurso;
		this.taDisciplina = taDisciplina;
	}
    
    
    @Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("Cadastrar")) {
			
			try {
				cadastraDisciplina();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(comando.equals("Buscar")) {
			
			try {
				consultaDisciplina();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(comando.equals("Atualizar")) {
			
			try {
				atualizaDisciplina();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(comando.equals("Remover")) {
			
			try {
				removeDisciplina();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
    

	// CADASTRA no final da lista
    private void cadastraDisciplina() throws Exception {
    	
    	Disciplina disciplina = new Disciplina();
    	
    	disciplina.setCodigoDisciplina(Integer.parseInt(tfDisciplinaCodigo.getText()));
    	disciplina.setNomeDisciplina(tfDisciplinaNome.getText());
    	disciplina.setDiaSemana(tfDisciplinaDiaDaSemana.getText());
    	disciplina.setHorarioAula(tfDisciplinaHorarioDaAula.getText());
    	disciplina.setHorasDiarias(Integer.parseInt(tfDisciplinaHorasDiarias.getText()));
    	disciplina.setCodigoCurso(Integer.parseInt(tfDisciplinaCodigoCurso.getText()));
    	
    	//manda gravar em formato String para o csv
    	gravarArquivoDisciplinaCsv2(disciplina.toString());
    	
    	//para apagar os campos:
    	tfDisciplinaCodigo.setText("");
    	tfDisciplinaNome.setText("");
    	tfDisciplinaDiaDaSemana.setText("");
    	tfDisciplinaHorarioDaAula.setText("");
    	tfDisciplinaHorasDiarias.setText("");
    	tfDisciplinaCodigoCurso.setText("");
    	
    	taDisciplina.setText("Disciplina cadastrada");
    }
    
    
    // CONSULTA usando FILA: todas as disciplinas são inseridas na fila
    private void consultaDisciplina() throws Exception {
    	
    	Disciplina disciplina = new Disciplina();
    	disciplina.setCodigoDisciplina(Integer.parseInt(tfDisciplinaCodigo.getText()));
    	
    	String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
		File arquivo = new File(path,"disciplinas.csv");
		
		if(arquivo.exists() && arquivo.isFile()) {
			FileInputStream fis = new FileInputStream(arquivo);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			
			String linha = buffer.readLine();
			
			while(linha != null){
				String[] vetLinha = linha.split(";");
				if (Integer.parseInt(vetLinha[0]) == disciplina.getCodigoDisciplina()) {
					disciplina.setNomeDisciplina(vetLinha[1]); 
					disciplina.setDiaSemana(vetLinha[2]);
					disciplina.setHorarioAula(vetLinha[3]);
					disciplina.setHorasDiarias(Integer.parseInt(vetLinha[4]));
					disciplina.setCodigoCurso(Integer.parseInt(vetLinha[5]));
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
			
		}
		
		if(disciplina.getNomeDisciplina() != null) {
			taDisciplina.setText("nome: "+disciplina.getNomeDisciplina()+
					" dia da semana: "+disciplina.getDiaSemana());
		}else {
			taDisciplina.setText("Disciplina não encontrada");
		}
		
		//para apagar os campos:
    	tfDisciplinaCodigo.setText("");
    	tfDisciplinaNome.setText("");
    	tfDisciplinaDiaDaSemana.setText("");
    	tfDisciplinaHorarioDaAula.setText("");
    	tfDisciplinaHorasDiarias.setText("");
    	tfDisciplinaCodigoCurso.setText("");
		
    }
    
    // ATUALIZA posição da lista
    private void atualizaDisciplina() throws Exception {
    	
    	Lista<Disciplina> listaArquivoDisciplina = lerArquivoDisciplinaCsv2();
    	
    	if (listaArquivoDisciplina.isEmpty()) {
	        throw new Exception("Não há disciplinas cadastradas para atualizar.");
	    }
    	
    	Disciplina disciplinaAtualizada = new Disciplina();
    	disciplinaAtualizada.setCodigoDisciplina(Integer.parseInt(tfDisciplinaCodigo.getText()));
    	
    	boolean atualizado = false;
	    int tamanho = listaArquivoDisciplina.size();

	    for (int i = 0; i < tamanho; i++) {
	        Disciplina disciplina = listaArquivoDisciplina.get(i);
	        if (disciplina.getCodigoDisciplina() == disciplinaAtualizada.getCodigoDisciplina()) {
	        	disciplina.setCodigoDisciplina(Integer.parseInt(tfDisciplinaCodigo.getText()));
	        	disciplina.setNomeDisciplina(tfDisciplinaNome.getText());
	        	disciplina.setDiaSemana(tfDisciplinaDiaDaSemana.getText());
	        	disciplina.setHorarioAula(tfDisciplinaHorarioDaAula.getText());
	        	disciplina.setHorasDiarias(Integer.parseInt(tfDisciplinaHorasDiarias.getText()));
	        	disciplina.setCodigoCurso(Integer.parseInt(tfDisciplinaCodigoCurso.getText()));
	            atualizado = true;
	            break;
	        }
	    }

	    if (!atualizado) {
	        throw new Exception("Disciplina com código " + disciplinaAtualizada.getCodigoDisciplina() + " não encontrada.");
	    }

	    gravarArquivoDisciplinaCsv2(listaArquivoDisciplina);
	    
	    
	  //para apagar os campos:
    	tfDisciplinaCodigo.setText("");
    	tfDisciplinaNome.setText("");
    	tfDisciplinaDiaDaSemana.setText("");
    	tfDisciplinaHorarioDaAula.setText("");
    	tfDisciplinaHorasDiarias.setText("");
    	tfDisciplinaCodigoCurso.setText("");
    	
    	taDisciplina.setText("Disciplina atualizada");
    	
    }
    
    // REMOVE posição da lista
    private void removeDisciplina() throws Exception {
    	
    	 
    	 Lista<Disciplina> listaArquivoDisciplina = lerArquivoDisciplinaCsv2();

    	    if (listaArquivoDisciplina.isEmpty()) {
    	        throw new Exception("Não há disciplinas cadastradas para remover.");
    	    }
    	    
    	    Disciplina removerDisciplina = new Disciplina();
        	removerDisciplina.setCodigoDisciplina(Integer.parseInt(tfDisciplinaCodigo.getText()));

    	    boolean removido = false;
    	    int tamanho = listaArquivoDisciplina.size();

    	    for (int i = 0; i < tamanho; i++) {
    	        Disciplina disciplina = listaArquivoDisciplina.get(i);
    	        if (disciplina.getCodigoDisciplina() == removerDisciplina.getCodigoDisciplina()) {
    	            listaArquivoDisciplina.remove(i);
    	            removido = true;
    	            break;
    	        }
    	    }

    	    if (!removido) {
    	        throw new Exception("Disciplina com código " + removerDisciplina + " não encontrada.");
    	    }

    	    gravarArquivoDisciplinaCsv2(listaArquivoDisciplina);
    	    
    	  //para apagar os campos:
        	tfDisciplinaCodigo.setText("");
        	tfDisciplinaNome.setText("");
        	tfDisciplinaDiaDaSemana.setText("");
        	tfDisciplinaHorarioDaAula.setText("");
        	tfDisciplinaHorasDiarias.setText("");
        	tfDisciplinaCodigoCurso.setText("");
        	
        	taDisciplina.setText("Disciplina removida");
    }



 
	private void gravarArquivoDisciplinaCsv2(String disciplina) throws IOException {
		
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
		File dir = new File(path);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		File arquivo = new File(path,"disciplinas.csv");
		
		boolean existe = false;
		if(arquivo.exists()) {
			existe = true;
		}
		
		FileWriter fw = new FileWriter(arquivo, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(disciplina+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}
	
	
	private void gravarArquivoDisciplinaCsv2(Lista<Disciplina> lista) throws Exception {
	    String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
	    File dir = new File(path);

	    if (!dir.exists()) {
	        dir.mkdir();
	    }

	    File arquivo = new File(path, "disciplinas.csv");

	    FileWriter fw = new FileWriter(arquivo, false); // false para sobrescrever
	    PrintWriter pw = new PrintWriter(fw);

	    for (int i = 0; i < lista.size(); i++) {
	        Disciplina disciplina = lista.get(i);
	        pw.println(disciplina.toString());
	    }

	    pw.flush();
	    pw.close();
	    fw.close();
	}

	
	//LEITURA EM CSV
	private Lista<Disciplina> lerArquivoDisciplinaCsv2() throws Exception {
	    Lista<Disciplina> lista = new Lista<>();

	    String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
	    File arquivo = new File(path, "disciplinas.csv");

	    if (!arquivo.exists()) {
	        // Se o arquivo não existir, retorna lista vazia
	    	System.out.println("Arquivo não encontrado ou não existe");
	        return lista;
	    }

	    BufferedReader br = new BufferedReader(new FileReader(arquivo));
	    String linha;

	    while ((linha = br.readLine()) != null) {
	        if (!linha.trim().isEmpty()) {
	            String[] campos = linha.split(";");
	            
	            int codigoDisciplina = Integer.parseInt(campos[0]);
	            String nomeDisciplina = campos[1];
	            String diaSemana = campos[2];
	            String horarioAula = campos[3];
	            int horasDiarias = Integer.parseInt(campos[4]);
	            int codigoCurso = Integer.parseInt(campos[5]);

	            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, diaSemana, horarioAula, horasDiarias, codigoCurso);
	            lista.addLast(disciplina);
	        }
	    }

	    br.close();
	    return lista;
	}

}
