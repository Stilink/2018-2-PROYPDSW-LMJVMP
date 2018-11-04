package PROYPDSW.sampleprj.dao.mybatis.mappers;

import java.util.List;

import PROYPDSW.samples.entities.Perfil;

public interface PerfilMapper {

	Perfil consultarPerfil(String email);

	List<Perfil> consultarUsuarios();

	List<Perfil> consultarPerfilPorRol(String rol);

	List<Perfil> consultarPerfilPorArea(String area);

}
