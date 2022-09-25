package com.transaction.management.controller;

import com.transaction.management.Service.TransactionManagementService;
import com.transaction.management.exception.TransactionManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionManagementController {

    @Autowired
    TransactionManagementService transactionManagementService;

    @GetMapping
    @RequestMapping("/v1/transactionManagement")
    public ResponseEntity initialHandler(@RequestParam(name = "input") String input) throws Exception {
        System.out.print("Hello World"+input);
        transactionManagementService.createInformation(input);
        return new ResponseEntity(HttpStatus.OK);
    }
}
