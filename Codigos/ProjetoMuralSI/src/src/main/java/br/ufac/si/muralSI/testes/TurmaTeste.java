package br.ufac.si.muralSI.testes;

import java.util.ArrayList;
import java.util.List;

import br.ufac.si.muralSI.entidades.Aluno;
import br.ufac.si.muralSI.entidades.Turma;
import br.ufac.si.muralSI.gerentes.*;

public class TurmaTeste {

	public static void main(String[] args) {
		TurmaGerente tg = new TurmaGerente();
		GradeCurricularGerente gcg = new GradeCurricularGerente();
		CursoGerente cg = new CursoGerente();
		ProfessorGerente pg = new ProfessorGerente();
		
		Aluno aluno1 = new Aluno();
		aluno1.setId(1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setId(2);
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(aluno1);
		alunos.add(aluno2);
		
		Turma t1;
		
		t1 = new Turma();
		t1.setId(5);
		t1.setNome("LP I");
		t1.setDisciplina(gcg.recuperar("CCET114"));
		t1.setProf(pg.recuperar(2));
		t1.setAlunos(alunos);
		
		tg.atualizar(t1);

		tg.encerrar();
		
	}

}
