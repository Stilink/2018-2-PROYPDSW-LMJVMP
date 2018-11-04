package PROYPDSW.sampleprj.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import PROYPDSW.sampleprj.dao.IniciativaDAO;
import PROYPDSW.sampleprj.dao.mybatis.mappers.IniciativaMapper;
import PROYPDSW.samples.entities.Iniciativa;

public class MyBATISIniciativaDAO implements IniciativaDAO{
	@Inject
	private IniciativaMapper im;
	public List<Iniciativa> consultarIniciativas() {
		return im.consultarIniciativas();
	}

	public List<Iniciativa> consultarIniciativasPorEstado(String estado) {
		return im.consultarIniciativasPorEstado(estado);
	}

	public List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave) {
		List<Iniciativa> todas=new ArrayList<Iniciativa>();
		for(String palabraClave:palabrasClave) {
			todas.addAll(im.consultarIniciativaPorPalabraClave(palabraClave));
		}
		return todas;
	}

	public void agregarIniciativa(Iniciativa ini) {
		im.agregarIniciativa(ini);
	}

}
