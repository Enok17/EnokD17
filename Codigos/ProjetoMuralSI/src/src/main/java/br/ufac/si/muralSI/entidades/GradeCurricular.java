package br.ufac.si.muralSI.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="GradeCurricular.todos",
			query="SELECT gc FROM GradeCurricular gc"),
	@NamedQuery(name="GradeCurricular.todosPorNome",
			query="SELECT gc FROM GradeCurricular gc ORDER BY gc.nome"),
	@NamedQuery(name="GradeCurricular.todosPorNomeContendo",
			query="SELECT gc FROM GradeCurricular gc WHERE gc.nome LIKE :termo1 AND gc.periodo=:termo2"),
	@NamedQuery(name="GradeCurricular.todosPorCurso",
			query="SELECT gc FROM GradeCurricular gc WHERE gc.curso_fk = :termo")
})

@Table(name="gradeCurricular")
public class GradeCurricular {
	@Id
	private String codigo;
	
	@Column(nullable=false, length=50)
	private String nome;
	@ManyToOne()
	@JoinColumn(name="curso_fk", nullable=false)
	private Curso curso;
	@Column(nullable=false)
	private int cargaHoraria;
	@Column(nullable=true, length=24)
	private String preRequisito;
	@Column(nullable=false)
	private int periodo;
	
	public GradeCurricular(String codigo, String nome, Curso curso, int cargaHoraria, String preRequisito,
			int periodo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.curso = curso;
		this.cargaHoraria = cargaHoraria;
		this.preRequisito = preRequisito;
		this.periodo = periodo;
	}
	
	public GradeCurricular(String codigo, String nome, int cargaHoraria, String preRequisito, int periodo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.preRequisito = preRequisito;
		this.periodo = periodo;
	}

	public GradeCurricular() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getPreRequisito() {
		return preRequisito;
	}

	public void setPreRequisito(String preRequisito) {
		this.preRequisito = preRequisito;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

}
