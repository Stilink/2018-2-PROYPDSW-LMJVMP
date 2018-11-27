package PROYPDSW.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import static org.quicktheories.QuickTheory.qt;

import com.google.inject.Inject;

import PROYPDSW.samples.services.ServicesIniciativa;


public class servicesIniciativaTest extends TestBase{
	@Inject
	ServicesIniciativa services;
	@Test
	public void deberiaResgistrarIniciativa() throws SQLException{
		qt().forAll(IniciativasGenerador.iniciativaGen()).check((in)
				->{
					return true;
				}
				);

    }
	@Test
	public void deberiaConsultarTodasLasIniciativas() throws SQLException{

    }
	@Test
	public void deberiaConsultarPerfi() throws SQLException{

    }
	@Test
	public void deberiaModificarEstadoDeIniciativa() throws SQLException{

    }
}
