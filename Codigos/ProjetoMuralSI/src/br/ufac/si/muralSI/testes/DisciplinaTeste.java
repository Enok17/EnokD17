package br.ufac.si.muralSI.testes;

import br.ufac.si.muralSI.entidades.Disciplina;
import br.ufac.si.muralSI.gerentes.DisciplinaGerente;
import br.ufac.si.muralSI.gerentes.ProfessorGerente;

public class DisciplinaTeste {

	public static void main(String[] args) {
		DisciplinaGerente dg = new DisciplinaGerente();
		ProfessorGerente pg = new ProfessorGerente();
		
		Disciplina d1, d2, d3;
		
		d1 = new Disciplina();
		d1.setNome("Tópicos Especiais em SI");
		d1.setProf(pg.recuperar(1));
		
		d2 = new Disciplina();
		d2.setNome("Linguagem de Programação");
		d2.setProf(pg.recuperar(2));
		
		d3 = new Disciplina();
		d3.setNome("Lógica");
		d3.setProf(pg.recuperar(3));
		
		dg.adicionar(d1);
		dg.adicionar(d2);
		dg.adicionar(d3);
		
		dg.encerrar();
		
	}

}
