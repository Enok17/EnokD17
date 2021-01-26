package br.ufac.si.muralSI.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

public class AvisoTeste {

	public static void main(String[] args) throws ParseException{
		AvisoGerente ng = new AvisoGerente();
		ProfessorGerente pg = new ProfessorGerente();
		TurmaGerente tg = new TurmaGerente();
		
		Aviso n1, n2, n3;
		
		n1 = new Aviso();
		n1.setTitulo("SEM AULA");
		n1.setDescrição("Sem aula de Gerencia de Projetos nesta segunda-feira");
		n1.setData(new Date());
		n1.setTurma(tg.recuperar(1));
		
		n2 = new Aviso();
		n2.setTitulo("REPOSIÇÃO DE AULA");
		n2.setDescrição("Reposição de aula na próxima segunda-feira");
		n2.setData(new Date());
		n2.setTurma(tg.recuperar(1));
		
		n3 = new Aviso();
		n3.setTitulo("REPOSIÇÃO DE AULA");
		n3.setDescrição("Reposição de introdução a informática");
		n3.setData(new Date());
		n3.setTurma(tg.recuperar(1));

		ng.adicionar(n1);
		ng.adicionar(n2);
		ng.adicionar(n3);
		
		ng.encerrar();
		
	}

}
