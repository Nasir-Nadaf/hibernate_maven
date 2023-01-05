package com.controller.hibernateconfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.comtroller.entity.Product;

public class HibernateConfi {
public static SessionFactory congif() {
	Configuration config =new Configuration();
	config.configure();
	config.addAnnotatedClass(Product.class);
	SessionFactory sessionfact=config.buildSessionFactory();
	
	return sessionfact;
}
}
