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
	private String perfilAConsultar;
	private Perfil perfilConsultado;
	
	

	public void perfilesConsultados(){
		try {
			perfilesConsultados = service.consultarUsuarios();
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void asignarRolAPerfil(String rol) {
		try {
			service.asignarRolAPerfil(perfilConsultado, rol);
		} catch (ExcepcionServicesIniciativa e) {
			e.printStackTrace();
		}
	}
	
	public void consultarPerfil() {
		try {
			perfilConsultado= service.consultarPerfil(perfilAConsultar);
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public Perfil getPerfilConsultado() {
		return perfilConsultado;
	}

	public void setPerfilConsultado(Perfil perfilConsultado) {
		this.perfilConsultado = perfilConsultado;
	}
	
	
	
	
	public String getPerfilAConsultar() {
		return perfilAConsultar;
	}

	public void setPerfilAConsultar(String perfilAConsultar) {
		this.perfilAConsultar = perfilAConsultar;
	}
	
	
	public List<Perfil> getPerfilesConsultados() {
		return perfilesConsultados;
	}
	public void setPerfilesConsultados(List<Perfil> perfilesConsultados) {
		this.perfilesConsultados = perfilesConsultados;
	}
	
	
	

}
