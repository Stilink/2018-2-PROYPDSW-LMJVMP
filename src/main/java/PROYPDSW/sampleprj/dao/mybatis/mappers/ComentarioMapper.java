package PROYPDSW.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import PROYPDSW.samples.entities.Comentario;
import PROYPDSW.samples.entities.Iniciativa;

public interface ComentarioMapper {

	void agregarComentarioAIniciativa(@Param("iniciativa") Iniciativa iniciativa,@Param("comentario") Comentario comentario)throws PersistenceException;

	List<Comentario> consultarComentariosDeIniciativa(@Param("iniciativa")Iniciativa iniciativa)throws PersistenceException;

	int maximoIdComentarios()throws PersistenceException;

}
