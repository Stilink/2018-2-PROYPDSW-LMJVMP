package PROYPDSW.test;

import java.sql.Date;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;


import static org.quicktheories.generators.SourceDSL.*;


import PROYPDSW.samples.entities.Iniciativa;

public class IniciativasGenerador {
	public static Gen<Iniciativa> iniciativaGen(){
		return in -> new Iniciativa(
				genId().generate(in),
				genNombre().generate(in),
				genEstado().generate(in),
				PerfilGenerador.perfilGen().generate(in),
				genDescripcion().generate(in),
				genFecha().generate(in)				
				);
	}
	public static Gen<Integer> genId(){
		return integers().between(-1000,100000);
	}
	public static Gen<String> genNombre(){
		return null;
	}
	public static Gen<String> genEstado(){
		return null;
	}
	public static Gen<String> genDescripcion(){
		return (Gen<String>) strings().basicLatinAlphabet();
	}
	public static Gen<Date> genFecha(){
		return (Gen<Date>) localDates();
	}
}