package PROYPDSW.test;

import java.sql.Date;

import org.quicktheories.core.*;
import org.quicktheories.generators.*;

import PROYPDSW.samples.entities.Iniciativa;
import PROYPDSW.samples.entities.Perfil;

public class IniciativasGenerador {
	public static Gen<Iniciativa> iniciativaGen(){
		return genId().zip(genNombre(),
				genEstado(),
				PerfilGenerador.perfilGen(),
				genDescripcion(),
				genFecha(),
				(id,nombre,estado,creador,descripcion,fC) ->{ 
					new Iniciativa(id,nombre,estado,creador,descripcion,fC);
					});
	}
	public static Gen<Integer> genId(){
		return SourceDSL.integers().between(-1000,100000);
	}
	public static Gen<String> genNombre(){
		return null;
	}
	public static Gen<String> genEstado(){
		return null;
	}
	public static Gen<String> genDescripcion(){
		return strings().basicLatinAlphabet();
	}
	public static Gen<Date> genFecha(){
		return (Gen<Date>) SourceDSL.localDates();
	}
}