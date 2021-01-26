package br.ufac.si.muralSI.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;
@Entity
@NamedQueries({
	@NamedQuery(name="Aviso.todos", 
		query="SELECT a FROM Aviso a"),
	@NamedQuery(name="Aviso.todosPorNome", 
		query="SELECT a FROM Aviso a ORDER BY a.titulo"),
	@NamedQuery(name="Aviso.todosPorData",
		query="SELECT a FROM Aviso a ORDER BY a.data"),
	@NamedQuery(name="Aviso.todosPorNomeContendo", 
		query="SELECT a FROM Aviso a WHERE a.titulo LIKE :termo ORDER BY a.titulo"),
	@NamedQuery(name="Aviso.todosPorTurma",
		query="SELECT a FROM Aviso a WHERE a.turma=:termo"),
	@NamedQuery(name="Aviso.todosPorNomeETurma",
		query="SELECT a FROM Aviso a WHERE a.titulo LIKE :termo1 AND a.turma=:termo2")
})

@Table(name="avisos")
public class Aviso {
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
	@JoinColumn(name="turma_fk", nullable=false)
	private Turma turma;
	
	public Aviso(String titulo, String descrição, Date data, Turma turma) {
		super();
		this.titulo = titulo;
		this.descrição = descrição;
		this.data = data;
		this.turma = turma;
	}

	public Aviso(){
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}