package PROYPDSW.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Perfil implements Serializable{
	
	private int carne;
	private Rol rol;
	private String email;
	private String nombre;
	private List<Iniciativa> interes;
	private List<Iniciativa> voluntad;
	
	public Perfil() {
		
	}
	
	public Perfil(int carne, Rol rol, String email, String nombre, List<Iniciativa> interes, List<Iniciativa> voluntad) {
		this.carne=carne;
		this.rol=rol;
		this.email=email;
		this.nombre=nombre;
		this.interes=interes;
		this.voluntad=voluntad;
	}
	
	public int getCarne() {
		return carne;
	}
	
	public void setCarne(int carne) {
		this.carne=carne;
	}
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol=rol;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public List<Iniciativa> getInteres(){
		return interes;
	}
	
	public void setInteres(List<Iniciativa> interes) {
		this.interes=interes;
	}
	
	public List<Iniciativa> getVoluntad(){
		return voluntad;
	}
	
	public void setVoluntad(List<Iniciativa> voluntad) {
		this.voluntad=voluntad;
	}
	
	@Override
	public String toString() {
		return "Care: "+carne+" Nombre: "+nombre+" Email: "+email+" Rol: {"+rol.toString()+"}";
	}

}
