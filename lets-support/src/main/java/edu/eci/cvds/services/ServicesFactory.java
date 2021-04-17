package edu.eci.cvds.services;

import com.google.inject.Injector;
import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.dao.mybatis.MyBatisCategoriesDAO;
import edu.eci.cvds.dao.mybatis.MyBatisNeedsDAO;
import edu.eci.cvds.dao.mybatis.MyBatisUserDAO;
import edu.eci.cvds.services.Impl.CategoriesServicesImpl;
import edu.eci.cvds.services.Impl.NeedsServicesImpl;
import edu.eci.cvds.services.Impl.UserServicesImpl;
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
                bind(CategoriesDAO.class).to(MyBatisCategoriesDAO.class);
                bind(NeedsDAO.class).to(MyBatisNeedsDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(CategoriesServices.class).to(CategoriesServicesImpl.class);
                bind(NeedsServices.class).to(NeedsServicesImpl.class);
            }

        });
    }

    private ServicesFactory(){
        optInjector = Optional.empty();
    }

    public UserServices getServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(UserServices.class);
    }
 
    public UserServices getServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(UserServices.class);
    }
 
    public static ServicesFactory getInstance(){
        return instance;
    }
}
