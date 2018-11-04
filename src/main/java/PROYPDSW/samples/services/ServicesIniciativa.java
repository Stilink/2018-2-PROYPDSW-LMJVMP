package PROYPDSW.samples.services;

import java.util.List;

import PROYPDSW.samples.entities.Perfil;

public interface ServicesIniciativa {
	/**
	 * Crear un perfil.
	 * @param carne
	 * @param nombre
	 * @param email
	 * @param rol
	 * @throws ExcepcionServicesIniciativa
	 */
	public void registarPerfil(int carne,  String nombre, String email, String rol) throws ExcepcionServicesIniciativa;
	
	/**
	 * Añadir iniciativa
	 * @param nombre
	 * @param dscripcion
	 * @param creador
	 * @throws ExcepcionServicesIniciativa
	 */
	public void agregarIniciativa(String nombre, String dscripcion, int creador) throws ExcepcionServicesIniciativa;
	
	// Para el rol administrador
	/**
	 * Poder cambiar o asignar a un usuario un perfil (¿rol?)
	 * @param carne
	 * @param rol
	 */
	public void asignarPerfil(int carne, String rol) throws ExcepcionServicesIniciativa;
	
	/**
	 * Consultar todos los usuarios registrados en la plataforma
	 * @return
	 */
	public List<Perfil> consultarUsuarios() throws ExcepcionServicesIniciativa;
	
	/**
	 * Consultar todos los usuarios con el rol solicitado
	 * @param rol
	 * @return
	 */
	public List<Perfil> consultarPerfilPorRol(String rol) throws ExcepcionServicesIniciativa;
	
	/**
	 * Consultar un usuario por su carné (carnet)
	 * @param carne
	 * @return
	 */
	public Perfil consultarPerfilPorCarne(int carne) throws ExcepcionServicesIniciativa;
	
	/**
	 * Consultar usuarios por nombre
	 * @param nombre
	 * @return
	 */
	public List<Perfil> consultarPerfilPorNombre(String nombre) throws ExcepcionServicesIniciativa;
}
