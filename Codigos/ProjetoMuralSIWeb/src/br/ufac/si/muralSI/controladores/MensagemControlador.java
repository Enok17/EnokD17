package br.ufac.si.muralSI.controladores;

import java.text.ParseException;
import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="mensagemControlador")
@SessionScoped
public class MensagemControlador {

	private MensagemGerente mg;
	private Mensagem mensagem;
	private String chave = "";
	private int chaveT = 0;
	
	public MensagemControlador(){
		mg = new MensagemGerente();
		mensagem = new Mensagem();
	}

	public String incluir(){
		this.mensagem = new Mensagem();
		return "mensagemInclusao";
	}
	
//	public String incluirComoCoordenador(Coordenador c){
//		mensagem = new Mensagem();
//		mensagem.setCoor(c);
//		return "coorNotificacaoInclusao";
//	}
	
	public String incluirComoProfessor(Professor p){
		mensagem = new Mensagem();
		return "profNotificacaoInclusao";
	}
	
	public String editar(Mensagem mensagem) {
		this.mensagem = mensagem;
		return "mensagemEdicao";
	}
	
//	public String editarComoCoordenador(Mensagem mensagem) {
//		this.mensagem = mensagem;
//		return "coorNotificacaoEdicao";
//	}
	
	public String editarComoProfessor(Mensagem mensagem) {
		this.mensagem = mensagem;
		return "profNotificacaoEdicao";
	}

	public String excluir(Mensagem mensagem) {
		this.mensagem = mensagem;
		return "mensagemExclusao";
	}
	
	public String excluirComoCoordenador(Mensagem mensagem) {
		this.mensagem = mensagem;
		return "coorNotificacaoExclusao";
	}
	
	public String excluirComoProfessor(Mensagem mensagem) {
		this.mensagem = mensagem;
		return "profNotificacaoExclusao";
	}
	
	public String adicionar() {
		mg.adicionar(mensagem);
		return "mensagemGerenciamento";
	}
	
//	public String adicionarComoCoordenador() {
//		ng.adicionar(mensagem);
//		return "notificacoesGerenciamento";
//	}
	
	public String adicionarComoProfessor() {
		mg.adicionar(mensagem);
		return "professorPrincipal";
	}
	
	public String atualizar() {
		mg.atualizar(mensagem);
		return "mensagemGerenciamento";
	}
	
//	public String atualizarComoCoordenador(Coordenador c) {
//		mensagem.setCoor(c);
//		mensagem.setProf(null);
//		ng.atualizar(mensagem);
//		return "notificacoesGerenciamento";
//	}
	
	public String atualizarComoProfessor(Professor p) {
		mg.atualizar(mensagem);
		return "professorPrincipal";
	}
	
	public String remover() {
		mg.remover(mensagem);
		return "mensagemGerenciamento";
	}
	
//	public String removerComoCoordenador(Coordenador c) {
//		mensagem.setCoor(c);
//		ng.remover(mensagem);
//		return "notificacoesGerenciamento";
//	}
	
	public String removerComoProfessor(Professor p) {
		mg.remover(mensagem);
		return "professorPrincipal";
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setNotificacao(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public List<Mensagem> getMensagemsPorNomeContendo() {
		return mg.recuperarTodosPorNomeContendo(chave);
	}
	
	public List<Mensagem> getMensagemsPorTurmas(){
		return mg.recuperarTodosPorTurma(chaveT);
	}
	
	public List<Mensagem> getMensagemsPorData(){
		return mg.recuperarTodosPorData();
	}
	
	public List<Mensagem> getPorNomeEPeriodo(){
		if(chaveT == 0) {
			return mg.recuperarTodosPorNomeContendo(chave);
		}
		return mg.recuperarMensagens(chave, chaveT);
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