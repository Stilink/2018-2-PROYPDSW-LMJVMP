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
	public Iniciativa consultarIniciativa(int id) throws ExcepcionServicesIniciativa {
		try {
			return idao.consultarIniciativa(id);
		}catch(PersistenceException e){
			throw new ExcepcionServicesIniciativa("consultarIniciativa",e);
		}
	}

}
