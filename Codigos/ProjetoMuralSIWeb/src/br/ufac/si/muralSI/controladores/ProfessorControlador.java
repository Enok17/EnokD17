package br.ufac.si.muralSI.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="professorControlador")
@SessionScoped
public class ProfessorControlador {

	private ProfessorGerente pg;
	private Professor professor;
	private String chave = "";
	private String login = "";
	private String senha = "";
	
	public ProfessorControlador() {
		pg = new ProfessorGerente();
		professor = new Professor();
	}

	public String incluir() {
		this.professor = new Professor();
		return "coorProfessorInclusao";
	}
	
	public String editar(Professor professor) {
		this.professor = professor;
		return "coorProfessorEdicao";
	}

	public String excluir(Professor professor) {
		this.professor = professor;
		return "coorProfessorExclusao";
	}
	
	public String adicionar() {
		pg.adicionar(professor);
		return "professoresGerenciamento";
	}
	
	public String atualizar() {
		pg.atualizar(professor);
		return "professoresGerenciamento";
	}
	
	public String remover() {
		pg.remover(professor);
		return "professoresGerenciamento";
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		return pg.recuperarTodosPorNomeContendo(chave);
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

	public String professorLogin() {
		List<Professor> p = pg.recuperarPorIdentificador(login);
		if(0<p.size()) {
			if(p.get(0).getSenha().equals(senha)) {
				professor = p.get(0);
				return "professorPrincipal";
			}
		}
		professor = null;
		return "null";
	}
	
	public String professorLogout() {
		professor = null;
		return "professorLogin";
	}
}