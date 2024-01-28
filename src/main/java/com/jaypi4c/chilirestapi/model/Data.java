package com.jaypi4c.chilirestapi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Data object for the database. It contains information that are stored in the
 * database.
 *
 * @author Jonas Pohl
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Data {

    @Id
    @GeneratedValue
    private UUID id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updated;

    private float temperature;
    private float relativeHumidity;
    private float waterlevel;


    public Data(float temperature, float relativeHumidity, float waterlevel) {
        this.temperature = temperature;
        this.relativeHumidity = relativeHumidity;
        this.waterlevel = waterlevel;
    }

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
        updated = created;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

}
