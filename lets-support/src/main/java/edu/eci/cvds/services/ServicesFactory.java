package edu.eci.cvds.services;

import com.google.inject.Injector;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

public class ServicesFactory {
    private static final ServicesFactory instance = new ServicesFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String path) {
        return createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId(env);
                setClassPathResource(path);
            }

        });
    }

    private ServicesFactory(){
        optInjector = Optional.empty();
    }

    public Services getServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(Services.class);
    }
 
    public Services getServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(Services.class);
    }
 
    public static ServicesFactory getInstance(){
        return instance;
    }
}
