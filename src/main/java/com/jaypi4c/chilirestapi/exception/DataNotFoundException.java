package com.jaypi4c.chilirestapi.exception;

import java.io.Serial;
import java.util.UUID;

/**
 * Exception to be thrown when no data for the given ID could be found.
 *
 * @author Jonas Pohl
 */
public class DataNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2231553663020565485L;

    /**
     * Constructor for the exception.
     *
     * @param id the id for which no data could be found.
     */
    public DataNotFoundException(UUID id) {
        super("Could not find data for id " + id.toString());
    }
}
