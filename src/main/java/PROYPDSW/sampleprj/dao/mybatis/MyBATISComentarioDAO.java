package PROYPDSW.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import PROYPDSW.sampleprj.dao.ComentarioDAO;
import PROYPDSW.sampleprj.dao.mybatis.mappers.ComentarioMapper;
import PROYPDSW.samples.entities.Comentario;
import PROYPDSW.samples.entities.Iniciativa;

public class MyBATISComentarioDAO implements ComentarioDAO {
	@Inject
	private ComentarioMapper cm;

	@Override
	public void agregarComentarioAIniciativa(Iniciativa iniciativa, Comentario comentario) throws PersistenceException{
		cm.agregarComentarioAIniciativa(iniciativa, comentario);
		
	}

	@Override
	public List<Comentario> consultarComentariosDeIniciativa(Iniciativa iniciativa) throws PersistenceException{
		return cm.consultarComentariosDeIniciativa(iniciativa);
		
	}

	@Override
	public int maximoIdComentarios() throws PersistenceException{
		return cm.maximoIdComentarios();
		
	}
	
	
}
