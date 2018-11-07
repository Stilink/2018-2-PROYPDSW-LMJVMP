package PROYPDSW.view;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@SuppressWarnings("deprecation")
@ManagedBean (name ="loginBean")
public class LogginBean extends BasePageBean{
	private String userName;
	private String userPassword;	
	
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
	public void ingresar() {
		
	}
}
