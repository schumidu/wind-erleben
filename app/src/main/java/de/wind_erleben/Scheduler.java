package de.wind_erleben;

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

    @Inject
    private DataScrapperProcessor dsp;
    @Schedule(hour = "*", minute = "*", second = "0,30")
    public void programmaticTimeout(Timer timer){
        try{
            System.out.println("Neuer Programmdurchlauf");
            dsp.downloadAndStoreData();
        }catch(final Throwable e){
            // e.printStackTrace(); //TODO ersetzen durch Log
            System.out.println("Fehlerbehandlung");
        }
    }
}
