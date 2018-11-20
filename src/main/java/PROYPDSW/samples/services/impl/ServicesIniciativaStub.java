package PROYPDSW.samples.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PROYPDSW.samples.entities.Comentario;
import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;
import PROYPDSW.samples.entities.Rol;
import PROYPDSW.samples.services.ExcepcionServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServicesIniciativaStub implements ServicesIniciativa{
	private final static long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
	private final List<Rol> roles;

	
	private final Map<String,Perfil> perfiles;
	private final List<Iniciativa> iniciativas;
	
	public ServicesIniciativaStub() {
		perfiles = new HashMap<>();
		iniciativas = new ArrayList<>();
		roles = new ArrayList<>();
	    poblar();
	}
	
	public List<Iniciativa> consultarIniciativas() throws ExcepcionServicesIniciativa {
		return  iniciativas;
	}

	public List<Iniciativa> consultarIniciativasPorEstado(String estado) throws ExcepcionServicesIniciativa {
		ArrayList<Iniciativa> iniciativasPorEstado = new ArrayList<>();
		for(Iniciativa i: iniciativas) {
			if(i.getEstado().equals(estado)) iniciativasPorEstado.add(i);
		}
		return iniciativasPorEstado;
	}

	public List<Iniciativa> consultarIniciativasPorPalabrasClave(List<String> palabrasClave) throws ExcepcionServicesIniciativa {
		List<Iniciativa> iniciativasPorPalabrasClave = new ArrayList();
		for(Iniciativa in: iniciativas) {
			List<String> pc = in.getPalabrasClave();
			Boolean flag = true;
			for(String s: pc) {
				if (!palabrasClave.contains(s))flag=false;
			}
			iniciativasPorPalabrasClave.add(in);
		}
		return iniciativasPorPalabrasClave;
	}

	public void agregarIniciativa(Iniciativa ini) throws ExcepcionServicesIniciativa {
		iniciativas.add(ini);
	}

	public Perfil consultarPerfil(String email) throws ExcepcionServicesIniciativa {
	       Perfil perfil = null;
	       if(perfiles.containsKey(email)){
	           perfil=perfiles.get(email);
	       }
	       else {
	    	   throw new ExcepcionServicesIniciativa("Error al consultar el perfil: "+email);
	       }
	       return perfil;
	}

	public List<Perfil> consultarUsuarios() throws ExcepcionServicesIniciativa {
		return new LinkedList<>(perfiles.values());
	}

	public List<Perfil> consultarPerfilPorRol(String rol) throws ExcepcionServicesIniciativa {
		ArrayList<Perfil> perfilesPorRol = new ArrayList<>();
		for(Perfil perfil: new LinkedList<>(perfiles.values())) {
			if(roles.contains(perfil.getRol())) perfilesPorRol.add(perfil);
		}
		return perfilesPorRol;
	}

	public List<Perfil> consultarPerfilPorArea(String area) throws ExcepcionServicesIniciativa {
		ArrayList<Perfil> perfilesPorArea = new ArrayList<>();
		for(Perfil perfil: new LinkedList<>(perfiles.values())) {
			if(perfil.getArea().equals(area)) perfilesPorArea.add(perfil);
		}
		return perfilesPorArea;
	}
	
	private void poblar() {
		Rol r1 = new Rol("Administrador",5);
		Rol r2 = new Rol("Personal PMO",4);
		Rol r3 = new Rol("Proponente",3);
		Rol r4 = new Rol("Publico",2);
		
		roles.add(r1);
		roles.add(r2);
		roles.add(r3);
		roles.add(r4);
		
		Perfil p1 = new Perfil(r1,"primero@mail","nombre 1", null,null,"area 1");
		Perfil p2 = new Perfil(r2,"segundo@mail","nombre 2", null,null,"area 2");
		Perfil p3 = new Perfil(r3,"tercero@mail","nombre 3", null,null,"area 3");
		Perfil p4 = new Perfil(r4,"cuarto@mail","nommbre 4", null,null,"area 4");
		
		perfiles.put("primero@mail", p1);
		perfiles.put("segundo@mail", p2);
		perfiles.put("tercero@mail", p3);
		perfiles.put("cuarto@mail", p4);
		
		List<String> palabrasClave = new ArrayList<String>();
		palabrasClave.add("Remodelacion");
		palabrasClave.add("Ampliacion");
		palabrasClave.add("Aulas");
		palabrasClave.add("campus");
		palabrasClave.add("Kioscos");
		
		Iniciativa i1 = new Iniciativa(1,palabrasClave.subList(0, 2) , null, null, 
				null , "idea 1", "En espera de revision", p2, 
				0, "Descripci�n",  java.sql.Date.valueOf("2018-01-01"));
		Iniciativa i2 = new Iniciativa(2,palabrasClave.subList(1, 3) , null, null, 
						null , "idea 1", "En espera de revision", p2, 
						0, "Descripci�n",  java.sql.Date.valueOf("2018-01-01"));
		Iniciativa i3 = new Iniciativa(3,palabrasClave.subList(2,4) , null, null, 
						null , "idea 1", "En espera de revision", p2, 
						0, "Descripci�n",  java.sql.Date.valueOf("2018-01-01"));
		
		iniciativas.add(i1);
		iniciativas.add(i2);
		iniciativas.add(i3);
	}
	
	@Override
	public Iniciativa consultarIniciativa(int id) throws ExcepcionServicesIniciativa {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarLogin(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Iniciativa> consultarIniciativasPorArea(String area) throws ExcepcionServicesIniciativa {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarEstadoDeLaIniciativa(Iniciativa iniciativa, String estado) throws ExcepcionServicesIniciativa {
		// TODO Auto-generated method stub
		
	}
	public void agregarInteresAIniciativa(int ini, String perfil) throws ExcepcionServicesIniciativa {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarVoluntadAIniciativa(int ini, String perfil) throws ExcepcionServicesIniciativa {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Iniciativa> consultarIniciativaPorPerfil(String perfil) throws ExcepcionServicesIniciativa {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void asignarRolAPerfil(Perfil perfil, String rol) {
		// TODO Auto-generated method stub
		
	}

}
