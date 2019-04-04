package com.arteysoft.hbn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

class HibernateConfiguration {
    public SessionFactory configure() {
        Configuration configuracion = new Configuration();
        
        configuracion.setProperty("hibernate.connection.url",
                "jdbc:mysql://127.0.0.1:3306/eventos");
        configuracion.setProperty("hibernate.connection.user","root");
        configuracion.setProperty("hibernate.connection.password", "");
        configuracion.setProperty("hibernate.connection.driver_class", 
                                "com.mysql.jdbc.Driver");
        configuracion.setProperty("hibernate.dialect", 
                                "org.hibernate.dialect.MySQL5Dialect");
        configuracion.setProperty("hibernate.show_sql", "true");
       
        StandardServiceRegistryBuilder rb = 
                new StandardServiceRegistryBuilder().applySettings(configuracion.getProperties());
        SessionFactory factory = configuracion.buildSessionFactory(rb.build());
        
        return factory;
    }
}

public class App 
{
    public static void main( String[] args )
    {
        HibernateConfiguration hibernateConfiguration = new 
            HibernateConfiguration();
        
        SessionFactory sessFac = hibernateConfiguration.configure();
        
        Session session = sessFac.openSession();
        sessFac.close();
    }
}
