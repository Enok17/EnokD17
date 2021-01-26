package br.ufac.si.muralSI.entidades;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Turma.todos", 
			query="SELECT t FROM Turma t"),
	@NamedQuery(name="Turma.todosPorNome", 
			query="SELECT t FROM Turma t ORDER BY t.nome"),
	@NamedQuery(name="Turma.todosPorNomeContendo",
			query="SELECT t FROM Turma t WHERE t.nome LIKE :termo ORDER BY t.nome"),
	@NamedQuery(name="Turma.todosPorProfessorContendo",
		query="SELECT t FROM Turma t WHERE t.professor_fk = :termo ORDER BY t.nome"),
	@NamedQuery(name="Turma.todosPorDisciplinaContendo",
		query="SELECT t FROM Turma t WHERE t.disciplina_fk = :termo ORDER BY t.nome")
})

@Table(name="turmas")
public class Turma {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(nullable=false, length=50)
	private String nome;
	@ManyToOne()
	@JoinColumn(name="disciplina_fk", nullable=false)
	private GradeCurricular disciplina;
	@ManyToOne()
	@JoinColumn(name="professor_fk", nullable=false)
	private Professor prof;
	@ManyToMany()
	@JoinTable(name= "aluno_turma" ,
			joinColumns= @JoinColumn(name="turma_fk", nullable=true),
			inverseJoinColumns= @JoinColumn(name="aluno_fk", nullable=true))
	private List<Aluno> alunos;
	
	public Turma(String nome, GradeCurricular disciplina, Professor prof, List<Aluno> alunos) {
		super();
		this.nome = nome;
		this.disciplina = disciplina;
		this.prof = prof;
		this.alunos = alunos;
	}

	public Turma() {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GradeCurricular getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(GradeCurricular disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
