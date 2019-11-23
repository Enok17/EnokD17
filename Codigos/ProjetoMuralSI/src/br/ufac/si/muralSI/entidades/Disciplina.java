package br.ufac.si.muralSI.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Disciplina.todos", 
			query="SELECT d FROM Disciplina d"),
	@NamedQuery(name="Disciplina.todosPorNome", 
			query="SELECT d FROM Disciplina d ORDER BY d.nome"),
	@NamedQuery(name="Disciplina.todosPorNomeContendo", 
			query="SELECT d FROM Disciplina d WHERE d.nome LIKE :termo ORDER BY d.nome")

})

@Table(name="disciplinas")
public class Disciplina {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(nullable=false, length=40)
	private String nome;
	@ManyToOne()
	@JoinColumn(name="professor_fk", nullable=false)
	private Professor prof;

	public Disciplina(long id, String nome, Professor prof) {
		super();
		this.id = id;
		this.nome = nome;
		this.prof = prof;
	}

	public Disciplina() {
		this.prof = new Professor();
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

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

}
