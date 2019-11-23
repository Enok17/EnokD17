package br.ufac.si.muralSI.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

public class NotificacaoTeste {

	public static void main(String[] args) throws ParseException{
		NotificacaoGerente ng = new NotificacaoGerente();
		ProfessorGerente pg = new ProfessorGerente();
		CoordenadorGerente cg =new CoordenadorGerente();
		
		Notificacao n1, n2, n3;
		
		n1 = new Notificacao();
		n1.setTitulo("SEM AULA");
		n1.setMensagem("Sem aula de Gerencia de Projetos nesta segunda-feira");
		n1.setProf(pg.recuperar(1));
		n1.setData("01/10/2019");
		n1.setPeriodo(6);
		
		n2 = new Notificacao();
		n2.setTitulo("REPOSIÇÃO DE AULA");
		n2.setMensagem("Reposição de aula na próxima segunda-feira");
		n2.setCoor(cg.recuperar(1));
		n2.setData("06/10/2019");
		n2.setPeriodo(6);
		
		n3 = new Notificacao();
		n3.setTitulo("REPOSIÇÃO DE AULA");
		n3.setMensagem("Reposição de introdução a informática");
		n3.setCoor(cg.recuperar(1));
		n3.setData("09/10/2019");
		n3.setPeriodo(1);

		ng.adicionar(n1);
		ng.adicionar(n2);
		ng.adicionar(n3);
		
		ng.encerrar();
		
	}

}
