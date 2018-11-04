package PROYPDSW.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import PROYPDSW.sampleprj.dao.PerfilDAO;
import PROYPDSW.sampleprj.dao.mybatis.mappers.PerfilMapper;
import PROYPDSW.samples.entities.Perfil;

public class MyBATISPerfilDAO implements PerfilDAO{
	@Inject
	private PerfilMapper pm;
	public Perfil consultarPerfil(String email) {
		return pm.consultarPerfil(email);
	}

	public List<Perfil> consultarUsuarios() {
		return pm.consultarUsuarios();
	}

	public List<Perfil> consultarPerfilPorRol(String rol) {
		return pm.consultarPerfilPorRol(rol);
	}

	public List<Perfil> consultarPerfilPorArea(String area) {
		return pm.consultarPerfilPorArea(area);
	}

}
