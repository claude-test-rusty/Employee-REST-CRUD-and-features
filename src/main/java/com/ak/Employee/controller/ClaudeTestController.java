package com.ak.Employee.controller;

import com.ak.Employee.dto.EmployeeDto;
import com.ak.Employee.kafkaProducer.EmployeeEventProducer;
import com.ak.Employee.response.ResponseHandler;
import com.ak.Employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Claude", description = "Claude test APIs")
@RestController
@RequestMapping("/claude")
public class ClaudeTestController {

    @Autowired
    EmployeeService empService;

    @Autowired
    private EmployeeEventProducer employeeEventProducer;

    @Operation(
            summary = "Retrieve a Employee by Id",
            description = "Get a Employee  by specifying its id. The response is Employee object with id, name, age and joining date.",
            tags = { "employee", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = EmployeeDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{employeeId}")
    public ResponseEntity<Object> getEmployee(@PathVariable("employeeId") String employeeId)
    {
        List<String> dummyData = new ArrayList<String>();
        dummyData.add("Rusty");
        return ResponseHandler.responseBuilder("Here are the values of requested Employee", HttpStatus.OK, dummyData);
    }

    @GetMapping("/test")
    public String test() {
        int x = 42;
        return "test";
    }

}
