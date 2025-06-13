package model;


public class Disciplina {

	private int codigoDisciplina;
	private String nomeDisciplina;
	private String diaSemana;
	private String horarioAula;
	private int horasDiarias;

	//agora imagino que seja a associação com a classse curso
	private int codigoCurso;
	
	public Disciplina() {
		
	}

	public Disciplina(int codigoDisciplina, String nomeDisciplina, String diaSemana, String horarioAula,
			int horasDiarias, int codigoCurso) {
		super();
		this.codigoDisciplina = codigoDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.diaSemana = diaSemana;
		this.horarioAula = horarioAula;
		this.horasDiarias = horasDiarias;
		this.codigoCurso = codigoCurso;
	}

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorarioAula() {
		return horarioAula;
	}

	public void setHorarioAula(String horarioAula) {
		this.horarioAula = horarioAula;
	}

	public int getHorasDiarias() {
		return horasDiarias;
	}

	public void setHorasDiarias(int horasDiarias) {
		this.horasDiarias = horasDiarias;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	@Override
	public String toString() {
		return codigoDisciplina + ";" + nomeDisciplina
				+ ";" + diaSemana + ";" + horarioAula + ";" + horasDiarias
				+ ";" + codigoCurso;
	}
	
	
}
