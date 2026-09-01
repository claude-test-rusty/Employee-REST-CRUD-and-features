package com.ak.Employee.controller;

import com.ak.Employee.dto.EmployeeDto;
import com.ak.Employee.kafkaProducer.EmployeeEventProducer;
import com.ak.Employee.response.ResponseHandler;
import com.ak.Employee.service.EmployeeService;
import org.springframework.http.HttpStatus;

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

}
