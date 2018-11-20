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
@ManagedBean (name ="operacionIBean")
public class OperacionesIniciativaBean extends BasePageBean{
	@Inject
	private ServicesIniciativa service;
	private String usuario;
	private Perfil usr;
	private int idAConsultar;
	private Iniciativa iniConsultada;
	private List<Iniciativa> iniConsultadas;
	private List<String> palabrasClaveAConsultar;

	public String palabrasClaveToString() {
		String union=" ";
		for(String palabra :iniConsultada.getPalabrasClave()) {
			union+=palabra+" , ";
		}
		
		return union;
	}
	
    public void consultarIni() {
        try {
			iniConsultadas=service.consultarIniciativas();
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void consultarIniciativasRelacionadas() {
    	try {
    		iniConsultada=service.consultarIniciativa(idAConsultar);
    		iniConsultadas=new ArrayList();
			for(Iniciativa ini : service.consultarIniciativasPorArea(iniConsultada.getCreador().getArea())) {
				for(String palabraClave:iniConsultada.getPalabrasClave()) {
					if (service.getPalabrasClave(ini.getId()).contains(palabraClave) && !iniConsultadas.contains(ini)){
						iniConsultadas.add(ini);
					}
				}
			}
    	}catch (ExcepcionServicesIniciativa e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
    
    
    public void consultarIniPerfil(String username) {
        try {
			iniConsultadas=service.consultarIniciativaPorPerfil(username);
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void consultarIniciativasPorPalabrasClave() {
		try {
			iniConsultadas = service.consultarIniciativasPorPalabrasClave(palabrasClaveAConsultar);
		}catch(ExcepcionServicesIniciativa e) {
			e.printStackTrace();
		}
		
	}
	
	public void modificarEstadoDeLaIniciativa(String id,String estado) {
		try {
			iniConsultada=service.consultarIniciativa(Integer.parseInt(id));
		} catch (ExcepcionServicesIniciativa e1) {
			e1.printStackTrace();
		}
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
	public List<String> getPalabrasClaveAConsultar() {
		return palabrasClaveAConsultar;
	}

	public void setPalabrasClaveAConsultar(List<String> palabrasClaveAConsultar) {
		this.palabrasClaveAConsultar = palabrasClaveAConsultar;
	}
	
}
