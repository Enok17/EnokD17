package br.ufac.si.muralSI.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

	public static void main(String[] args) throws ParseException {
		Date data;
		String str;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		str = sdf.format((new Date()));
		data = sdf.parse(str);
		System.out.println(str);
		System.out.println(data);
	}

}
