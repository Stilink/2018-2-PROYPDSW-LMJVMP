package PROYPDSW.sampleprj.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import PROYPDSW.sampleprj.dao.IniciativaDAO;
import PROYPDSW.sampleprj.dao.mybatis.mappers.IniciativaMapper;
import PROYPDSW.samples.entities.Comentario;
import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;

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
			List<Iniciativa> iniciativas = im.consultarIniciativaPorPalabraClave(palabraClave);
			boolean in = false;
			for(Iniciativa ini : iniciativas) {
				for(Iniciativa iniT : todas) {
					if(ini.getId()==iniT.getId()) {
						in=true;
						break;
					}
				}
				if(in) {
					continue;
				}else {
					todas.add(ini);
				}
			}
		}
		return todas;
	}

	public void agregarIniciativa(Iniciativa ini)throws PersistenceException {
		im.agregarIniciativa(ini);
		int id = ini.getId();
		for(String pc : ini.getPalabrasClave()) {
			im.agregarPalabraClaveAIniciativa(id,pc);
		}
	}
	@Override
	public Iniciativa consultarIniciativa(int id) throws PersistenceException {
		Iniciativa ini=im.consultarIniciativa(id);
		ini.setPalabrasClave(im.palabrasClaveDeIniciativa(id));
		try {
			ini.setComentarios(im.consultarComentariosDeIniciativa(id));
		}catch(NullPointerException ex) {
			ini.setComentarios(new ArrayList<Comentario>());
		}
		try {
			ini.setInteresados(im.consultarInteresadosDeIniciativa(id));
		}catch(NullPointerException ex) {
			ini.setInteresados(new ArrayList<Perfil>());
		}
		try {
			ini.setVoluntarios(im.consultarInteresadosDeIniciativa(id));
		}catch(NullPointerException ex) {
			ini.setVoluntarios(new ArrayList<Perfil>());
		}
		return ini;
	}
	@Override
	public List<Iniciativa> consultarIniciativasPorArea(String area) throws PersistenceException {
		return im.consultarIniciativasPorArea(area);
	}
	@Override
	public void modificarEstadoDeLaIniciativa(Iniciativa iniciativa, String estado) {
		im.modificarEstadoDeLaIniciativa(iniciativa, estado);
		
	}

	public void agregarInteresAIniciativa(int ini, String perfil) throws PersistenceException {
		im.agregarInteresAIniciativa(ini,perfil);
		int votos = im.consultarCantidadVotosIniciativa(ini);
		im.actualizarVotosIniciativa(ini, votos);
	}
	
	@Override
	public void cancelarInteresAIniciativa(int ini, String perfil) throws PersistenceException {
		im.cancelarInteresAIniciativa(ini, perfil);
		int votos = im.consultarCantidadVotosIniciativa(ini);
		im.actualizarVotosIniciativa(ini, votos);
		
	}
	@Override
	public boolean estaInteresadoEnIniciativa(int ini, String perfil) {
		return im.consultarInteres(ini,perfil);
	}
	
	@Override
	public int consultarCantidadVotosIniciativa(int ini) throws PersistenceException {
		return im.consultarCantidadVotosIniciativa(ini);
	}
	
	@Override
	public void agregarVoluntadAIniciativa(int ini, String perfil) throws PersistenceException {
		im.agregarVoluntadAIniciativa(ini,perfil);
		
	}
	@Override
	public List<Iniciativa> consultarIniciativaPorPerfil(String perfil) throws PersistenceException {
		return im.consultarIniciativasPorPerfil(perfil);
	}
	@Override
	public List<String> getPalabrasClave(int id) throws PersistenceException {
		return im.palabrasClaveDeIniciativa(id);
	}

	public boolean isParticipando(String usr, int idAConsultar) throws PersistenceException {
		return im.isParticipando(usr,idAConsultar);
	}
	@Override
	public void eliminarVoluntad(String perfil,int ini) throws PersistenceException {
		im.eliminarVoluntad(perfil,ini);
	}
	public void modificarIniciativa(Iniciativa iniciativa) {
		im.eliminarPalabrasClave(iniciativa);
		for(String palabra : iniciativa.getPalabrasClave()) {
			im.agregarPalabraClaveAIniciativa(iniciativa.getId(), palabra);
		}
		im.modificarIniciativa(iniciativa);
	}
}