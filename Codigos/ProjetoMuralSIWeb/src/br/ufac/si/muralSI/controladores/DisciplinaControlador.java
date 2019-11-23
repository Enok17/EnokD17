package br.ufac.si.muralSI.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="disciplinaControlador")
@SessionScoped
public class DisciplinaControlador {

	private DisciplinaGerente dg;
	private ProfessorGerente pg;
	private Disciplina disciplina;
	private String chave = "";
	
	public DisciplinaControlador() {
		dg = new DisciplinaGerente();
		pg = new ProfessorGerente();
		disciplina = new Disciplina();
	}

	public String incluir() {
		this.disciplina = new Disciplina();
		return "coorDisciplinaInclusao";
	}
	
	public String editar(Disciplina disciplina) {
		this.disciplina = disciplina;
		return "coorDisciplinaEdicao";
	}

	public String excluir(Disciplina disciplina) {
		this.disciplina = disciplina;
		return "coorDisciplinaExclusao";
	}
	
	public String adicionar() {
		dg.adicionar(disciplina);
		return "disciplinasGerenciamento";
	}
	
	public String atualizar() {
		dg.atualizar(disciplina);
		return "disciplinasGerenciamento";
	}
	
	public String remover() {
		dg.remover(disciplina);
		return "disciplinasGerenciamento";
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		return dg.recuperarTodosPorNomeContendo(chave);
	}
	
	public List<Professor> getProfessores(){
		return pg.recuperarTodosPorNome();
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}