package PROYPDSW.guice;

import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import PROYPDSW.samples.services.impl.ServicesIniciativaImpl;
import PROYPDSW.sampleprj.dao.ComentarioDAO;
import PROYPDSW.sampleprj.dao.IniciativaDAO;
import PROYPDSW.sampleprj.dao.PerfilDAO;
import PROYPDSW.sampleprj.dao.mybatis.MyBATISComentarioDAO;
import PROYPDSW.sampleprj.dao.mybatis.MyBATISIniciativaDAO;
import PROYPDSW.sampleprj.dao.mybatis.MyBATISPerfilDAO;
import PROYPDSW.samples.services.ServicesIniciativa;



public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
            	install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
                bind(ServicesIniciativa.class).to(ServicesIniciativaImpl.class);
                bind(ComentarioDAO.class).to(MyBATISComentarioDAO.class);
                bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
                bind(PerfilDAO.class).to(MyBATISPerfilDAO.class);
                
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}