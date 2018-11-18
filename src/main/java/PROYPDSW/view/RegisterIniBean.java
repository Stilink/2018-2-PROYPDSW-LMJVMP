package PROYPDSW.view;

import java.sql.Date;
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
	private String usuario = "luis.moreno-a@mail.escuelaing.edu.co";
	private String nameI;
	private String description;
	private List<String> keyWords = new ArrayList<String>();
	
	public void registrarIniciativa() throws Exception {
		try {
			Perfil creador = service.consultarPerfil("luis.moreno-a@mail.escuelaing.edu.co");
			int id = establecerId();
			Iniciativa ini = new Iniciativa(id,nameI,"En espera de revision",creador,description, new Date(System.currentTimeMillis()));
			ini.setPalabrasClave(keyWords);
			service.agregarIniciativa(ini);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/** Establece el id en base a la cantidad de datos dentro de la tabla.*/
	private int establecerId() {
		try {
			List<Iniciativa> iniciativas = service.consultarIniciativas();
			int max = 1;
			for(Iniciativa ini : iniciativas) {
				if(ini.getId()>=max) {
					max=ini.getId()+1;
				}
			}
			return max;
		} catch (ExcepcionServicesIniciativa e) {
			return Integer.MAX_VALUE;
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
