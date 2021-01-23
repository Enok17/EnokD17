package br.ufac.si.muralSI.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;
@Entity
@NamedQueries({
	@NamedQuery(name="Notificacao.todos", 
		query="SELECT n FROM Notificacao n"),
	@NamedQuery(name="Notificacao.todosPorNome", 
		query="SELECT n FROM Notificacao n ORDER BY n.titulo"),
	@NamedQuery(name="Notificacao.todosPorNomeContendo", 
		query="SELECT n FROM Notificacao n WHERE n.titulo LIKE :termo ORDER BY n.titulo"),
	@NamedQuery(name="Notificacao.todosPorPeriodo",
		query="SELECT n FROM Notificacao n WHERE n.periodo=:termo"),
	@NamedQuery(name="Notificacao.todosPorNomeEPeriodo",
		query="SELECT n FROM Notificacao n WHERE n.titulo LIKE :termo1 AND n.periodo=:termo2")
})

@Table(name="notificacoes")
public class Notificacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, length=30)
	private String titulo;
	@Column(nullable=false, length=350)
	private String mensagem;
	@ManyToOne()
	@JoinColumn(name="professor_fk", nullable=true)
	private Professor prof;
	@ManyToOne()
	@JoinColumn(name="coordenador_fk", nullable=true)
	private Coordenador coor;
	@Column(nullable=true, length=20)
	private String data;
	@Column(nullable=false)
	private int periodo;
	
	
	public Notificacao(String titulo, String mensagem, Professor prof, String data, int periodo){
		super();
		
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.prof = prof;
		this.data = data;
		this.periodo = periodo;
	}

	public Notificacao(String titulo, String mensagem,Coordenador coor, String data, int periodo) {
		super();
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.coor = coor;
		this.data = data;
		this.periodo = periodo;
	}

	public Notificacao(){
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public Coordenador getCoor() {
		return coor;
	}

	public void setCoor(Coordenador coor) {
		this.coor = coor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

}