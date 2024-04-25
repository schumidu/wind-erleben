package de.wind_erleben;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.flywaydb.core.Flyway;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Startup
@Singleton
public class DBMigration {

    final private Logger logger = Logger.getLogger(DBMigration.class.getName());

    @PostConstruct
    void postConstruct(){
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://mysqldbtest:3306/exampledb?useSSL=false", "exampleuser", "examplepass").locations("de/wind_erleben/migration").load();
        flyway.migrate();
        for(int i = 0; i < 100; i++){
            logger.log(Level.WARNING, "DB-Migration");
        }
    }
    
}
