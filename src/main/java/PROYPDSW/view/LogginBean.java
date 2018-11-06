package PROYPDSW.view;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@SuppressWarnings("deprecation")
@ManagedBean (name ="loginBean")
public class LogginBean extends BasePageBean{
	private String text;
	public LogginBean() {
		
	}
	
	public void setText(String t) {
		text=t;
	}
	public String getText() {
		return text;
	}
	
}
