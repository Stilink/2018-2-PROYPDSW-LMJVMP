package PROYPDSW.samples.services.client;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import PROYPDSW.samples.entities.Comentario;
import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;
import PROYPDSW.samples.services.ServicesIniciativa;
import PROYPDSW.samples.services.ServicesIniciativaFactory;

public class MyBatisExecution{

	public static void main(String[] args) throws Exception{
		System.out.println("Solicitud de servicios:");
		ServicesIniciativa sa = ServicesIniciativaFactory.getInstance().getServicesIniciativa();
		System.out.println("validar login");
		System.out.println(sa.validarLogin("michael.preciado@mail.escuelaing.edu.co", "123"));
		System.out.println("Agregamos perfiles: ");
		Perfil michael = sa.consultarPerfil("michael.preciado@mail.escuelaing.edu.co");
		System.out.println(michael.toString());
		System.out.println("Crear iniciativa: ");
		Iniciativa ini1 = new Iniciativa(1,"Iniciativa 1, los origenes", "En espera de revision", michael,"Hola, buenas tardes.", new Date(System.currentTimeMillis()) );
		//sa.agregarIniciativa(ini1);
		Iniciativa consulta1 = sa.consultarIniciativa(ini1.getId());
		System.out.println("Iniciativa agregada: "+consulta1.toString());
		System.out.println("Palabras claves de la iniciativa: "+consulta1.getPalabrasClave().toString());
		System.out.println("Consultar todas las iniciativas: ");
		List<Iniciativa> consultas = sa.consultarIniciativas();
		for(Iniciativa i: consultas) {
			System.out.println(i.toString());
		}
		System.out.println("Consultar todas las iniciativas en estado 'Proyecto': ");
		List<Iniciativa> consultasPorEstado = sa.consultarIniciativasPorEstado("Proyecto");
		for(Iniciativa i: consultasPorEstado) {
			System.out.println(i.toString());
		}
		System.out.println("Consultar todas las inciativas con palabras clave: 'Entretenimiento','mvp','go go power rangers'");
		ArrayList<String> palabrasClaveAConsultar = new ArrayList<String>();
		palabrasClaveAConsultar.add("Entretenimiento");
		palabrasClaveAConsultar.add("mvp");
		palabrasClaveAConsultar.add("go go power rangers");
		List<Iniciativa> consultasPorPalabrasClave = sa.consultarIniciativasPorPalabrasClave(palabrasClaveAConsultar);
		for(Iniciativa i: consultasPorPalabrasClave) {
			System.out.println(i.toString());
		}
		String areaABuscar = "Ingenieria ambiental";
		System.out.println("Consultar iniciativas por area "+areaABuscar+ ": ");
		List<Iniciativa> consultasPorArea= sa.consultarIniciativasPorArea(areaABuscar);
		for(Iniciativa i: consultasPorArea) {
			System.out.println(i.toString());
		}
		System.out.println("Intentaremos modificar el estado de una iniciativa existente");
		Iniciativa ini = sa.consultarIniciativa(1);
		System.out.println("La iniciativa a consultar es: "+ini.toString());
		sa.modificarEstadoDeLaIniciativa(ini, "Solucionado");
		Iniciativa iniDME = sa.consultarIniciativa(1);
		System.out.println("La iniciativa luego de la modificación, es: " +iniDME.toString() );
		System.out.println("Consultar iniciativas por perfil");
		consultas = sa.consultarIniciativaPorPerfil("michael.preciado@mail.escuelaing.edu.co");
		for(Iniciativa i: consultas) {
			System.out.println(i.toString());
		}
		//sa.agregarInteresAIniciativa(1, "michael.preciado@mail.escuelaing.edu.co");
		//sa.agregarVoluntadAIniciativa(1, "michael.preciado@mail.escuelaing.edu.co");
	}

}
