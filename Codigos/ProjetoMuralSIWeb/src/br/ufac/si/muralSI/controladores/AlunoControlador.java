package br.ufac.si.muralSI.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="alunoControlador")
@SessionScoped
public class AlunoControlador {

	private AlunoGerente ag;
	private Aluno aluno;
	private String chave = "";
	public String login = "";
	public String senha = "";
	
	public AlunoControlador() {
		ag = new AlunoGerente();
		aluno = new Aluno();
	}

	public String incluir() {
		this.aluno = new Aluno();
		return "alunoInclusao";
	}
	
	public String incluirComoCoordenador() {
		this.aluno = new Aluno();
		return "coorAlunoInclusao";
	}
	
	public String editar(Aluno aluno) {
		this.aluno = aluno;
		return "alunoEdicao";
	}
	
	public String editarComoCoordenador(Aluno aluno) {
		this.aluno = aluno;
		return "coorAlunoEdicao";
	}

	public String excluir(Aluno aluno) {
		this.aluno = aluno;
		return "alunoExclusao";
	}
	
	public String excluirComoCoordenador(Aluno aluno) {
		this.aluno = aluno;
		return "coorAlunoExclusao";
	}
	public String adicionar() {
		ag.adicionar(aluno);
		return "alunoLogin";
	}
	
	public String adicionarComoCoordenador() {
		ag.adicionar(aluno);
		return "alunosGerenciamento";
	}
	
	public String atualizar() {
		ag.atualizar(aluno);
		return "alunoLogin";
	}
	
	public String atualizarComoCoordenador() {
		ag.atualizar(aluno);
		return "alunosGerenciamento";
	}
	
	public String remover() {
		ag.remover(aluno);
		return "alunoLogin";
	}
	
	public String removerComoCoordenador() {
		ag.remover(aluno);
		return "alunosGerenciamento";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return ag.recuperarTodosPorNomeContendo(chave);
	}
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String alunoLogin() {
		List<Aluno> a = ag.recuperarPorMatricula(login);
		if(0<a.size()) {
			if(a.get(0).getSenha().equals(senha)) {
				aluno = a.get(0);
				return "alunoPrincipal";
			}
		}
		aluno = null;
		return "null";
	}
	
	public String alunoLogout() {
		aluno = null;
		return "alunoLogin";
	}
	
}