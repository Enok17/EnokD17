package br.ufac.si.muralSI.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Aluno.todos",
			query="SELECT a FROM Aluno a"),
	@NamedQuery(name="Aluno.todosPorNome",
			query="SELECT a FROM Aluno a ORDER BY a.nome"),
	@NamedQuery(name="Aluno.todosPorNomeContendo",
			query="SELECT a FROM Aluno a WHERE a.nome LIKE :termo ORDER BY a.nome"),
	@NamedQuery(name="Aluno.porMatricula",
			query="SELECT a FROM Aluno a WHERE a.matricula = :termo")
})

@Table(name="alunos")
public class Aluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; //Usado para identificar um aluno em um BD
	
	@Column(nullable=false, length=11, unique=true)
	private String matricula; //Usado para fazer login no aluno
	@Column(nullable=false, length=50)
	private String nome;
	@Column(nullable=false)
	private int periodo;
	@Column(nullable=false, length=20)
	private String senha;
	
	public Aluno(String matricula, String nome, int periodo, String senha) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.periodo = periodo;
		this.senha = senha;
	}
	
	public Aluno() {
		
	}

	public long getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
