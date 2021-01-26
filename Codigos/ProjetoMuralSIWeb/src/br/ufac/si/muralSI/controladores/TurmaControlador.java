package br.ufac.si.muralSI.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="turmaControlador")
@SessionScoped
public class TurmaControlador {

	private TurmaGerente tg;
	private ProfessorGerente pg;
	private Turma turma;
	private String chave = "";
	private long chaveP = 0;
	private String chaveD = "";
	
	public TurmaControlador() {
		tg = new TurmaGerente();
		turma = new Turma();
		pg = new ProfessorGerente();
	}

	public String incluir() {
		this.turma = new Turma();
		return "coorDisciplinaInclusao";
	}
	
	public String editar(Turma turma) {
		this.turma = turma;
		return "coorDisciplinaEdicao";
	}

	public String excluir(Turma turma) {
		this.turma = turma;
		return "coorDisciplinaExclusao";
	}
	
	public String adicionar() {
		tg.adicionar(turma);
		return "turmasGerenciamento";
	}
	
	public String atualizar() {
		tg.atualizar(turma);
		return "turmasGerenciamento";
	}
	
	public String remover() {
		tg.remover(turma);
		return "turmasGerenciamento";
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return tg.recuperarTodosPorNomeContendo(chave);
	}
	
	public List<Turma> getTurmaPorProfessores() {
		return tg.recuperarTodosPorProfessorContendo(chaveP);
	}
	
	public List<Turma> getTurmaPorDisciplinas() {
		return tg.recuperarTodosPorDisciplinaContendo(chaveD);
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

	public long getChaveP() {
		return chaveP;
	}

	public void setChaveP(long chaveP) {
		this.chaveP = chaveP;
	}

	public String getChaveD() {
		return chaveD;
	}

	public void setChaveD(String chaveD) {
		this.chaveD = chaveD;
	}

}