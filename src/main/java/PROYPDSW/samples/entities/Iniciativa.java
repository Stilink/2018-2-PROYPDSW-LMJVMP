package PROYPDSW.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Iniciativa implements Serializable{
	
	private int id;
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
	
	public Iniciativa(int id,String nombre,String estado,Perfil creador,String descripcion,Date fechaDeCreacion) {
		this.id=id;
		this.nombre=nombre;
		this.estado=estado;
		this.creador=creador;
		this.descripcion=descripcion;
		this.fechaDeCreacion=fechaDeCreacion;
	}
	
	public Iniciativa() {
		
	}
	
	public Iniciativa(int id, List<String> palabrasClave, 
			List<Comentario> comentarios, List<Perfil> voluntarios, 
			List<Perfil> interesados, String nombre, String estado, Perfil creador, 
			int no_votos, String descripcion, Date fechaDeCreacion) {
		this.id=id;
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
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
	
	public Perfil getCreador() {
		return creador;
	}
	
	public void setCreador(Perfil creador) {
		this.creador=creador;
	}
	
	public int getNo_votos() {
		return no_votos;
	}
	
	public void setNo_votos(int no_votos) {
		this.no_votos=no_votos;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion=fechaDeCreacion;
	}
	
	public String toString() {
		return "Id: "+id+" Nombre: "+nombre+" Descripcion: "+descripcion+" Estado: "+estado+" Creador: {"+creador.toString()+"} Fecha de creación: "+fechaDeCreacion.toString();
	}

}
