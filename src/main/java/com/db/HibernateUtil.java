package com.db;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.Expense;
import com.entity.User;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory==null) {
			Configuration cfg = new Configuration();
			Properties properties =  new Properties();
			
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "Jaggudada@27");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.SHOW_SQL, true);
			
			properties.put(Environment.USE_SECOND_LEVEL_CACHE, true);
			properties.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
			
			cfg.setProperties(properties);
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Expense.class);
			
			ServiceRegistry sr =  new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			sessionFactory =  cfg.buildSessionFactory(sr);

		}
		
		return sessionFactory;
	}
}
