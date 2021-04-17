package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.dao.mybatis.MyBatisCategoriesDAO;
import edu.eci.cvds.dao.mybatis.MyBatisNeedsDAO;
import edu.eci.cvds.dao.mybatis.MyBatisUserDAO;
import edu.eci.cvds.services.Impl.CategoriesServicesImpl;
import edu.eci.cvds.services.Impl.NeedsServicesImpl;
import edu.eci.cvds.services.Impl.UserServicesImpl;
import edu.eci.cvds.view.NeedsServicesBean;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.UserServices;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
                bind(CategoriesDAO.class).to(MyBatisCategoriesDAO.class);
                bind(NeedsDAO.class).to(MyBatisNeedsDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(CategoriesServices.class).to(CategoriesServicesImpl.class);
                bind(NeedsServices.class).to(NeedsServicesImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}