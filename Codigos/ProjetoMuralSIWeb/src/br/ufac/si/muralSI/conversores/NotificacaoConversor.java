package br.ufac.si.muralSI.conversores;

import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.muralSI.entidades.*;
import br.ufac.si.muralSI.gerentes.*;

@FacesConverter(value="notificacaoConversor", forClass=Notificacao.class)
public class NotificacaoConversor implements Converter {

	NotificacaoGerente ng = new NotificacaoGerente();
	
	public Object getAsObject(FacesContext context, 
			UIComponent component, String value) {
		if(value == null || value.isEmpty())
			return null;
		return ng.recuperar(Long.valueOf(value));
	}

	public String getAsString(FacesContext context, 
			UIComponent component, Object value) {
		if(value == null || !(value instanceof Notificacao))
			return "";		// AQUI ESTAVA O GARGALO!
//			return null; 	// ANTES RETORNÃ�VAMOS null,
//							// ISSO ESTAVA GERANDO O PROBLEMA! 
//							// NA PROXIMA AULA, PERGUNTEM O PORQUÃŠ?
		return String.valueOf(((Notificacao)value).getId());
	}

}
