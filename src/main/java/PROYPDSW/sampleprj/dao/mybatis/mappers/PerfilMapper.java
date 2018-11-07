package PROYPDSW.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;

public interface PerfilMapper {

	Perfil consultarPerfil(@Param("email") String email);

	List<Perfil> consultarUsuarios();

	List<Perfil> consultarPerfilPorRol(@Param("rol") String rol);

	List<Perfil> consultarPerfilPorArea(@Param("area") String area);

	List<Iniciativa> consultarInteresDePerfil(@Param("perfil") String email);

	List<Iniciativa> consultarVoluntadDePerfil(@Param("perfil") String email);

	boolean validarLogin(@Param("email") String email, @Param("password") String password);

}
