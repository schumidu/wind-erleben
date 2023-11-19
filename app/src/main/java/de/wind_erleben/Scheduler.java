package de.wind_erleben;

import java.util.logging.Logger;

import java.util.logging.Level;

import de.wind_erleben.jsonstrukture.MainObject;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Schedules;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Timer;
import jakarta.inject.Inject;

@Startup
@Singleton
public class Scheduler {

    final private Logger logger = Logger.getLogger(Scheduler.class.getName());

    @Inject
    private DataScrapperProcessor dsp;

    @Schedule(hour = "*", minute = "*", second = "0,30")
    public void programmaticTimeout(){
        try{
            dsp.downloadAndStoreData();
        }catch(final Throwable e){
            logger.log(Level.WARNING, "Fehler im Scheduler", e);
        }
    }

    @Schedule(hour = "12", minute = "0", second = "0")
    public void dailyReport(){
        try{
            logger.log(Level.INFO, "Test");
        }catch(final Throwable e){
            logger.log(Level.WARNING, "Fehler in täglicher Statusverarbeitung", e);
        }
    }
}
