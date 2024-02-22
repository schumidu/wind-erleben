package de.wind_erleben;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WindErlebenRestClientConfig {

    private String protokoll = "https";
    private String host = "wind-erleben.de";
    private String port = "";

    @PostConstruct
    void postConstruct(){
        try(InputStream input = new FileInputStream(System.getProperty("user.dir") + "/config/client.properties")){
            Properties prop = new Properties();
            prop.load(input);
            this.protokoll = prop.getProperty("protokoll", "https");
            this.host = prop.getProperty("host", "wind-erleben.de");
            this.port = prop.getProperty("port", "");
            System.out.println();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public WindErlebenRestClientConfig(String protokoll, String host, String port, String url) {
        this.protokoll = protokoll;
        this.host = host;
        this.port = port;
    }

    public WindErlebenRestClientConfig() {
    }

    public String getURLBase(){
        return this.getProtokoll() + "://" + this.getHost() + ":" + this.getPort();
    }

    public String getProtokoll() {
        return protokoll;
    }

    public void setProtokoll(String protokoll) {
        this.protokoll = protokoll;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
