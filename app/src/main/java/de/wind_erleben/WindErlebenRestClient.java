package de.wind_erleben;

import de.wind_erleben.jsonstrukture.MainObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

@ApplicationScoped
public class WindErlebenRestClient {

    @Inject
    private DataFormatKonverter dataFormatKonverter;

    public MainObject getFullData(){
        final Client client = ClientBuilder.newClient();
        return client.target("https://www.wind-erleben.de/ajaxdata/data/all")
            .request()
            .get(MainObject.class);
    }

    public DataValuesUff getData(){
        return dataFormatKonverter.from(this.getFullData());
    }
}
