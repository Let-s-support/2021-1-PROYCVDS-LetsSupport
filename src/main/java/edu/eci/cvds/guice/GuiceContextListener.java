package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.dao.*;
import edu.eci.cvds.dao.mybatis.*;
import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.services.*;
import edu.eci.cvds.services.Impl.*;
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
                bind(RolesDAO.class).to(MyBatisRolesDAO.class);
                bind(StatusDAO.class).to(MyBatisStatusDAO.class);
                bind(MaxiumRequerementsDAO.class).to(MyBatisMaxiumRequerementsDAO.class);
                bind(UserServices.class).to(UserServicesImpl.class);
                bind(CategoriesServices.class).to(CategoriesServicesImpl.class);
                bind(NeedsServices.class).to(NeedsServicesImpl.class);
                bind(RolesServices.class).to(RolesServicesImpl.class);
                bind(StatusServices.class).to(StatusServicesImpl.class);
                bind(MaxiumRequerementsServices.class).to(MaxiumRequerementsServiceImpl.class);

            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}