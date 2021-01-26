package br.ufac.si.muralSI.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="gradeCurricularControlador")
@SessionScoped
public class GradeCurricularControlador {

	private GradeCurricularGerente gcg;
	private GradeCurricular gradeCurricular;
	private String chave = "";
	private int chaveP = 1;
	private long chaveC = 0;
	
	public GradeCurricularControlador() {
		gcg = new GradeCurricularGerente();
		gradeCurricular = new GradeCurricular();
	}

	public String incluir() {
		this.gradeCurricular = new GradeCurricular();
		return "coorGradeInclusao";
	}

	public String editar(GradeCurricular gradeCurricular) {
		this.gradeCurricular = gradeCurricular;
		return "coorGradeEdicao";
	}

	public String excluir(GradeCurricular gradeCurricular) {
		this.gradeCurricular = gradeCurricular;
		return "coorGradeExclusao";
	}
	
	public String adicionar() {
		gcg.adicionar(gradeCurricular);
		return "gradeGerenciamento";
	}
	
	public String atualizar() {
		gcg.atualizar(gradeCurricular);
		return "gradeGerenciamento";
	}
	
	public String remover() {
		gcg.remover(gradeCurricular);
		return "gradeGerenciamento";
	}

	public GradeCurricular getGradeCurricular() {
		return gradeCurricular;
	}

	public void setGradeCurricular(GradeCurricular gradeCurricular) {
		this.gradeCurricular = gradeCurricular;
	}

	public List<GradeCurricular> getGrade() {
		return gcg.recuperarTodosPorNomeContendo(chave, chaveP);
	}
	
	public List<GradeCurricular> getPorCurso(){
		return gcg.recuperarPorCurso(chaveC);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public int getChaveP() {
		return chaveP;
	}

	public void setChaveP(int chaveP) {
		this.chaveP = chaveP;
	}

	public long getChaveC() {
		return chaveC;
	}

	public void setChaveC(long chaveC) {
		this.chaveC = chaveC;
	}
	
}