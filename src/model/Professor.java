package model;

public class Professor {
	
	private String cpf;
	private String nomeProfessor;
	private String areaConhecimentoProfessor;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nomeProfessor;
	}
	public void setNome(String nome) {
		this.nomeProfessor = nome;
	}
	public String getAreaConhecimento() {
		return areaConhecimentoProfessor;
	}
	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimentoProfessor = areaConhecimento;
	}
	
	
	@Override
	public String toString() {
		return cpf + ";" + nomeProfessor + ";" + areaConhecimentoProfessor;
	}
	
	
	
	

}
