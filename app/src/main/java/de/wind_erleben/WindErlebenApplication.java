package de.wind_erleben;

import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("api")
public class WindErlebenApplication extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(
            DataValuesUffResource.class,
            WindErlebenRestConfigResource.class
            );
    }
    
    

}
