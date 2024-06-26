package de.wind_erleben;

import java.util.concurrent.TimeUnit;

import de.wind_erleben.jsonstrukture.MainObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

@ApplicationScoped
public class WindErlebenRestClient {

    @Inject
    private DataFormatKonverter dataFormatKonverter;

    @Inject
    WindErlebenRestClientConfig cfg;

    public MainObject getFullData(){
        final Client client = ClientBuilder
            .newBuilder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build();
        return client.target(cfg.getURLBase() + "/ajaxdata/data/all")
            .request()
            .get(MainObject.class);
    }

    public DataValuesUff getData(){
        return dataFormatKonverter.from(this.getFullData());
    }
}
