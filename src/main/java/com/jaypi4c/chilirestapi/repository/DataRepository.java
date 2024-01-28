package com.jaypi4c.chilirestapi.repository;

import com.jaypi4c.chilirestapi.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Simple JPA Repository for data-objects.
 *
 * @author Jonas Pohl
 */
public interface DataRepository extends JpaRepository<Data, UUID> {

}
