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
		System.out.println("Agregamos perfiles: ");
		Perfil michael = sa.consultarPerfil("michael.preciado@mail.escuelaing.edu.co");
		System.out.println(michael.toString());
		System.out.println("Crear iniciativa: ");
		Iniciativa ini1 = new Iniciativa(1,"Iniciativa 1, los origenes", "En espera de revision", michael,"Hola, buenas tardes.", new Date(System.currentTimeMillis()) );
		//sa.agregarIniciativa(ini1);
		Iniciativa consulta1 = sa.consultarIniciativa(ini1.getId());
		System.out.println("Iniciativa agregada: "+consulta1.toString());
		System.out.println("Palabras claves de la iniciativa: "+consulta1.getPalabrasClave().toString());

	}

}
