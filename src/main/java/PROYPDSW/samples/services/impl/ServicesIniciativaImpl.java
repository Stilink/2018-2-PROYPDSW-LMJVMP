package PROYPDSW.samples.services.impl;

import java.util.List;

import com.google.inject.Inject;

import PROYPDSW.sampleprj.dao.ComentarioDAO;
import PROYPDSW.sampleprj.dao.IniciativaDAO;
import PROYPDSW.sampleprj.dao.PerfilDAO;
import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;

public class ServicesIniciativaImpl implements ServicesIniciativa{
	@Inject
	private IniciativaDAO idao;
	@Inject
	private ComentarioDAO cdao;
	@Inject
	private PerfilDAO pdao;
	
	public List<Iniciativa> consultarIniciativas() throws ExcepcionServicesIniciativa {
		return idao.consultarIniciativas();
	}

	public List<Iniciativa> consultarIniciativasPorEstado(String estado) throws ExcepcionServicesIniciativa {
		return idao.consultarIniciativasPorEstado(estado);
	}

	public List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave)
			throws ExcepcionServicesIniciativa {
		return idao.consultarIniciativasPorPalabrasClave(palabrasClave);
	}

	public void agregarIniciativa(Iniciativa ini) throws ExcepcionServicesIniciativa {
		idao.agregarIniciativa(ini);
		
	}

	public Perfil consultarPerfil(String email) throws ExcepcionServicesIniciativa {
		return pdao.consultarPerfil(email);
	}

	public List<Perfil> consultarUsuarios() throws ExcepcionServicesIniciativa {
		return pdao.consultarUsuarios();
	}

	public List<Perfil> consultarPerfilPorRol(String rol) throws ExcepcionServicesIniciativa {
		return pdao.consultarPerfilPorRol(rol);
	}

	public List<Perfil> consultarPerfilPorArea(String area) throws ExcepcionServicesIniciativa {
		return pdao.consultarPerfilPorArea(area);
	}

}
