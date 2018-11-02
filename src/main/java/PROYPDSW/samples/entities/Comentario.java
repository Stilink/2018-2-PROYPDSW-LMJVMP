package PROYPDSW.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class Comentario implements Serializable{
	
	private Perfil perfil;
	private String descripcion;
	private Date fecha;
	
	public Comentario() {
		
	}
	
	public Comentario(Perfil perfil, String descripcion, Date fecha) {
		this.perfil=perfil;
		this.descripcion=descripcion;
		this.fecha=fecha;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil=perfil;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha=fecha;
	}
	
	@Override
	public String toString() {
		return "Usuario: {"+perfil.toString()+"} Comentario: "+descripcion+" Fecha: "+fecha.toString();
	}
}
