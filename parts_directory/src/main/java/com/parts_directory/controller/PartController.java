package com.parts_directory.controller;

import com.parts_directory.entity.Part;
import com.parts_directory.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class PartController {
    private final PartService partService;

    @Autowired
    public PartController(@Qualifier("partServiceIMPL") PartService partService) {
        this.partService = partService;
    }

    //http://localhost:8080/retrieveAllParts
    @GetMapping("/retrieveAllParts")
    public List<Part> findAll() {
        return partService.findAll();
    }

    //http://localhost:8080/retrievePartById/1
    @GetMapping("/retrievePartById/{partId}")
    public Part findById(@PathVariable int partId) {
        return partService.findById(partId);
    }

    //http://localhost:8080/addPart
    @PostMapping("/addPart")
    public Part addPart(@RequestBody Part thePart) {
        thePart.setId(0);

        partService.saveOrUpdate(thePart);
        return thePart;
    }

    //http://localhost:8080/updatePart
    @PutMapping("/updatePart")
    public Part updatePart(@RequestBody Part updatePart) {
        partService.saveOrUpdate(updatePart);
        return updatePart;
    }

    //http://localhost:8080/deletePart/1
    @DeleteMapping("/deletePart/{partId}")
    public String deletePart(@PathVariable int partId) {
        partService.deleteById(partId);
        return "Deleted part id : " + partId;
    }



}
