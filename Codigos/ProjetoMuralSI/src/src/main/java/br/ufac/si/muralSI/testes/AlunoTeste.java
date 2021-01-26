package br.ufac.si.muralSI.testes;

import java.util.ArrayList;
import java.util.List;

import br.ufac.si.muralSI.entidades.Aluno;
import br.ufac.si.muralSI.entidades.Turma;
import br.ufac.si.muralSI.gerentes.AlunoGerente;
import br.ufac.si.muralSI.gerentes.CursoGerente;

public class AlunoTeste {

	public static void main(String[] args) {
		AlunoGerente ag = new AlunoGerente();
		CursoGerente cg = new CursoGerente();
		
		Turma turma1 = new Turma();
		turma1.setId(5);
		
		List<Turma> turmas = new ArrayList<Turma>();
		turmas.add(turma1);
		
		Aluno a1, a2, a3;
		
		a1 = new Aluno();
		a1.setMatricula("100");
		a1.setNome("Enok D");
		a1.setCurso(cg.recuperar(1));
		a1.setSenha("1234");
		
		a2 = new Aluno();
		a2.setMatricula("20170300003");
		a2.setNome("Enok");
		a2.setCurso(cg.recuperar(1));
		a2.setSenha("1234");
		
		a3 = new Aluno();
		a3.setMatricula("2017030003");
		a3.setNome("Enok D");
		a3.setCurso(cg.recuperar(1));
		a3.setSenha("1234");
//		a3.setTurmas(turmas);
		
//		ag.adicionar(a1);
//		ag.adicionar(a2);
		ag.atualizar(a3);
		
		ag.encerrar();
		
	}

}
