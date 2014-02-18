package com.coe7.managebean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.ejb.Ejb3Configuration;

import com.coe7.domain.Product;
import com.coe7.domain.User;

/**
 * SQL Creator for Tables according to JPA/Hibernate annotations.
 *
 * Use:
 *
 * {@link #createTablesScript()} To create the table creationg script
 *
 * {@link #dropTablesScript()} to create the table destruction script
 * 
 */
public class SqlTableCreator {

    private final Configuration hibernateConfiguration;
    private final Properties dialectProps;

    public static void main(String[] argv) {
    	List<Class> test = new ArrayList<Class>();
    	test.add(User.class);
    	SqlTableCreator abc = new SqlTableCreator(test);
    	System.out.println(abc.createTablesScript());
    }
    
    
	public SqlTableCreator(final Collection<Class> entities) {

    	final Ejb3Configuration ejb3Configuration = new Ejb3Configuration();
    	for (final Class entity : entities) {
    		ejb3Configuration.addAnnotatedClass(entity);
    	}

    	dialectProps = new Properties();
    	dialectProps.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

    	hibernateConfiguration =  ejb3Configuration.getHibernateConfiguration();
    }

    /**
     * Create the SQL script to create all tables.
     * 
     * @return A {@link String} representing the SQL script.
     */
    public String createTablesScript() {
    	final StringBuilder script = new StringBuilder();

    	final String[] creationScript = hibernateConfiguration.generateSchemaCreationScript(Dialect
    			.getDialect(dialectProps));
    	for (final String string : creationScript) {
    		script.append(string).append(";\n");
    	}
    	script.append("\ngo\n\n");

    	return script.toString();
    }

    /**
     * Create the SQL script to drop all tables.
     * 
     * @return A {@link String} representing the SQL script.
     */
    public String dropTablesScript() {
    	final StringBuilder script = new StringBuilder();

    	final String[] creationScript = hibernateConfiguration.generateDropSchemaScript(Dialect
    			.getDialect(dialectProps));
    	for (final String string : creationScript) {
    		script.append(string).append(";\n");
    	}
    	script.append("\ngo\n\n");

    	return script.toString();
    }
}
