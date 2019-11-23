package br.ufac.si.muralSI.entidades;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Coordenador.todos",
			query="SELECT c FROM Coordenador c"),
	@NamedQuery(name="Coordenador.todosPorNome",
			query="SELECT c FROM Coordenador c ORDER BY c.nome"),
	@NamedQuery(name="Coordenador.todosPorNomeContendo",
			query="SELECT c FROM Coordenador c WHERE c.nome LIKE :termo ORDER BY c.nome"),
	@NamedQuery(name="Coordenador.todosPorIdentificador",
			query="SELECT c FROM Coordenador c WHERE c.identificador LIKE :termo")
})

@Table(name="coordenadores")
public class Coordenador {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; //Usado para identificar um coordenador em um BD
	
	@Column(nullable=false, length=11, unique=true)
	private String identificador; //Usado para fazer login no coordenador
	@Column(nullable=false, length=50)
	private String nome;
	@Column(nullable=false, length=30)
	private String curso;
	@Column(nullable=false, length=20)
	private String senha;
	
	public Coordenador(String identificador, String nome, String curso, String senha) {
		super();
		this.identificador = identificador;
		this.nome = nome;
		this.curso = curso;
		this.senha = senha;
	}
	
	public Coordenador() {
		
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
	
}
