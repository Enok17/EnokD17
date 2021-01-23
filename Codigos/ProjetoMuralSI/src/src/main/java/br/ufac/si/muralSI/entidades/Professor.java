package br.ufac.si.muralSI.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Professor.todos",
			query="SELECT p FROM Professor p"),
	@NamedQuery(name="Professor.todosPorNome",
			query="SELECT p FROM Professor p ORDER BY p.nome"),
	@NamedQuery(name="Professor.todosPorNomeContendo",
			query="SELECT p FROM Professor p WHERE p.nome LIKE :termo ORDER BY p.nome"),
	@NamedQuery(name="Professor.todosPorIdentificador",
			query="SELECT p FROM Professor p WHERE p.identificador = :termo")
})

@Table(name="professores")
public class Professor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; //Usado para identifcar um professor em um BD
	
	@Column(nullable=false, length=11, unique=true)
	private String identificador; //usado para fazer login no professor
	@Column(nullable=false, length=50)
	private String nome;
	@Column(nullable=true, length=30)
	private String curso;
	@Column(nullable=false, length=20)
	private String senha;
	
	public Professor(String identificador, String nome, String curso, String senha) {
		super();
		this.identificador = identificador;
		this.nome = nome;
		this.curso = curso;
		this.senha = senha;
	}
	
	public Professor() {
		
	}

	public long getId() {
		return id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Professor))
			return false;
		Professor other = (Professor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
