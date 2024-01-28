package com.jaypi4c.chilirestapi.service.impl;

import com.jaypi4c.chilirestapi.dto.DataDto;
import com.jaypi4c.chilirestapi.dto.mapper.DataMapper;
import com.jaypi4c.chilirestapi.exception.DataNotFoundException;
import com.jaypi4c.chilirestapi.model.Data;
import com.jaypi4c.chilirestapi.repository.DataRepository;
import com.jaypi4c.chilirestapi.service.IDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.jaypi4c.chilirestapi.dto.mapper.DataMapper.toDataDto;

/**
 * The data service to interact with the data repository.
 *
 * @author Jonas Pohl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DataService implements IDataService {

    private final DataRepository dataRepository;

    @Override
    public ResponseEntity<List<DataDto>> getAllData() {
        log.debug("Getting all Entries from the repository");
        return ResponseEntity.ok(dataRepository.findAll().stream().map(DataMapper::toDataDto).toList());
    }

    @Override
    public ResponseEntity<Void> save(List<DataDto> d) {
        for (DataDto dto : d) {
            Data data = DataMapper.toData(dto);
            dataRepository.save(data);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<DataDto> get(UUID id) {
        Data d = dataRepository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
        return ResponseEntity.ok(toDataDto(d));
    }

    @Override
    public ResponseEntity<Void> replace(DataDto newData, UUID id) {
        newData.setId(id);
        dataRepository.save(DataMapper.toData(newData));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        dataRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
