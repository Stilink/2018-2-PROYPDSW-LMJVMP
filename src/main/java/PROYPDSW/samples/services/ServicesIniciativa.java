package PROYPDSW.samples.services;

import java.util.List;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;

public interface ServicesIniciativa {
	public Iniciativa consultarIniciativa(int id) throws ExcepcionServicesIniciativa;
	public List<Iniciativa> consultarIniciativas()throws ExcepcionServicesIniciativa;
	public List<Iniciativa> consultarIniciativaPorPerfil(String perfil)throws ExcepcionServicesIniciativa;
	public List<Iniciativa> consultarIniciativasPorEstado(String estado)throws ExcepcionServicesIniciativa;
	public List<Iniciativa> consultarIniciativasPorArea(String area)throws ExcepcionServicesIniciativa;
	public List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave)throws ExcepcionServicesIniciativa;
	public void agregarIniciativa(Iniciativa ini) throws ExcepcionServicesIniciativa;
	public Perfil consultarPerfil(String email) throws ExcepcionServicesIniciativa;
	public List<Perfil> consultarUsuarios() throws ExcepcionServicesIniciativa;
	public List<Perfil> consultarPerfilPorRol(String rol) throws ExcepcionServicesIniciativa;
	public boolean validarLogin(String email,String password)throws ExcepcionServicesIniciativa;
	public void agregarInteresAIniciativa(int ini,String perfil) throws ExcepcionServicesIniciativa;
	public void agregarVoluntadAIniciativa(int ini,String perfil) throws ExcepcionServicesIniciativa;
	
}

