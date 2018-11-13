package PROYPDSW.sampleprj.dao.mybatis.mappers;

import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import PROYPDSW.samples.entities.Comentario;
import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;

public interface IniciativaMapper {

	List<Iniciativa> consultarIniciativas();

	List<Iniciativa> consultarIniciativasPorEstado(@Param("estado") String estado);

	List<Iniciativa> consultarIniciativaPorPalabraClave(@Param("palabraClave") String palabraClave);

	void agregarIniciativa(@Param("ini") Iniciativa ini);

	Iniciativa consultarIniciativa(@Param("iniciativaId") int id);
	
	List<String> palabrasClaveDeIniciativa(@Param("iniciativa") int id);
	
	List<Comentario> consultarComentariosDeIniciativa(@Param("iniciativa") int id);

	List<Perfil> consultarInteresadosDeIniciativa(@Param("id") int id);

	List<Perfil> consultarVoluntariosDeIniciativa(@Param("id") int id);

	List<Iniciativa> consultarIniciativasPorArea(@Param("area")String area);

	void agregarPalabraClaveAIniciativa(@Param("iniciativa") int id, @Param("palabra") String pc);

}
