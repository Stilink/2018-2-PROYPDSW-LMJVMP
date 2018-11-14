package PROYPDSW.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.google.inject.Inject;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;


@ViewScoped
@SuppressWarnings("deprecation")
@ManagedBean (name ="registerIBean")
public class RegisterIniBean extends BasePageBean{
	@Inject
	private ServicesIniciativa service;
	private String usuario;
	private Perfil usr;
	private String nameI;
	private String description;
	private List<String> keyWords = new ArrayList<String>();
	
	public void registrarIniciativa() throws Exception {
		try {
			Iniciativa ini = new Iniciativa(80,nameI,"En espera de revisión",usr,description,new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			ini.setPalabrasClave(keyWords);
			service.agregarIniciativa(ini);
		} catch (ExcepcionServicesIniciativa e) {
			throw e;
		}
	}
	public void addKeyWord(String kwd) {
		keyWords.add(kwd);
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Perfil getUsr() {
		return usr;
	}
	public void setUsr(Perfil usr) {
		this.usr = usr;
	}
	public String getNameI() {
		return nameI;
	}
	public void setNameI(String nameI) {
		this.nameI = nameI;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(List<String> keyWords) {
		this.keyWords = keyWords;
	}

}
