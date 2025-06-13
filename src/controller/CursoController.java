package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.Lista.Lista;
import br.edu.fateczl.filaObj.Fila;
import model.Curso;

public class CursoController implements ActionListener {

    private JTextField tfCursoCodigo;
    private JTextField tfCursoNome;
    private JTextField tfCursoAreaConhecimento;
    private JTextArea taCurso;

    public CursoController(JTextField tfCursoCodigo, JTextField tfCursoNome, JTextField tfCursoAreaConhecimento, JTextArea taCurso) {
        this.tfCursoCodigo = tfCursoCodigo;
        this.tfCursoNome = tfCursoNome;
        this.tfCursoAreaConhecimento = tfCursoAreaConhecimento;
        this.taCurso = taCurso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            if (comando.equals("Cadastrar")) {
                cadastraCurso();
            } else if (comando.equals("Buscar")) {
                consultaCurso();
            } else if (comando.equals("Atualizar")) {
                atualizaCurso();
            } else if (comando.equals("Remover")) {
                removeCurso();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cadastraCurso() throws IOException {
        Curso curso = new Curso();
        curso.setCodigoCurso(Integer.parseInt(tfCursoCodigo.getText()));
        curso.setNomeCurso(tfCursoNome.getText());
        curso.setAreaConhecimento(tfCursoAreaConhecimento.getText());

        gravarArquivoCursoCsv(curso.toString());

        limpaCampos();
        taCurso.setText("Curso cadastrado");
    }

    private void consultaCurso() throws Exception {
        int codigoBusca = Integer.parseInt(tfCursoCodigo.getText());

        Fila fila = new Fila();

        String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
        File arquivo = new File(path, "cursos.csv");

        if (arquivo.exists() && arquivo.isFile()) {
            BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
            String linha;

            while ((linha = buffer.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    String[] dados = linha.split(";");
                    Curso c = new Curso();
                    c.setCodigoCurso(Integer.parseInt(dados[0]));
                    c.setNomeCurso(dados[1]);
                    c.setAreaConhecimento(dados[2]);

                    fila.insert(c);
                }
            }
            buffer.close();
        }

        Curso encontrado = null;
        while (!fila.isEmpty()) {
            Curso atual = (Curso) fila.remove();
            if (atual.getCodigoCurso() == codigoBusca) {
                encontrado = atual;
                break;
            }
        }

        if (encontrado != null) {
            taCurso.setText("Nome: " + encontrado.getNomeCurso() +
                    "\nÁrea de conhecimento: " + encontrado.getAreaConhecimento());
        } else {
            taCurso.setText("Curso não encontrado");
        }

        limpaCampos();
    }

    private void atualizaCurso() throws Exception {
        Lista<Curso> lista = lerArquivoCursoCsv();

        if (lista.isEmpty()) {
            throw new Exception("Não há cursos cadastrados para atualizar.");
        }

        int codigoBusca = Integer.parseInt(tfCursoCodigo.getText());
        boolean atualizado = false;

        for (int i = 0; i < lista.size(); i++) {
            Curso curso = lista.get(i);
            if (curso.getCodigoCurso() == codigoBusca) {
                curso.setNomeCurso(tfCursoNome.getText());
                curso.setAreaConhecimento(tfCursoAreaConhecimento.getText());
                atualizado = true;
                break;
            }
        }

        if (!atualizado) {
            throw new Exception("Curso com código " + codigoBusca + " não encontrado.");
        }

        gravarArquivoCursoCsv(lista);

        limpaCampos();
        taCurso.setText("Curso atualizado");
    }

    private void removeCurso() throws Exception {
        Lista<Curso> lista = lerArquivoCursoCsv();

        if (lista.isEmpty()) {
            throw new Exception("Não há cursos cadastrados para remover.");
        }

        int codigoBusca = Integer.parseInt(tfCursoCodigo.getText());
        boolean removido = false;

        for (int i = 0; i < lista.size(); i++) {
            Curso curso = lista.get(i);
            if (curso.getCodigoCurso() == codigoBusca) {
                lista.remove(i);
                removido = true;
                break;
            }
        }

        if (!removido) {
            throw new Exception("Curso com código " + codigoBusca + " não encontrado.");
        }

        gravarArquivoCursoCsv(lista);

        limpaCampos();
        taCurso.setText("Curso removido");
    }

    private void gravarArquivoCursoCsv(String curso) throws IOException {
        String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
        File dir = new File(path);

        if (!dir.exists()) {
            dir.mkdir();
        }

        File arquivo = new File(path, "cursos.csv");

        boolean existe = arquivo.exists();

        FileWriter fw = new FileWriter(arquivo, existe);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(curso + "\r\n");
        pw.flush();
        pw.close();
        fw.close();
    }

    private void gravarArquivoCursoCsv(Lista<Curso> lista) throws Exception {
        String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
        File dir = new File(path);

        if (!dir.exists()) {
            dir.mkdir();
        }

        File arquivo = new File(path, "cursos.csv");

        FileWriter fw = new FileWriter(arquivo, false);
        PrintWriter pw = new PrintWriter(fw);

        for (int i = 0; i < lista.size(); i++) {
            pw.println(lista.get(i).toString());
        }

        pw.flush();
        pw.close();
        fw.close();
    }

    private Lista<Curso> lerArquivoCursoCsv() throws Exception {
        Lista<Curso> lista = new Lista<>();

        String path = System.getProperty("user.home") + File.separator + "SistemaCadastroFaculdade";
        File arquivo = new File(path, "cursos.csv");

        if (!arquivo.exists()) {
            return lista;
        }

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;

        while ((linha = br.readLine()) != null) {
            if (!linha.trim().isEmpty()) {
                String[] campos = linha.split(";");

                int codigoCurso = Integer.parseInt(campos[0]);
                String nomeCurso = campos[1];
                String areaConhecimento = campos[2];

                Curso curso = new Curso(codigoCurso, nomeCurso, areaConhecimento);
                lista.addLast(curso);
            }
        }

        br.close();
        return lista;
    }

    private void limpaCampos() {
        tfCursoCodigo.setText("");
        tfCursoNome.setText("");
        tfCursoAreaConhecimento.setText("");
    }
}
