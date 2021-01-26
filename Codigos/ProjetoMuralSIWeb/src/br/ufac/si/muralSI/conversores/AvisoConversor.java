package br.ufac.si.muralSI.conversores;

import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@FacesConverter(value="notificacaoConversor", forClass=Aviso.class)
public class AvisoConversor implements Converter {

	AvisoGerente ng = new AvisoGerente();
	
	public Object getAsObject(FacesContext context, 
			UIComponent component, String value) {
		if(value == null || value.isEmpty())
			return null;
		return ng.recuperar(Long.valueOf(value));
	}

	public String getAsString(FacesContext context, 
			UIComponent component, Object value) {
		if(value == null || !(value instanceof Aviso))
			return "";		
//			return null; 	

		return String.valueOf(((Aviso)value).getId());
	}

}
