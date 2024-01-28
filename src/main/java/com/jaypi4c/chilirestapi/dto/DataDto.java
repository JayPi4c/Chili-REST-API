package com.jaypi4c.chilirestapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.UUID;

/**
 * @author Jonas Pohl
 */
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DataDto {

    private UUID id;

    /*
     * User data. Values are being set by the user of the endpoint.
     */
    private float temperature;
    private float relativeHumidity;
    private float waterlevel;

    public DataDto(float temperature, float relativeHumidity, float waterlevel) {
        this.temperature = temperature;
        this.relativeHumidity = relativeHumidity;
        this.waterlevel = waterlevel;
    }

}
