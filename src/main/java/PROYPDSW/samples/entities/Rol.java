package PROYPDSW.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Rol implements Serializable {
	
	private String nombre;
	private int prioridad;
	
	public Rol() {
		
	}
	
	public Rol(String nombre, int prioridad) {
		this.nombre= nombre;
		this.prioridad = prioridad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(int prioridad) {
		this.prioridad=prioridad;
	}
	
	@Override
    public String toString() {
        return "Rol: "+nombre+" Prioridad: "+prioridad;
    }
	
	
}
