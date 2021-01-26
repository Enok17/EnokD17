package br.ufac.si.muralSI.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;
@Entity
@NamedQueries({
	@NamedQuery(name="Mensagem.todos", 
		query="SELECT m FROM Mensagem m"),
	@NamedQuery(name="Mensagem.todosPorNome", 
		query="SELECT m FROM Mensagem m ORDER BY m.titulo"),
	@NamedQuery(name="Mensagem.todosPorData",
		query="SELECT m FROM Aviso m ORDER BY m.data"),
	@NamedQuery(name="Mensagem.todosPorNomeContendo", 
		query="SELECT m FROM Mensagem m WHERE m.titulo LIKE :termo ORDER BY m.titulo"),
	@NamedQuery(name="Mensagem.todosPorturma",
		query="SELECT m FROM Mensagem m WHERE m.turma=:termo"),
	@NamedQuery(name="Mensagem.todosPorNomeETurma",
		query="SELECT m FROM Mensagem m WHERE m.titulo LIKE :termo1 AND m.turma=:termo2")
})

@Table(name="mensagems")
public class Mensagem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, length=30)
	private String titulo;
	@Column(nullable=false, length=350)
	private String descrição;
	@Column(nullable=true)
	private Date data;
	@ManyToOne()
	@JoinColumn(name="aluno_fk", nullable=false)
	private Aluno aluno;
	@ManyToOne()
	@JoinColumn(name="turma_fk", nullable=false)
	private Turma turma;
	
	public Mensagem(String titulo, String descrição, Date data, Aluno aluno, Turma turma) {
		super();
		this.titulo = titulo;
		this.descrição = descrição;
		this.data = data;
		this.aluno = aluno;
		this.turma = turma;
	}

	public Mensagem(){
	}

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
		
}