package PROYPDSW.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import PROYPDSW.samples.entities.Iniciativa;

public interface IniciativaDAO {

	List<Iniciativa> consultarIniciativas()throws PersistenceException;

	List<Iniciativa> consultarIniciativasPorEstado(String estado)throws PersistenceException;

	List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave)throws PersistenceException;

	void agregarIniciativa(Iniciativa ini)throws PersistenceException;

	Iniciativa consultarIniciativa(int id)throws PersistenceException;

	List<Iniciativa> consultarIniciativasPorArea(String area)throws PersistenceException;

	void agregarInteresAIniciativa(int ini, String perfil)throws PersistenceException;

	void agregarVoluntadAIniciativa(int ini, String perfil)throws PersistenceException;

	List<Iniciativa> consultarIniciativaPorPerfil(String perfil)throws PersistenceException;
	

}
