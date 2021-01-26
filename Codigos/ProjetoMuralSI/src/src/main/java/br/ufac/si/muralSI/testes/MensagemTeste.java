package br.ufac.si.muralSI.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

public class MensagemTeste {

	public static void main(String[] args) throws ParseException{
		MensagemGerente mg = new MensagemGerente();
		AlunoGerente ag = new AlunoGerente();
		TurmaGerente tg = new TurmaGerente();
		
		Mensagem m1, m2;
		
		m1 = new Mensagem();
		m1.setTitulo("TESTE1");
		m1.setDescrição("Descrição teste 1");
		m1.setData(new Date());
		m1.setAluno(ag.recuperar(1));
		m1.setTurma(tg.recuperar(1));
		
		m2 = new Mensagem();
		m2.setTitulo("TESTE 2");
		m2.setDescrição("Descrição teste 2");
		m2.setData(new Date());
		m2.setAluno(ag.recuperar(2));
		m2.setTurma(tg.recuperar(1));
		

		mg.adicionar(m1);
		mg.adicionar(m2);
		
		mg.encerrar();
		
	}

}
