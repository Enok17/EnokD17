package br.ufac.si.muralSI.testes;

import br.ufac.si.muralSI.entidades.Professor;
import br.ufac.si.muralSI.gerentes.ProfessorGerente;

public class ProfessorTeste {

	public static void main(String[] args) {
		ProfessorGerente pg = new ProfessorGerente();
		Professor p1, p2, p3;
		
		p1 = new Professor("234-P", "Macilon", "Sistemas de Informação", "1234");
		p2 = new Professor("123-P", "Manoel", "Sistemas de Informação", "1234");
		p3 = new Professor("345-P", "Claudionor", "Sistemas de Informação", "1234");
		
		pg.adicionar(p1);
		pg.adicionar(p2);
		pg.adicionar(p3);
		
		pg.encerrar();
		
	}

}
