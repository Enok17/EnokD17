package br.ufac.si.muralSI.controladores;

import java.text.ParseException;
import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="notificacaoControlador")
@SessionScoped
public class NotificacaoControlador {

	private NotificacaoGerente ng;
	private Notificacao notificacao;
	private String chave = "";
	private int chaveP = 0;
	
	public NotificacaoControlador(){
		ng = new NotificacaoGerente();
		notificacao = new Notificacao();
	}

	public String incluir(){
		this.notificacao = new Notificacao();
		return "notificacaoInclusao";
	}
	
	public String incluirComoCoordenador(Coordenador c){
		notificacao = new Notificacao();
		notificacao.setCoor(c);
		return "coorNotificacaoInclusao";
	}
	
	public String incluirComoProfessor(Professor p){
		notificacao = new Notificacao();
		notificacao.setProf(p);
		return "profNotificacaoInclusao";
	}
	
	public String editar(Notificacao notificacao) {
		this.notificacao = notificacao;
		return "notificacaoEdicao";
	}
	
	public String editarComoCoordenador(Notificacao notificacao) {
		this.notificacao = notificacao;
		return "coorNotificacaoEdicao";
	}
	
	public String editarComoProfessor(Notificacao notificacao) {
		this.notificacao = notificacao;
		return "profNotificacaoEdicao";
	}

	public String excluir(Notificacao notificacao) {
		this.notificacao = notificacao;
		return "notificacaoExclusao";
	}
	
	public String excluirComoCoordenador(Notificacao notificacao) {
		this.notificacao = notificacao;
		return "coorNotificacaoExclusao";
	}
	
	public String excluirComoProfessor(Notificacao notificacao) {
		this.notificacao = notificacao;
		return "profNotificacaoExclusao";
	}
	
	public String adicionar() {
		ng.adicionar(notificacao);
		return "notificacaoGerenciamento";
	}
	
	public String adicionarComoCoordenador() {
		ng.adicionar(notificacao);
		return "notificacoesGerenciamento";
	}
	
	public String adicionarComoProfessor() {
		ng.adicionar(notificacao);
		return "professorPrincipal";
	}
	
	public String atualizar() {
		ng.atualizar(notificacao);
		return "notificacaoGerenciamento";
	}
	
	public String atualizarComoCoordenador(Coordenador c) {
		notificacao.setCoor(c);
		notificacao.setProf(null);
		ng.atualizar(notificacao);
		return "notificacoesGerenciamento";
	}
	
	public String atualizarComoProfessor(Professor p) {
		notificacao.setCoor(null);
		notificacao.setProf(p);
		ng.atualizar(notificacao);
		return "professorPrincipal";
	}
	
	public String remover() {
		ng.remover(notificacao);
		return "notificacaoGerenciamento";
	}
	
	public String removerComoCoordenador(Coordenador c) {
		notificacao.setCoor(c);
		ng.remover(notificacao);
		return "notificacoesGerenciamento";
	}
	
	public String removerComoProfessor(Professor p) {
		notificacao.setProf(p);
		ng.remover(notificacao);
		return "professorPrincipal";
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public List<Notificacao> getNotificacoes() {
		return ng.recuperarTodosPorNomeContendo(chave);
	}
	
	public List<Notificacao> getPeriodos(){
		return ng.recuperarTodosPorPeriodo(chaveP);
	}
	
	public List<Notificacao> getNomeEPeriodo(){
		if(chaveP == 0) {
			return ng.recuperarTodosPorNomeContendo(chave);
		}
		return ng.recuperarNotificacoes(chave, chaveP);
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
	
}