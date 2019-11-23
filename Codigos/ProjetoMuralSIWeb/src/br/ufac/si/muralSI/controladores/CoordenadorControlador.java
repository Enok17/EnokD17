package br.ufac.si.muralSI.controladores;

import java.util.*;
import javax.faces.bean.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@ManagedBean(name="coordenadorControlador")
@SessionScoped
public class CoordenadorControlador {

	private CoordenadorGerente cg;
	private Coordenador coordenador;
	private String chave = "";
	private String login = "";
	private String senha = "";
	
	public CoordenadorControlador() {
		cg = new CoordenadorGerente();
		coordenador = new Coordenador();
	}

	public String incluir() {
		this.coordenador = new Coordenador();
		return "coordenadorInclusao";
	}
	
	public String editar(Coordenador coordenador) {
		this.coordenador = coordenador;
		return "coordenadorEdicao";
	}

	public String excluir(Coordenador coordenador) {
		this.coordenador = coordenador;
		return "coordenadorxclusao";
	}
	
	public String adicionar() {
		cg.adicionar(coordenador);
		return "coordenadorGerenciamento";
	}
	
	public String atualizar() {
		cg.atualizar(coordenador);
		return "coordenadorGerenciamento";
	}
	
	public String remover() {
		cg.remover(coordenador);
		return "coordenadorGerenciamento";
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public List<Coordenador> getCoordenadores() {
		return cg.recuperarTodosPorNomeContendo(chave);
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

	public String coordenadorLogin() {
		List<Coordenador> c = cg.recuperarPorIdentificador(login);
		if(0<c.size()) {
			if(c.get(0).getSenha().equals(senha)) {
				coordenador = c.get(0);
				return "coordenadorPrincipal";
			}
		}
		coordenador = null;
		return "null";
	}
	
	public String coordenadorLogout() {
		coordenador = null;
		return "coordenadorLogin";
	}
	
}