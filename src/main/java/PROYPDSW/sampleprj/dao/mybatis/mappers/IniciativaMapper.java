package PROYPDSW.sampleprj.dao.mybatis.mappers;

import java.util.Collection;
import java.util.List;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;

public interface IniciativaMapper {

	List<Iniciativa> consultarIniciativas();

	List<Iniciativa> consultarIniciativasPorEstado(String estado);

	List<Iniciativa> consultarIniciativaPorPalabraClave(String palabraClave);

	void agregarIniciativa(Iniciativa ini);

	Iniciativa consultarIniciativa(int id);

	List<Perfil> consultarInteresadosDeIniciativa(int id);

	List<Perfil> consultarVoluntariosDeIniciativa(int id);

}
