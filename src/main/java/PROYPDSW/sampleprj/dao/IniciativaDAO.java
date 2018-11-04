package PROYPDSW.sampleprj.dao;

import java.util.List;

import PROYPDSW.samples.entities.Iniciativa;

public interface IniciativaDAO {

	List<Iniciativa> consultarIniciativas();

	List<Iniciativa> consultarIniciativasPorEstado(String estado);

	List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave);

	void agregarIniciativa(Iniciativa ini);
	

}
