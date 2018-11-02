package PROYPDSW.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Iniciativa implements Serializable{
	
	private String area;
	private List<String> palabrasClave;
	private List<Comentario> comentarios;
	private List<Perfil> voluntarios;
	private List<Perfil> interesados;
	private String nombre;
	private String estado;
	private Perfil creador;
	private int no_votos;
	private String descripcion;
	private Date fechaDeCreacion;
	
	public Iniciativa() {
		
	}
	
	public Iniciativa(String area, List<String> palabrasClave, 
			List<Comentario> comentarios, List<Perfil> voluntarios, 
			List<Perfil> interesados, String nombre, String estado, Perfil creador, 
			int no_votos, String descripcion, Date fechaDeCreacion) {
		this.area=area;
		this.palabrasClave=palabrasClave;
		this.comentarios=comentarios;
		this.voluntarios=voluntarios;
		this.interesados=interesados;
		this.nombre=nombre;
		this.estado=estado;
		this.creador=creador;
		this.no_votos=no_votos;
		this.descripcion=descripcion;
		this.fechaDeCreacion=fechaDeCreacion;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area=area;
	}
	
	public List<String> getPalabrasClave(){
		return palabrasClave;
	}
	
	public void setPalabrasClave(List<String> palabrasClave) {
		this.palabrasClave=palabrasClave;
	}
	
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios=comentarios;
	}
	
	public List<Perfil> getVoluntarios(){
		return voluntarios;
	}
	
	public void setVoluntarios(List<Perfil> voluntarios) {
		this.voluntarios=voluntarios;
	}
	
	public List<Perfil> getInteresados(){
		return interesados;
	}
	
	public void setInteresados(List<Perfil> interesados) {
		this.interesados=interesados;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado=estado;
	}

}
