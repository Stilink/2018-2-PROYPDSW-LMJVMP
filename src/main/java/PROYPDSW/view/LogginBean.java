package PROYPDSW.view;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;

@SessionScoped
@SuppressWarnings("deprecation")
@ManagedBean (name ="loginBean")
public class LogginBean extends BasePageBean{
	@Inject
	private ServicesIniciativa services;
	private String userName;
	private String userPassword;	
	private boolean kw;
	public void setKw(boolean kw) {
		this.kw=kw;
	}
	public boolean getKw() {
		return kw;
	}
	public void setUserName(String name) {
		userName=name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserPassword(String passwd) {
		userPassword=passwd;
	}
	public String getUserPassword() {
		return userPassword;
	}	
	//Login
	public void ingresar(){
		try {
			kw=services.validarLogin(userName, userPassword);
		} catch (ExcepcionServicesIniciativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
