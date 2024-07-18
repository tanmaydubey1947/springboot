package com.springboot.controller;

import com.springboot.webServices.MackBookService;
import com.springboot.webServicesVO.ListResponse;
import com.springboot.webServicesVO.MacBookRequest;
import com.springboot.webServicesVO.MacBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/macBook")
public class MacBookController {

    @Autowired
    private MackBookService mackBookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        MacBookResponse response = mackBookService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addData(@RequestBody MacBookRequest request) {
        MacBookResponse response = mackBookService.addData(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getByParam")
    public ResponseEntity<?> getByParam(@RequestParam String id) {
        ListResponse response = mackBookService.getByParam(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateData(@PathVariable String id, @RequestBody MacBookRequest request) {
        mackBookService.updateData(request, id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable String id) {
        mackBookService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
