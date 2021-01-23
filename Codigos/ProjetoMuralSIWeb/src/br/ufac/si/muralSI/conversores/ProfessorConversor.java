package br.ufac.si.muralSI.conversores;

import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@FacesConverter(value="professorConversor", forClass=Professor.class)
public class ProfessorConversor implements Converter {

	ProfessorGerente pg = new ProfessorGerente();
	
	public Object getAsObject(FacesContext context, 
			UIComponent component, String value) {
		if(value == null || value.isEmpty())
			return null;
		return pg.recuperar(Long.valueOf(value));
	}

	public String getAsString(FacesContext context, 
			UIComponent component, Object value) {
		if(value == null || !(value instanceof Professor))
			return "";		// AQUI ESTAVA O GARGALO!
//			return null; 	// ANTES RETORNÃ�VAMOS null,
//							// ISSO ESTAVA GERANDO O PROBLEMA! 
//							// NA PROXIMA AULA, PERGUNTEM O PORQUÃŠ?
		return String.valueOf(((Professor)value).getId());
	}

}
