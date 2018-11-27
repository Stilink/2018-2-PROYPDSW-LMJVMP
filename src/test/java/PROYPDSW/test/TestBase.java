package PROYPDSW.test;

import org.junit.Before;
import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import PROYPDSW.samples.services.ServicesIniciativa;
import PROYPDSW.samples.services.impl.ServicesIniciativaImpl;

public class TestBase {
    protected Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId("test");
                setClassPathResource("mybatis-config-h2.xml");
                
                bind(ServicesIniciativa.class).to(ServicesIniciativaImpl.class);
            }
    });
    
    @Before
    public void setup() {
        injector.injectMembers(this);
    }
}
