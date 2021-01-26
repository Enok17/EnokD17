package br.ufac.si.muralSI.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="cursoControlador")
@SessionScoped
public class CursoControlador { // CRIAR PÁGINAS PARA FINALIZAR

	private CursoGerente cg;
	private Curso curso;
	private String chave = "";
	private int chaveC = 0;
	
	public CursoControlador() {
		cg = new CursoGerente();
		curso = new Curso();
	}

	public String incluir() {
		this.curso = new Curso();
		return "???";
	}

	public String editar(Curso curso) {
		this.curso = curso;
		return "???";
	}

	public String excluir(Curso curso) {
		this.curso = curso;
		return "???";
	}
	
	public String adicionar() {
		cg.adicionar(curso);
		return "???";
	}
	
	public String atualizar() {
		cg.atualizar(curso);
		return "???";
	}
	
	public String remover() {
		cg.remover(curso);
		return "???";
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getGrade() {
		return cg.recuperarTodos();
	}
	
	public List<Curso> getPorNome() {
		return cg.recuperarTodosPorNomeContendo(chave);
	}
	
	public List<Curso> getPorCurso(){
		return cg.recuperarPorCodigo(chaveC);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
}