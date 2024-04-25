package de.wind_erleben;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ejb.DependsOn;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Startup
@Singleton
@DependsOn("DBMigration")
public class Scheduler {

    final private Logger logger = Logger.getLogger(Scheduler.class.getName());

    @Inject
    private DataScrapperProcessor dsp;

    @Schedule(hour = "*", minute = "*", second = "0,30")
    public void programmaticTimeout() {
        try {
            dsp.downloadAndStoreData();
        } catch (final Throwable e) {
            logger.log(Level.WARNING, "Fehler im Scheduler", e);
        }
    }
}
