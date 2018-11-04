package PROYPDSW.sampleprj.dao;

import java.util.List;

import PROYPDSW.samples.entities.Perfil;

public interface PerfilDAO {

	Perfil consultarPerfil(String email);

	List<Perfil> consultarUsuarios();

	List<Perfil> consultarPerfilPorRol(String rol);

	List<Perfil> consultarPerfilPorArea(String area);

}
