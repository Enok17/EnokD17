package br.ufac.si.muralSI.controladores;

import java.text.ParseException;
import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="avisoControlador")
@SessionScoped
public class AvisoControlador {

	private AvisoGerente ag;
	private Aviso aviso;
	private String chave = "";
	private int chaveT = 0;
	
	public AvisoControlador(){
		ag = new AvisoGerente();
		aviso = new Aviso();
	}

	public String incluir(){
		this.aviso = new Aviso();
		return "avisoInclusao";
	}
	
//	public String incluirComoCoordenador(Coordenador c){
//		aviso = new Aviso();
//		aviso.setCoor(c);
//		return "coorNotificacaoInclusao";
//	}
	
	public String incluirComoProfessor(Professor p){
		aviso = new Aviso();
		return "profNotificacaoInclusao";
	}
	
	public String editar(Aviso aviso) {
		this.aviso = aviso;
		return "avisoEdicao";
	}
	
//	public String editarComoCoordenador(Aviso aviso) {
//		this.aviso = aviso;
//		return "coorNotificacaoEdicao";
//	}
	
	public String editarComoProfessor(Aviso aviso) {
		this.aviso = aviso;
		return "profNotificacaoEdicao";
	}

	public String excluir(Aviso aviso) {
		this.aviso = aviso;
		return "avisoExclusao";
	}
	
	public String excluirComoCoordenador(Aviso aviso) {
		this.aviso = aviso;
		return "coorNotificacaoExclusao";
	}
	
	public String excluirComoProfessor(Aviso aviso) {
		this.aviso = aviso;
		return "profNotificacaoExclusao";
	}
	
	public String adicionar() {
		ag.adicionar(aviso);
		return "avisoGerenciamento";
	}
	
//	public String adicionarComoCoordenador() {
//		ng.adicionar(aviso);
//		return "notificacoesGerenciamento";
//	}
	
	public String adicionarComoProfessor() {
		ag.adicionar(aviso);
		return "professorPrincipal";
	}
	
	public String atualizar() {
		ag.atualizar(aviso);
		return "avisoGerenciamento";
	}
	
//	public String atualizarComoCoordenador(Coordenador c) {
//		aviso.setCoor(c);
//		aviso.setProf(null);
//		ng.atualizar(aviso);
//		return "notificacoesGerenciamento";
//	}
	
	public String atualizarComoProfessor(Professor p) {
		ag.atualizar(aviso);
		return "professorPrincipal";
	}
	
	public String remover() {
		ag.remover(aviso);
		return "avisoGerenciamento";
	}
	
//	public String removerComoCoordenador(Coordenador c) {
//		aviso.setCoor(c);
//		ng.remover(aviso);
//		return "notificacoesGerenciamento";
//	}
	
	public String removerComoProfessor(Professor p) {
		ag.remover(aviso);
		return "professorPrincipal";
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setNotificacao(Aviso aviso) {
		this.aviso = aviso;
	}

	public List<Aviso> getAvisosPorNomeContendo() {
		return ag.recuperarTodosPorNomeContendo(chave);
	}
	
	public List<Aviso> getAvisosPorTurmas(){
		return ag.recuperarTodosPorTurma(chaveT);
	}
	
	public List<Aviso> getAvisosPorData(){
		return ag.recuperarTodosPorData();
	}
	
	public List<Aviso> getPorNomeEPeriodo(){
		if(chaveT == 0) {
			return ag.recuperarTodosPorNomeContendo(chave);
		}
		return ag.recuperarAvisos(chave, chaveT);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public int getChaveP() {
		return chaveT;
	}

	public void setChaveP(int chaveT) {
		this.chaveT = chaveT;
	}
	
}