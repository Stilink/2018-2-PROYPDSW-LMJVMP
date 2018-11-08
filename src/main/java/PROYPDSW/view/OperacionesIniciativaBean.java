package PROYPDSW.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.ibatis.javassist.compiler.ast.Keyword;

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
	
    @PostConstruct
    public void init() {
    	keyWords.add("afdafa"); 
    }
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
	public List<String> getKeyWords() {
		return keyWords;
	}
	public int tam() {
		return keyWords.size();
	}
	public void addKeyWord(String kwd) {
		keyWords.add(kwd);
	}
}
