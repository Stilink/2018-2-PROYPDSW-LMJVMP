package PROYPDSW.samples.services;

import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Injector;

import PROYPDSW.sampleprj.dao.ComentarioDAO;
import PROYPDSW.sampleprj.dao.IniciativaDAO;
import PROYPDSW.sampleprj.dao.PerfilDAO;
import PROYPDSW.sampleprj.dao.mybatis.MyBATISIniciativaDAO;
import PROYPDSW.sampleprj.dao.mybatis.*;
import PROYPDSW.samples.services.impl.ServicesIniciativaImpl;

import org.mybatis.guice.XMLMyBatisModule;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import static com.google.inject.Guice.createInjector;

public class ServicesIniciativaFactory {
	private static ServicesIniciativaFactory instance= new ServicesIniciativaFactory();
	private static Injector injector;
	private static Injector testInjector;
	public ServicesIniciativaFactory() {
		injector = createInjector(new XMLMyBatisModule(){
			@Override
			protected void initialize() {
				setEnvironmentId("development");
				install(JdbcHelper.PostgreSQL);
				setClassPathResource("mybatis-config.xml");
				bind(ServicesIniciativa.class).to(ServicesIniciativaImpl.class);
				bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
				bind(PerfilDAO.class).to(MyBATISPerfilDAO.class);
				bind(ComentarioDAO.class).to(MyBATISComentarioDAO.class);
			}
		}	
		);
		testInjector = createInjector(new XMLMyBatisModule(){
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setClassPathResource("mybatis-config-h2.xml");
			}
		}	
		);
		
        
	}
	public ServicesIniciativa getServicesIniciativa() {
		return injector.getInstance(ServicesIniciativa.class);
	}
	public ServicesIniciativa getServicesIniciativaTesting() {
		return testInjector.getInstance(ServicesIniciativa.class);
	}
	public static ServicesIniciativaFactory getInstance() {
		return instance;
	}
}
