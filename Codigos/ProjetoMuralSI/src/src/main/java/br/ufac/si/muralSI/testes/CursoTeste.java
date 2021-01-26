package br.ufac.si.muralSI.testes;

import br.ufac.si.muralSI.entidades.Curso;
import br.ufac.si.muralSI.gerentes.CursoGerente;

public class CursoTeste {

	public static void main(String[] args) {
		CursoGerente cg = new CursoGerente();
		Curso c1;
		
		c1 = new Curso("030", "Sistemas de Informação");
		
		cg.adicionar(c1);
		
		cg.encerrar();
		
	}

}
