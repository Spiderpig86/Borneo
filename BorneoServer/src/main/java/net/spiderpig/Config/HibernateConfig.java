package net.spiderpig.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Enable configuration for Spring to manage beans, component scan for
 * location of entity objects, and enable transaction management to allow
 * Spring to manage transactions.
 * This is needed so we can write standard SQL queries and Spring will
 * translate them into the needed dialects of SQL (different systems may
 * differ slightly in syntax)
 */

@Configuration // Enables bean management by Spring
@ComponentScan(basePackages = {"net.spiderpig.DataTransferObjects"}) //
// Location of entities used in Spring
@EnableTransactionManagement // Allow Spring to manage transactions for us
public class HibernateConfig {

    /* Database properties (H2) */
    private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/borneodb";
    private final static String DATABASE_DRIVER = "org.h2.Driver"; // DB driver
    private final static String DATABASE_DIALECT = "org.hibernate.dialect" +
            ".H2Diaclect";
    private final static String DATABASE_USERNAME = "sa";
    private final static String DATABASE_PASSWORD = "";

    /**
     * Returns a data source bean that allows us to connect to a database
     * using dbcp2
     * @return
     */
    @Bean // Annotation for automatically creating a bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource(); // Create it

        /* Fill data source properties for connection */
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;
    }

    /**
     * Returns a session builder factory with the given data source attribues
     * we passed in
     * @param dataSource
     * @return
     */
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder
                (dataSource); // Build a session factory with data properties

        builder.addProperties(getHibernateProperties());
        builder.scanPackages("net.spiderpig.DataTransferObjects"); // Scan
        // our data transfer object package and add all the classes in them
        // as entities

        return builder.buildSessionFactory(); // Return a session
        // factory instance

    }

    /**
     * Return all Hibernate properties needed for session factory
     * @return
     */
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", DATABASE_DIALECT); // Set the
        // dialect
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }

    /**
     * Create a transaction manager using our session factory to allow Spring
     * to manage it
     * @param sessionFactory
     * @return
     */
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new
                HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

}
