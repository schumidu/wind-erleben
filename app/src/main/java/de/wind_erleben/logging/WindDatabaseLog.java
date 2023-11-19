package de.wind_erleben.logging;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WindDatabaseLog implements Serializable{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;
    final private LocalDateTime insertionTime = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(length = 300)
    private String message;
    
    public WindDatabaseLog() {
    }

    public WindDatabaseLog(Level level, String message) {
        this.level = level;
        this.message = message;
    }

    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
}
