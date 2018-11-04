package PROYPDSW.sampleprj.dao.mybatis.mappers;

import java.util.Collection;
import java.util.List;

import PROYPDSW.samples.entities.Iniciativa;

public interface IniciativaMapper {

	List<Iniciativa> consultarIniciativas();

	List<Iniciativa> consultarIniciativasPorEstado(String estado);

	List<Iniciativa> consultarIniciativaPorPalabraClave(String palabraClave);

	void agregarIniciativa(Iniciativa ini);

}
