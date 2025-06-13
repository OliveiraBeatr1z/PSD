package model;

public class Disciplina {
	private String codDisciplina;
	private String nomeDisciplina;
	private String diaSemana;
	private String horarioInicio;
	private String horasDiarias;
	
	@Override
	public String toString() {
		return "Disciplina [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", diaSemana="
				+ diaSemana + ", horarioInicio=" + horarioInicio + ", horasDiarias=" + horasDiarias + "]";
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
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

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorasDiarias() {
		return horasDiarias;
	}

	public void setHorasDiarias(String horasDiarias) {
		this.horasDiarias = horasDiarias;
	}

	
	
}
