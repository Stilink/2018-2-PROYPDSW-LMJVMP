package PROYPDSW.samples.services.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import PROYPDSW.sampleprj.dao.ComentarioDAO;
import PROYPDSW.sampleprj.dao.IniciativaDAO;
import PROYPDSW.sampleprj.dao.PerfilDAO;
import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;

@Singleton
public class ServicesIniciativaImpl implements ServicesIniciativa{
	@Inject
	private IniciativaDAO idao;
	@Inject
	private ComentarioDAO cdao;
	@Inject
	private PerfilDAO pdao;
	@Override
	public Iniciativa consultarIniciativa(int id) throws ExcepcionServicesIniciativa {
		try {
			return idao.consultarIniciativa(id);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarIniciativa",e);
		}
	}
	public List<Iniciativa> consultarIniciativas() throws ExcepcionServicesIniciativa {
		try{
			return idao.consultarIniciativas();
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarIniciativas",e);
		}
	}

	public List<Iniciativa> consultarIniciativasPorEstado(String estado) throws ExcepcionServicesIniciativa {
		try{
			return idao.consultarIniciativasPorEstado(estado);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarIniciativasPorEstado",e);
		}
	}

	public List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave)
			throws ExcepcionServicesIniciativa {
		try{
			return idao.consultarIniciativasPorPalabrasClave(palabrasClave);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarIniciativasPorPalabrasClave",e);
		}
	}

	public void agregarIniciativa(Iniciativa ini) throws ExcepcionServicesIniciativa {
		try{
			idao.agregarIniciativa(ini);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("agregarIniciativa",e);
		}
		
	}
	@Override
	public List<Iniciativa> consultarIniciativasPorArea(String area) throws ExcepcionServicesIniciativa {
		try{
			return idao.consultarIniciativasPorArea(area);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarPerfil",e);
		}
	}
	public Perfil consultarPerfil(String email) throws ExcepcionServicesIniciativa {
		try{
			return pdao.consultarPerfil(email);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarPerfil",e);
		}
	}

	public List<Perfil> consultarUsuarios() throws ExcepcionServicesIniciativa {
		try{
			return pdao.consultarUsuarios();
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarUsuarios",e);
		}
	}

	public List<Perfil> consultarPerfilPorRol(String rol) throws ExcepcionServicesIniciativa {
		try{
			return pdao.consultarPerfilPorRol(rol);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarPerfilPorRol",e);
		}
	}

	public List<Perfil> consultarPerfilPorArea(String area) throws ExcepcionServicesIniciativa {
		try{
			return pdao.consultarPerfilPorArea(area);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarPerfilPorArea",e);
		}
	}
	
	@Override
	public boolean validarLogin(String email, String password) throws ExcepcionServicesIniciativa{
		try {
			return pdao.validarLogin(email,password);
		} catch (Exception e) {
			throw new ExcepcionServicesIniciativa("validarLogin",e);
		}
	}
	@Override
	public void modificarEstadoDeLaIniciativa(Iniciativa iniciativa, String estado) throws ExcepcionServicesIniciativa {
		try {
			idao.modificarEstadoDeLaIniciativa(iniciativa, estado);
		}catch(Exception e) {
			throw new ExcepcionServicesIniciativa("Fallo en el modificar estado",e);
		}
	}
		
	public void agregarInteresAIniciativa(int ini, String perfil) throws ExcepcionServicesIniciativa {
		try {
			idao.agregarInteresAIniciativa(ini,perfil);
		} catch (Exception e) {
			throw new ExcepcionServicesIniciativa("validarLogin",e);
		}
	}
	@Override
	public void agregarVoluntadAIniciativa(int ini, String perfil) throws ExcepcionServicesIniciativa {
		try {
			idao.agregarVoluntadAIniciativa(ini,perfil);
		} catch (Exception e) {
			throw new ExcepcionServicesIniciativa("validarLogin",e);
		}
	}
	@Override
	public List<Iniciativa> consultarIniciativaPorPerfil(String perfil) throws ExcepcionServicesIniciativa {
		try {
			return idao.consultarIniciativaPorPerfil(perfil);
		} catch (Exception e) {
			throw new ExcepcionServicesIniciativa("validarLogin",e);
		}
	}
	@Override
	public void asignarRolAPerfil(Perfil perfil, String rol) throws ExcepcionServicesIniciativa {
		try{
			pdao.asignarRolAPerfil(perfil, rol);
		}catch(Exception e) {
			System.out.println("Fallo dentro de la asignacion de un rol a un perfil");
			throw new ExcepcionServicesIniciativa("Asignar_Rol_A_Perfil",e);
		}
	}

	public List<String> getPalabrasClave(int id) throws ExcepcionServicesIniciativa {
		try {
			return idao.getPalabrasClave(id);
		} catch (Exception e) {
			throw new ExcepcionServicesIniciativa("validarLogin",e);
		}
	}
}
