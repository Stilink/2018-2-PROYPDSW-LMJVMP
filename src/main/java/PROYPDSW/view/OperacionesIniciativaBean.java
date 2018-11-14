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

import com.google.inject.Inject;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;

@RequestScoped
@SuppressWarnings("deprecation")
@ManagedBean (name ="operacionIBean")
public class OperacionesIniciativaBean extends BasePageBean{
	@Inject
	private ServicesIniciativa service;
	private String usuario;
	private Perfil usr;
	private String nameI;
	private String description;
	@ManagedProperty(value = "#{param.idAConsultar}")
	private int idAConsultar;
	private Iniciativa iniConsultada;
	private List<Iniciativa> iniConsultadas;
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
	
	public void consultarIniciativa() {
		try {
			iniConsultada = service.consultarIniciativa(idAConsultar);
		} catch (ExcepcionServicesIniciativa e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void consultarIniciativasPorArea(String area){
		try {
			iniConsultadas = service.consultarIniciativasPorArea(area);
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consultarIniciativasPorEstado(String estado){
		try {
			iniConsultadas = service.consultarIniciativasPorEstado(estado);
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarEstadoDeLaIniciativa(String id,String estado) {
		try {
			iniConsultada=service.consultarIniciativa(Integer.parseInt(id));
		} catch (ExcepcionServicesIniciativa e1) {
			e1.printStackTrace();
		}
		System.out.println(estado);
		System.out.println(id);
		System.out.println(iniConsultada.toString());
		try {
			service.modificarEstadoDeLaIniciativa(iniConsultada, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getIdAConsultar() {
		return idAConsultar;
	}
	public void setIdAConsultar(int idAConsultar) {
		this.idAConsultar = idAConsultar;
	}
	public Iniciativa getIniConsultada() {
		return iniConsultada;
	}
	public void setIniConsultada(Iniciativa iniConsultada) {
		this.iniConsultada = iniConsultada;
	}
	public List<Iniciativa> getIniConsultadas() {
		return iniConsultadas;
	}
	public void setIniConsultadas(List<Iniciativa> iniConsultadas) {
		this.iniConsultadas = iniConsultadas;
	}
	
}
