package de.wind_erleben;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import de.wind_erleben.jsonstrukture.MainObject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataFormatKonverter {

    public DataValuesUff from(final MainObject mo){
        final DataValuesUff dvu = new DataValuesUff();
        dvu.setWebsiteTime( LocalDateTime.parse(mo.getData().getTimestamp(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        final Map<String, Double> values = mo.getData().getValues();
        dvu.setPhotovoltaik(values.get("20"));
        dvu.setStromverbrauch(values.get("21"));
        dvu.setStadtwindanlage(values.get("26"));
        dvu.setWindrichtung(values.get("27"));
        dvu.setWindgeschwindigkeit(values.get("28"));
        dvu.setPitch(values.get("29"));
        dvu.setRotorGeschwindigkeit(values.get("30"));
        dvu.setDrehungGondel(values.get("31"));
        dvu.setLeistungELadestation(values.get("32"));
        dvu.setBatterieLeistung(values.get("33"));
        dvu.setLadezustand(values.get("34"));
        dvu.setBatteriespannung(values.get("35"));
        dvu.setRlmPhotovoltaik(values.get("36"));
        dvu.setSlpPhotovoltaik(values.get("37"));
        dvu.setBlockheizkraftwer(values.get("38"));
        dvu.setStrombezugMDNUffenheim(values.get("39"));
        dvu.setStromrueckspeisungMDNUffenheim(values.get("40"));
        dvu.setGesamterzeugung(values.get("41"));
        dvu.setBezug(values.get("42"));
        return dvu;
    }
    
}
