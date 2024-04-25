package de.wind_erleben;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "newest", query = "SELECT dvu FROM DataValuesUff dvu ORDER BY dvu.websiteTime DESC"),
    @NamedQuery(name = "checkIfTimestampExists", query = "SELECT dvu FROM DataValuesUff dvu WHERE dvu.websiteTime = :timestamp")
})
@Entity
public class DataValuesUff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime websiteTime;
    private LocalDateTime insertionTime = LocalDateTime.now();
    private double photovoltaik;
    private double stromverbrauch;
    private double stadtwindanlage;
    private double windrichtung;
    private double windgeschwindigkeit;
    private double pitch;
    private double rotorGeschwindigkeit;
    private double drehungGondel;
    private double leistungELadestation;
    private double batterieLeistung;
    private double ladezustand;
    private double batteriespannung;
    private double rlmPhotovoltaik;
    private double slpPhotovoltaik;
    private double blockheizkraftwerk;
    private double strombezugMDNUffenheim;
    private double stromrueckspeisungMDNUffenheim;
    private double gesamterzeugung;
    private double bezug;
    
    public LocalDateTime getWebsiteTime() {
        return websiteTime;
    }
    public void setWebsiteTime(LocalDateTime websiteTime) {
        this.websiteTime = websiteTime;
    }
    public LocalDateTime getinsertionTime(){
        return insertionTime;
    }
    public double getPhotovoltaik() {
        return photovoltaik;
    }
    public void setPhotovoltaik(double photovoltaik) {
        this.photovoltaik = photovoltaik;
    }
    public double getStromverbrauch() {
        return stromverbrauch;
    }
    public void setStromverbrauch(double stromverbrauch) {
        this.stromverbrauch = stromverbrauch;
    }
    public double getStadtwindanlage() {
        return stadtwindanlage;
    }
    public void setStadtwindanlage(double stadtwindanlage) {
        this.stadtwindanlage = stadtwindanlage;
    }
    public double getWindrichtung() {
        return windrichtung;
    }
    public void setWindrichtung(double windrichtung) {
        this.windrichtung = windrichtung;
    }
    public double getWindgeschwindigkeit() {
        return windgeschwindigkeit;
    }
    public void setWindgeschwindigkeit(double windgeschwindigkeit) {
        this.windgeschwindigkeit = windgeschwindigkeit;
    }
    public double getPitch() {
        return pitch;
    }
    public void setPitch(double pitch) {
        this.pitch = pitch;
    }
    public double getRotorGeschwindigkeit() {
        return rotorGeschwindigkeit;
    }
    public void setRotorGeschwindigkeit(double rotorGeschwindigkeit) {
        this.rotorGeschwindigkeit = rotorGeschwindigkeit;
    }
    public double getDrehungGondel() {
        return drehungGondel;
    }
    public void setDrehungGondel(double drehungGondel) {
        this.drehungGondel = drehungGondel;
    }
    public double getLeistungELadestation() {
        return leistungELadestation;
    }
    public void setLeistungELadestation(double leistungELadestation) {
        this.leistungELadestation = leistungELadestation;
    }
    public double getBatterieLeistung() {
        return batterieLeistung;
    }
    public void setBatterieLeistung(double batterieLeistung) {
        this.batterieLeistung = batterieLeistung;
    }
    public double getLadezustand() {
        return ladezustand;
    }
    public void setLadezustand(double ladezustand) {
        this.ladezustand = ladezustand;
    }
    public double getBatteriespannung() {
        return batteriespannung;
    }
    public void setBatteriespannung(double batteriespannung) {
        this.batteriespannung = batteriespannung;
    }
    public double getRlmPhotovoltaik() {
        return rlmPhotovoltaik;
    }
    public void setRlmPhotovoltaik(double rlmPhotovoltaik) {
        this.rlmPhotovoltaik = rlmPhotovoltaik;
    }
    public double getSlpPhotovoltaik() {
        return slpPhotovoltaik;
    }
    public void setSlpPhotovoltaik(double slpPhotovoltaik) {
        this.slpPhotovoltaik = slpPhotovoltaik;
    }
    public double getBlockheizkraftwerk() {
        return blockheizkraftwerk;
    }
    public void setBlockheizkraftwerk(double blockheizkraftwerk) {
        this.blockheizkraftwerk = blockheizkraftwerk;
    }
    public double getStrombezugMDNUffenheim() {
        return strombezugMDNUffenheim;
    }
    public void setStrombezugMDNUffenheim(double strombezugMDNUffenheim) {
        this.strombezugMDNUffenheim = strombezugMDNUffenheim;
    }
    public double getStromrueckspeisungMDNUffenheim() {
        return stromrueckspeisungMDNUffenheim;
    }
    public void setStromrueckspeisungMDNUffenheim(double stromrueckspeisungMDNUffenheim) {
        this.stromrueckspeisungMDNUffenheim = stromrueckspeisungMDNUffenheim;
    }
    public double getGesamterzeugung() {
        return gesamterzeugung;
    }
    public void setGesamterzeugung(double gesamterzeugung) {
        this.gesamterzeugung = gesamterzeugung;
    }
    public double getBezug() {
        return bezug;
    }
    public void setBezug(double bezug) {
        this.bezug = bezug;
    }    
}
