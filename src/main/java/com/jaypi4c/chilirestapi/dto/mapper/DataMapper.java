package com.jaypi4c.chilirestapi.dto.mapper;

import com.jaypi4c.chilirestapi.dto.DataDto;
import com.jaypi4c.chilirestapi.model.Data;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper for easy conversion between {@link DataDto} and {@link Data} objects.
 *
 * @author Jonas Pohl
 */
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataMapper {

    /**
     * Converts a {@link Data} class object to an {@link DataDto} object.
     *
     * @param data the data to be converted to DataDto
     * @return the dataDto holding the same information as the data object
     */

    public static DataDto toDataDto(Data data) {
        return new DataDto()
                .setId(data.getId())
                .setTemperature(data.getTemperature())
                .setRelativeHumidity(data.getRelativeHumidity())
                .setWaterlevel(data.getWaterlevel());
    }

    /**
     * Converts a {@link DataDto} class object to an {@link Data} object.
     *
     * @param data the dataDto to be converted to Data
     * @return the data object holding the same information as the datadto object
     */
    public static Data toData(DataDto data) {
        Data d = new Data();
        d.setId(data.getId());
        d.setWaterlevel(data.getWaterlevel());
        d.setTemperature(data.getTemperature());
        d.setRelativeHumidity(data.getRelativeHumidity());
        return d;
    }

}
