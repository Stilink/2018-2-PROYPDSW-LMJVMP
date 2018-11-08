package PROYPDSW.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;

@SessionScoped
@SuppressWarnings("deprecation")
@ManagedBean (name ="operacionIBean")
public class OperacionesIniciativaBean extends BasePageBean{
	@Inject
	private ServicesIniciativa service;
	private String usuario;
	private Perfil usr;
	private String nameI;
	private String description;
	private List<String> keyWords = new ArrayList<String>();
	
	public void setNameI(String name) {
		nameI=name;
	}
	public String getNameI() {
		return nameI;
	}
	public void setDescription(String desc) {
		description=desc;
	}
	public String getDescription() {
		return description;
	}
	public void registrarIniciativa() throws Exception {
		try {
			Iniciativa ini = new Iniciativa(80,nameI,"En espera de revisión",usr,description,new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			ini.setPalabrasClave(keyWords);
			service.agregarIniciativa(ini);
		} catch (ExcepcionServicesIniciativa e) {
			throw e;
		}
	}
	public List<String> getKeyWords() {
		return keyWords;
	}
	public void addKeyWord(String kwd) {
		keyWords.add(kwd);
	}
	
	public List<Iniciativa> consultarIniciativas() throws Exception {
		try {
			return service.consultarIniciativas();
		} catch (ExcepcionServicesIniciativa e) {
			throw e;
		}
	}
}
