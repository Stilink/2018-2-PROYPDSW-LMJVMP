package PROYPDSW.sampleprj.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import PROYPDSW.sampleprj.dao.IniciativaDAO;
import PROYPDSW.sampleprj.dao.mybatis.mappers.IniciativaMapper;
import PROYPDSW.samples.entities.Iniciativa;

public class MyBATISIniciativaDAO implements IniciativaDAO{
	@Inject
	private IniciativaMapper im;
	public List<Iniciativa> consultarIniciativas()throws PersistenceException {
		return im.consultarIniciativas();
	}

	public List<Iniciativa> consultarIniciativasPorEstado(String estado) throws PersistenceException{
		return im.consultarIniciativasPorEstado(estado);
	}

	public List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave)throws PersistenceException {
		List<Iniciativa> todas=new ArrayList<Iniciativa>();
		for(String palabraClave:palabrasClave) {
			todas.addAll(im.consultarIniciativaPorPalabraClave(palabraClave));
		}
		return todas;
	}

	public void agregarIniciativa(Iniciativa ini)throws PersistenceException {
		im.agregarIniciativa(ini);
	}

}
