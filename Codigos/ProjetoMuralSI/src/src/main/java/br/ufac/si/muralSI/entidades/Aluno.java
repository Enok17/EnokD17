package br.ufac.si.muralSI.entidades;

import java.util.List;

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
	@ManyToOne()
	@JoinColumn(name="curso_fk", nullable=false)
	private Curso curso;
	@Column(nullable=false, length=20)
	private String senha;
	@ManyToMany(mappedBy= "alunos")
	@Column(name="turma_fk", nullable=true)
	private List<Turma> turmas;
	
	
	
	public Aluno(String matricula, String nome, Curso curso, String senha, List<Turma> turmas) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.senha = senha;
		this.turmas = turmas;
	}
	
	public Aluno() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
}
