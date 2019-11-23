package br.ufac.si.muralSI.testes;

import br.ufac.si.muralSI.entidades.Coordenador;
import br.ufac.si.muralSI.gerentes.CoordenadorGerente;

public class CoordenadorTeste {

	public static void main(String[] args) {
		CoordenadorGerente cg = new CoordenadorGerente();
		Coordenador c1, c2;
		
		c1 = new Coordenador("356-C", "Luan","Sistemas de Informação", "1234");
		c2 = new Coordenador("123-C", "Enok", "Sistemas de Informação", "1234");
		
		cg.adicionar(c1);
		cg.adicionar(c2);
		
		cg.encerrar();
		
	}

}
