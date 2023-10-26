package de.wind_erleben.jsonstrukture;

import java.util.List;
import java.util.Map;

public class DataObject {

    private String timestamp;
    private String date;
    private String time;
    private Map<String, Double> values;
    private Map<String, SingleSourceObject> dataTypeInfos;
    private List<Integer> dataTypes;
    
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Map<String, Double> getValues() {
        return values;
    }
    public void setValues(Map<String, Double> values) {
        this.values = values;
    }
    public Map<String, SingleSourceObject> getDataTypeInfos() {
        return dataTypeInfos;
    }
    public void setDataTypeInfos(Map<String, SingleSourceObject> dataTypeInfos) {
        this.dataTypeInfos = dataTypeInfos;
    }
    public List<Integer> getDataTypes() {
        return dataTypes;
    }
    public void setDataTypes(List<Integer> dataTypes) {
        this.dataTypes = dataTypes;
    }
    
    @Override
    public String toString() {
        return "DataObject [timestamp=" + timestamp + ", date=" + date + ", time=" + time + ", values=" + values
                + ", dataTypeInfos=" + dataTypeInfos + ", dataTypes=" + dataTypes + "]";
    }

    public String getValuesToString(){
        final StringBuffer str = new StringBuffer();
        str.append("Photovoltaik: " + this.getValues().get("20") + "\n");
        str.append("Stromverbrauch: " + this.getValues().get("21") + "\n");
        str.append("Stadtwindanlage: " + this.getValues().get("26") + "\n");
        str.append("Windrichtung: " + this.getValues().get("27") + "\n");
        str.append("Windgeschwindigkeit: " + this.getValues().get("28") + "\n");
        // str.append("Pitch: " + this.getValues().get("29") + "\n");
        // str.append("Rotor Geschwindigkeit: " + this.getValues().get("30") + "\n");
        // str.append("Drehung der Gondel: " + this.getValues().get("31") + "\n");
        // str.append("Elektrische leistung der E-Ladestation: " + this.getValues().get("32") + "\n");
        // str.append("Laden (negativ) bzw. Entladen (positiv) der Batterie mit bestimmter Leistung: " + this.getValues().get("33") + "\n");
        // str.append("Ladezustand: " + this.getValues().get("34") + "\n");
        // str.append("Batteriespannung: " + this.getValues().get("35") + "\n");
        // str.append("Summe aller RLM Photovoltaik Einspeiser: " + this.getValues().get("36") + "\n");
        // str.append("Summe aller SLP Photovoltaik Einspeiser: " + this.getValues().get("37") + "\n");
        // str.append("Blockheizkraftwerk: " + this.getValues().get("38") + "\n");
        // str.append("Strombezug von der MDN für Uffenheim: " + this.getValues().get("39") + "\n");
        // str.append("Stromrückspeisung an die MDN von Uffenheim: " + this.getValues().get("40") + "\n");
        str.append("Gesamterzeugung: " + this.getValues().get("41") + "\n");
        str.append("Bezug: " + this.getValues().get("42") + "\n");
        return str.toString();
    }
}
