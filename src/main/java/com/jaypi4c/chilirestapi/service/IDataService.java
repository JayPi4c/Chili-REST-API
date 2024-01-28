package com.jaypi4c.chilirestapi.service;

import com.jaypi4c.chilirestapi.dto.DataDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

/**
 * Interface for the data service. This interface is used to define the operations supported by the data service.
 *
 * @author Jonas Pohl
 */
public interface IDataService {

    default ResponseEntity<List<DataDto>> getAllData() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Void> save(List<DataDto> newData) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<DataDto> get(UUID id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Void> replace(DataDto newData, UUID id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Void> delete(UUID id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
