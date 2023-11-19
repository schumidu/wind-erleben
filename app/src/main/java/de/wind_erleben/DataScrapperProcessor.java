package de.wind_erleben;

import java.util.List;
import java.util.logging.Logger;

import de.wind_erleben.logging.DatabaseLogger;
import de.wind_erleben.logging.WindDatabaseLog;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DataScrapperProcessor {

    @PersistenceContext
    EntityManager em;

    final private Logger logger = Logger.getLogger(DataScrapperProcessor.class.getName());

    @Inject
    private WindErlebenRestClient dataScrapper;

    @Inject
    private DatabaseLogger dl;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void downloadAndStoreData(){
        final DataValuesUff dvu = dataScrapper.getData();
        if(!checkIfDataAlreadyStored(dvu)){
            em.persist(dvu);
            logger.info("Datensatz erfolgreich geschrieben " + dvu.getWebsiteTime());
        }else{
            dl.logDuplicateValue(dvu);
            logger.warning("Datensatz existiert bereits. Satzzeit: " + dvu.getWebsiteTime());
        }
    }

    private boolean checkIfDataAlreadyStored(final DataValuesUff dvu){
        final Query q = em.createNamedQuery("checkIfTimestampExists");
        q.setParameter("timestamp", dvu.getWebsiteTime());
        List<DataValuesUff> resultList = q.getResultList();
        return resultList.size() == 1;
    }
}
