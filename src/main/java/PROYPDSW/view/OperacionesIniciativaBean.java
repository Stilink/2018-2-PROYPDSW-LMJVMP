package PROYPDSW.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import PROYPDSW.samples.services.ServicesIniciativa;

@SessionScoped
@SuppressWarnings("deprecation")
@ManagedBean (name ="operacionIBean")
public class OperacionesIniciativaBean {
	@Inject
	private ServicesIniciativa service;
	private String usuario;
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
	public void registrarIniciativa() {
		
	}
	public void addKeyWord() {
		
	}
}
