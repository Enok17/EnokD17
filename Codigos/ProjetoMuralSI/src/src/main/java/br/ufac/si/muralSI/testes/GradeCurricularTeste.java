package br.ufac.si.muralSI.testes;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

public class GradeCurricularTeste {

	public static void main(String[] args) {
		GradeCurricularGerente gcg = new GradeCurricularGerente();
		GradeCurricular g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15,
		g16, g17, g18, g19, g20, g21, g22, g23, g24, g25, g26, g27, g28, g29, g30, g31,
		g32, g33, g34, g35, g36, g37, g38, g39, g40,g41, g42, g43, g44, g45, g46, g47, g48,
		g49, g50, g51, g52, g53, g54, g55, g56;

		g1 = new GradeCurricular("CCET186", "Introdução à Informática", 60, "", 1);
		g2 = new GradeCurricular("CCET095", "Matemática Discreta", 60, "", 1);
		g3 = new GradeCurricular("CCET010", "Lógica para Computação", 60, "", 1);
		g4 = new GradeCurricular("CCJSA133", "Administração", 60, "", 1);
		g5 = new GradeCurricular("CELA465", "Leitura e Produção de Textos Técnicos", 30, "", 1);
		g6 = new GradeCurricular("CCET080", "Álgebra Linear", 60, "", 1);
		g7 = new GradeCurricular("CCET059", "Geometria Analítica", 60, "", 1);
		g8 = new GradeCurricular("CELA088", "Inglês Técnico", 60, "", 1);
		
		g9 = new GradeCurricular("CCET007", "Tópicos de Cálculo I", 60, "CCET059", 2);
		g10 = new GradeCurricular("CCET005", "Algoritmos e Linguagem de Programação", 90, "CCET186", 2);
		g11 = new GradeCurricular("CCJSA134", "Comportamento Organizacional", 30, "CCJSA133", 2);
		g12 = new GradeCurricular("CCET090", "Teoria Geral de Sistemas", 60, "CCJSA133", 2);
		g13 = new GradeCurricular("CCET105", "Introdução à Pesquisa em Sistemas de Informação", 60, "", 2);
		
		
		g14 = new GradeCurricular("CCET114", "Linguagem de Programação I", 60, "CCET005", 3);
		g15 = new GradeCurricular("CCET178", "Arquitetura e Organização de Computador", 90, "CCET186 CCET010", 3);
		g16 = new GradeCurricular("CCJSA136", "Economia e Finanças", 60, "", 3);
		g17 = new GradeCurricular("CCET143", "Fundamentos de Sistemas de Informação", 30, "CCET090", 3);
		g18 = new GradeCurricular("CCJSA143", "Marketing", 30, "", 3);
		g19 = new GradeCurricular("CCET028", "Tópicos de Cálculo II", 60, "CCET007", 3);
		
		g20 = new GradeCurricular("CCJSA138", "Organização, Sistemas e Métodos", 30, "CCJSA134", 4);
		g21 = new GradeCurricular("CCET115", "Linguagem de Programação II", 60, "CCET114", 4);
		g22 = new GradeCurricular("CCET130", "Estrutura de Dados", 60, "CCET005", 4);
		g23 = new GradeCurricular("CCET182", "Sistemas Operacionais", 60, "", 4);
		g24 = new GradeCurricular("CCET192", "Estatística Computacional", 60, "CCET007", 4);
		g25 = new GradeCurricular("CCET202", "Sistemas de Apoio à Decisão", 30, "", 4);
		g26 = new GradeCurricular("CFCH243", "Psicologia Aplicada", 30, "", 4);
		g27 = new GradeCurricular("CCET197", "Informática e Sociedade", 30, "", 4);
		
		g28 = new GradeCurricular("CCET023", "Banco de dados I", 60, "CCET130", 5);
		g29 = new GradeCurricular("CCET020", "Pesquisa Operacional", 60, "CCET080 CCET007", 5);
		g30 = new GradeCurricular("CCET025", "Comunicação e Redes de Computadores", 60, "", 5);
		g31 = new GradeCurricular("CCET035", "Fundamentos da Computação", 60, "", 5);
		g32 = new GradeCurricular("CCJSA129", "Contabilidade e Custos", 30, "", 5);
		g33 = new GradeCurricular("CCET036", "Tópicos Especiais em Sistemas de Informação I", 60, "", 5);
		
		
		g34 = new GradeCurricular("CFCH087", "Sociologia", 30, "", 6);
		g35 = new GradeCurricular("CCET206", "Produção e Operações Logísticas", 60, "", 6);
		g36 = new GradeCurricular("CCET212", "Banco de Dados II", 60, "CCET023", 6);
		g37 = new GradeCurricular("CCET208", "Projetos de Sistemas de Informação", 60, "", 6);
		g38 = new GradeCurricular("CCET213", "Redes de Computadores", 60, "CCET025", 6);
		g39 = new GradeCurricular("CCET209", "Gerência de Projetos", 30, "", 6);
		g40 = new GradeCurricular("CCET204", "Engenharia de Software I", 60, "CCET023", 6);
		g41 = new GradeCurricular("CCET050", "Tópicos Especiais em Sistemas de Informação II", 60, "", 6);
		
		
		g42 = new GradeCurricular("CCET086", "Sistemas Distribuídos", 60, "CCET213", 7);
		g43 = new GradeCurricular("CCET207", "Engenharia Software II", 60, "CCET204", 7);
		g44 = new GradeCurricular("CCET214", "Interface Homem Máquina", 60, "CCET204", 7);
		g45 = new GradeCurricular("CCET106", "Ética e Legislação Aplicada à Informática", 30, "", 7);
		g46 = new GradeCurricular("CCET217", "Planos de Negócios em Informática", 30, "", 7);
		g47 = new GradeCurricular("CCET219", "Introdução a Inteligência Artificial", 60, "CCET010", 7);
		g48 = new GradeCurricular("CCET175", "Estágio Supervisionado", 150, "", 7);
		g49 = new GradeCurricular("CCET177", "TCC I", 30, "", 7);
		
		
		g50 = new GradeCurricular("CCET183", "Gestão da Informação", 60, "", 8);
		g51 = new GradeCurricular("CCET189", "Segurança e Auditoria de Sistemas", 60, "", 8);
		g52 = new GradeCurricular("CCET201", "Sistemas Multimídia", 60, "", 8);
		g53 = new GradeCurricular("CCJSA139", "Empreendedorismo", 30, "", 8);
		g54 = new GradeCurricular("CCET222", "Gerência de Redes", 60, "CCET213", 8);
		g55 = new GradeCurricular("CCET121", "Relatório de Estágio", 30, "CCET175", 8);
		g56 = new GradeCurricular("CCET179", "TCC II", 90, "CCET177", 8);		
		
		gcg.adicionar(g1);
		gcg.adicionar(g2);
		gcg.adicionar(g3);
		gcg.adicionar(g4);
		gcg.adicionar(g5);
		gcg.adicionar(g6);
		gcg.adicionar(g7);
		gcg.adicionar(g8);
		gcg.adicionar(g9);
		gcg.adicionar(g10);
		gcg.adicionar(g11);
		gcg.adicionar(g12);
		gcg.adicionar(g13);
		gcg.adicionar(g14);
		gcg.adicionar(g15);
		gcg.adicionar(g16);
		gcg.adicionar(g17);
		gcg.adicionar(g18);
		gcg.adicionar(g19);
		gcg.adicionar(g20);
		gcg.adicionar(g21);
		gcg.adicionar(g22);
		gcg.adicionar(g23);
		gcg.adicionar(g24);
		gcg.adicionar(g25);
		gcg.adicionar(g26);
		gcg.adicionar(g27);
		gcg.adicionar(g28);
		gcg.adicionar(g29);
		gcg.adicionar(g30);
		gcg.adicionar(g31);
		gcg.adicionar(g32);
		gcg.adicionar(g33);
		gcg.adicionar(g34);
		gcg.adicionar(g35);
		gcg.adicionar(g36);
		gcg.adicionar(g37);
		gcg.adicionar(g38);
		gcg.adicionar(g39);
		gcg.adicionar(g40);
		gcg.adicionar(g41);
		gcg.adicionar(g42);
		gcg.adicionar(g43);
		gcg.adicionar(g44);
		gcg.adicionar(g45);
		gcg.adicionar(g46);
		gcg.adicionar(g47);
		gcg.adicionar(g48);
		gcg.adicionar(g49);
		gcg.adicionar(g50);
		gcg.adicionar(g51);
		gcg.adicionar(g52);
		gcg.adicionar(g53);
		gcg.adicionar(g54);
		gcg.adicionar(g55);
		gcg.adicionar(g56);

		gcg.encerrar();

	}

}