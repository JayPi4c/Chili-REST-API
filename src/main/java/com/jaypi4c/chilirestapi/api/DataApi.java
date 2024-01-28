package com.jaypi4c.chilirestapi.api;

import com.jaypi4c.chilirestapi.dto.DataDto;
import com.jaypi4c.chilirestapi.service.IDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * See this <a href="https://github.com/springdoc/springdoc-openapi-demos/blob/2.x/demo-spring-boot-3-webmvc/src/main/java/org/springdoc/demo/app2/api/PetApi.java">example</a>
 * for more information.
 * <p>
 * In this interface we define the endpoints of the datasink. Furthermore, we add documentation to the endpoints. They will be available using openAPI and swagger.
 *
 * @author Jonas Pohl
 */
@RequestMapping("/api/v2/data")
@Tag(name = "dump", description = "API to receive generic data consisting of a description and a timestamp")
public interface DataApi {

    default IDataService getService() {
        return new IDataService() {
        };
    }

    @GetMapping
    @Operation(summary = "Get all data entries", description = "Returns all data entries stored in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all data entries"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content)
    })
    default ResponseEntity<List<DataDto>> all() {
        return getService().getAllData();
    }

    @PostMapping
    @Operation(summary = "Send new data to the datasink", description = "Send a list of new data entries to the datasink")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully retrieved all new data entries"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to send new data", content = @Content)
    })
    default ResponseEntity<Void> newData(@Parameter(description = "The list of data entries to add", required = true) @RequestBody List<DataDto> newData) {
        return getService().save(newData);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a data entry by id", description = "Returns a data entry by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found and returned the data entry"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
            @ApiResponse(responseCode = "404", description = "The data entry was not found", content = @Content)
    })
    default ResponseEntity<DataDto> one(@PathVariable UUID id) {
        return getService().get(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Replace a data entry by id", description = "Replaces a data entry defined by its id with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the data entry"),
            @ApiResponse(responseCode = "204", description = "Successfully replaced the data entry"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to replace the resource", content = @Content),
            @ApiResponse(responseCode = "404", description = "The data entry was not found", content = @Content)
    })
    default ResponseEntity<Void> replaceData(@RequestBody DataDto newData, @PathVariable UUID id) {
        return getService().replace(newData, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a data entry by id", description = "Deletes a data entry defined by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the data entry"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to delete the resource", content = @Content),
            @ApiResponse(responseCode = "404", description = "The data entry was not found", content = @Content)
    })
    default ResponseEntity<Void> deleteData(@PathVariable UUID id) {
        return getService().delete(id);
    }

}
