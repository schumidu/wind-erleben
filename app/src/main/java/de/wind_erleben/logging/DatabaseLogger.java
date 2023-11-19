package de.wind_erleben.logging;

import de.wind_erleben.DataValuesUff;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class DatabaseLogger {

    @PersistenceContext
    EntityManager em;

    public void logDuplicateValue(final DataValuesUff dvu){
        final WindDatabaseLog wdl = new WindDatabaseLog(
            Level.DUPLICATE_VALUE,
            "Datensatz von " + dvu.getWebsiteTime() + " bereits in Datenbank"
        );
        em.persist(wdl);
    }
    
}
