package de.wind_erleben;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Startup
@Singleton
public class DBMigration {

    final private Logger logger = Logger.getLogger(DBMigration.class.getName());
    
    @PostConstruct
    void postConstruct(){

        try{

            Flyway flyway = Flyway
            .configure()
            .dataSource(
                "jdbc:mysql://" 
                + System.getenv("DATABASE_HOST") + ": "
                + System.getenv("DATABASE_PORT") + "/ "
                + System.getenv("DATABASE_NAME") + "?useSSL=false",
                System.getenv("DATABASE_USER"),
                System.getenv("DATABASE_PASSWORD")).locations("de/wind_erleben/migration").load();
                MigrateResult migrate = flyway.migrate();
                logger.log(Level.WARNING, createLogMessage(migrate));
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getStackTrace().toString());
        }

    }

    private String createLogMessage(final MigrateResult migrateResult){
        return "initialSchemaVersion: " + migrateResult.initialSchemaVersion + 
            "\ntargetSchemaVersion: " + migrateResult.targetSchemaVersion + 
            "\nschemaName: " + migrateResult.schemaName + 
            "\nmigrations: " + migrateResult.migrations.stream().map(it -> it.description).collect(Collectors.joining("\n\t")) +
            "\nmigrationsExecuted: " + migrateResult.migrationsExecuted + 
            "\nsuccess: " + migrateResult.success + 
            "\nflywayVersion: " + migrateResult.flywayVersion + 
            "\ndatabase: " + migrateResult.database + 
            "\nwarnings" + migrateResult.warnings.stream().collect(Collectors.joining("\n\t"));
    }
    
}
