package br.ufac.si.muralSI.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Curso.todos",
			query="SELECT c FROM Curso c"),
	@NamedQuery(name="Curso.todosPorNome",
			query="SELECT c FROM Curso c ORDER BY c.nome"),
	@NamedQuery(name="Curso.todosPorNomeContendo",
			query="SELECT c FROM Curso c WHERE c.nome LIKE :termo ORDER BY c.nome"),
	@NamedQuery(name="Curso.porCodigo",
			query="SELECT c FROM Curso c WHERE c.codigo = :termo")
})

@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; //Usado para identificar um aluno em um BD
	
	@Column(nullable=false, length=4, unique=true)
	private String codigo;
	@Column(nullable=false, length=50)
	private String nome;
	
	
	public Curso(String codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Curso() {
		
	}

	public long getId() {
		return id;
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
	
}