package PROYPDSW.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@ManagedBean (name ="operacionPBean")

public class OperacionesPerfilBean extends BasePageBean{
	@Inject
	private ServicesIniciativa service;
	private List<Perfil> perfilesConsultados;
	private List<Perfil> perfilesSeleccionados=new ArrayList<Perfil>();
	
	
	
	

	

	public void perfilesOriginal(){
		try {
			perfilesConsultados = service.consultarUsuarios();
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void asignarRolAPerfil(String rol) {
		try {
			for(Perfil p: perfilesSeleccionados) {
				service.asignarRolAPerfil(p, rol);
			}
			perfilesSeleccionados = new ArrayList<Perfil>();
			
		} catch (ExcepcionServicesIniciativa e) {
			e.printStackTrace();
		}
	}
	
	public void seleccionarPerfil(Perfil perfil) {
		boolean esta = false;
		for(Perfil p : perfilesSeleccionados) {
			if(p.getEmail().equals(perfil.getEmail())) {
				esta=true;
				break;
			}
		}
		if(!esta) {
		perfilesSeleccionados.add(perfil);}
		perfilesConsultados.remove(perfil);
	}
	
	public void quitarPerfil(Perfil perfil) {
		perfilesConsultados.add(perfil);
		perfilesSeleccionados.remove(perfil);
	}
	
		
	
	public List<Perfil> getPerfilesConsultados() {
		return perfilesConsultados;
	}
	public void setPerfilesConsultados(List<Perfil> perfilesConsultados) {
		this.perfilesConsultados = perfilesConsultados;
	}
	
	public List<Perfil> getPerfilesSeleccionados() {
		return perfilesSeleccionados;
	}

	public void setPerfilesSeleccionados(List<Perfil> perfilesSeleccionados) {
		this.perfilesSeleccionados = perfilesSeleccionados;
	}
	

}
