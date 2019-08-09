package com.example.swaggerdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class Controller {

    public String value;
    
    @ApiOperation(value = "Inserting values with Post")
    @PostMapping(value = "/insert")
    public void insertByPost(@RequestBody String str) {
        this.value = str;
    }
    
    @ApiOperation(value = "Inserting values with Get")
    @GetMapping(value = "/insert/{str}")
    public void insertByGet(@ApiParam(value = "String to be inserted", required = true) @PathVariable String str) {
        this.value = str;
    }
    
    @ApiOperation(value = "Displaying last inserted values")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "display")
    public String display() {
        return value;
    }
    
}
