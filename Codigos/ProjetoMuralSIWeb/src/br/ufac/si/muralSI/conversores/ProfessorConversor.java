package br.ufac.si.muralSI.conversores;

import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@FacesConverter(value="professorConversor", forClass=Professor.class)
public class ProfessorConversor implements Converter {

	ProfessorGerente pg = new ProfessorGerente();
	
	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String value) {
		if(value == null || value.isEmpty())
			return null;
		return pg.recuperar(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent component, Object value) {
		if(value == null || !(value instanceof Professor))
			return "";		// AQUI ESTAVA O GARGALO!
//			return null; 	// ANTES RETORNÁVAMOS null,
//							// ISSO ESTAVA GERANDO O PROBLEMA! 
//							// NA PROXIMA AULA, PERGUNTEM O PORQUÊ?
		return String.valueOf(((Professor)value).getId());
	}

}
