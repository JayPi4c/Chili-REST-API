package com.jaypi4c.chilirestapi.controller;

import com.jaypi4c.chilirestapi.api.DataApi;
import com.jaypi4c.chilirestapi.service.IDataService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jonas Pohl
 */
@Slf4j
@Getter
@RestController
@RequiredArgsConstructor
public class DataController implements DataApi {

    private final IDataService service;
}
