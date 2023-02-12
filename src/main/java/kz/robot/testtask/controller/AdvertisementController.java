package kz.robot.testtask.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.robot.testtask.dto.AdvertisementDTO;
import kz.robot.testtask.model.Advertisement;
import kz.robot.testtask.reports.ResourceCreationReport;
import kz.robot.testtask.service.AdvertisementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/advertisement")
@Tag(name = "Объявления")
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping("/create")
    @Operation(summary = "Создать объявление")
    public ResponseEntity<ResourceCreationReport> create(@RequestBody AdvertisementDTO advertisementDTO, @RequestParam("image") MultipartFile file, Principal principal) throws IOException {
        return ResponseEntity.ok(advertisementService.create(advertisementDTO, file, principal));
    }

    @GetMapping("/advertisementID")
    @Operation(summary = "Посмотреть объявление")
    public ResponseEntity<Advertisement> findById(@PathVariable Long advertisementID){
        return ResponseEntity.ok(advertisementService.findById(advertisementID));
    }

    @GetMapping("/")
    @Operation(summary = "Посмотреть все объявление")
    public ResponseEntity<List<Advertisement>> findById(){
        return ResponseEntity.ok(advertisementService.findAll());
    }
}
