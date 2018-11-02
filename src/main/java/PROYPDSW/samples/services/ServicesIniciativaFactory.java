package PROYPDSW.samples.services;

import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Injector;
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
				install(JdbcHelper.PostgreSQL);
				setClassPathResource("mybatis-config.xml");
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
