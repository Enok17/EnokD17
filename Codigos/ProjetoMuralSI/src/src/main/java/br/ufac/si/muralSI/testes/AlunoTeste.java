package br.ufac.si.muralSI.testes;

import br.ufac.si.muralSI.entidades.Aluno;
import br.ufac.si.muralSI.gerentes.AlunoGerente;

public class AlunoTeste {

	public static void main(String[] args) {
		AlunoGerente ag = new AlunoGerente();
		Aluno a1;
		
		a1 = new Aluno("40", "Enok D", 6, "1234");
		
		ag.adicionar(a1);
		
		ag.encerrar();
		
	}

}
