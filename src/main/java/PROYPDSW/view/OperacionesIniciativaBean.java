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

import PROYPDSW.samples.entities.Comentario;
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
	private int idAConsultar;
	private Iniciativa iniConsultada;
	private List<Iniciativa> iniConsultadas;
	private List<String> palabrasClaveAConsultar;
	private List<Comentario> comentarios;
	
	public String palabrasClaveToString() {
		String union=" ";
		List<String> palabrasClave = iniConsultada.getPalabrasClave();
		for(int i=0; i< palabrasClave.size();i++){
			if(i!=palabrasClave.size()-1) {
				union+=palabrasClave.get(i)+" , ";
			}else {
				union+=palabrasClave.get(i);
			}
			
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
			consultarComentariosIniConsultada();
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
	
	public void agregarComentarioAIniciativa(Perfil perfil, String descripcion) {
		int id = calcularIdComentario();
		Comentario comentario = new Comentario(perfil, descripcion, new Date(System.currentTimeMillis()), id, iniConsultada);
		try {
			service.agregarComentarioAIniciativa(iniConsultada, comentario);
		} catch (ExcepcionServicesIniciativa e) {
			System.out.println("Falló en la inserción del comentario");
			e.printStackTrace();
		}
		
		
	}
	
	
	private int calcularIdComentario() {
		Integer id=null;
		try {
			id = service.maximaIdComentarios();
			if(id.equals(null)){
				id=1;
			}else {
				id++;
			}
		} catch (ExcepcionServicesIniciativa e) {
			
			e.printStackTrace();
		}
		return id;
	}
	
	private void consultarComentariosIniConsultada() {
		try {
			comentarios=service.consultarComentariosDeIniciativa(iniConsultada);
		} catch (ExcepcionServicesIniciativa e) {
			System.out.println("Falló en la consulta de los comentarios de la iniciativa");
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
	public void votar(String perfil, int iniciativa) {
		try {
			boolean yaVotado=votado(perfil, iniciativa);
			if (yaVotado) {
				cancelarVoto(perfil,iniciativa);
			}
			else {
				añadirVoto(perfil,iniciativa);
			}
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void añadirVoto(String perfil, int iniciativa) {
		try {
			service.agregarInteresAIniciativa(iniciativa, perfil);
		} catch (ExcepcionServicesIniciativa e1) {
			e1.printStackTrace();
		}		
	}
	public boolean votado(String perfil, int iniciativa) throws ExcepcionServicesIniciativa {
		try {
			return service.estaInteresadoEnIniciativa(iniciativa, perfil);
		} catch (ExcepcionServicesIniciativa e) {
			throw e;
		}
	}
	private void cancelarVoto(String perfil, int iniciativa) {
		try {
			service.cancelarInteresAIniciativa(iniciativa, perfil);
		} catch (ExcepcionServicesIniciativa e1) {
			e1.printStackTrace();
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
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
