package PROYPDSW.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import PROYPDSW.samples.entities.Comentario;
import PROYPDSW.samples.entities.Iniciativa;

public interface ComentarioDAO {

	void agregarComentarioAIniciativa(Iniciativa iniciativa, Comentario comentario)throws PersistenceException;

	List<Comentario> consultarComentariosDeIniciativa(Iniciativa iniciativa)throws PersistenceException;

	int maximoIdComentarios()throws PersistenceException;

}
