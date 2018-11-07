package PROYPDSW.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import PROYPDSW.samples.entities.Perfil;

public interface PerfilDAO {

	Perfil consultarPerfil(String email)throws PersistenceException;

	List<Perfil> consultarUsuarios()throws PersistenceException;

	List<Perfil> consultarPerfilPorRol(String rol)throws PersistenceException;

	List<Perfil> consultarPerfilPorArea(String area)throws PersistenceException;

	boolean validarLogin(String email, String password)throws PersistenceException;

}
