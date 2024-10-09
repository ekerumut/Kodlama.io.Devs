package Kodlama.io.Devs.webAPİ.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ISoftwareService;
import Kodlama.io.Devs.entities.concretes.Software;


@RestController
@RequestMapping("/api/softwares")
public class SoftwaresController {

    private final ISoftwareService softwareService;

    @Autowired
    public SoftwaresController(ISoftwareService softwareService) {
        this.softwareService = softwareService;
    }

    @GetMapping("/getall")
    public List<Software> getAllSoftwareNames() {
        return softwareService.getAllSoftwareNames();
    }

    @DeleteMapping("/delete")
    public void deleteSoftware(@RequestParam String name) {
        softwareService.deleteSoftware(name);
    }

    @PostMapping("/add")
    public void addSoftware(@RequestBody Software software) {
        softwareService.addSoftware(software);
    }

    @PutMapping("/update")
    public void updateSoftware(@RequestBody Software updateName) {
        softwareService.updateSoftware(updateName);
        
    }
}