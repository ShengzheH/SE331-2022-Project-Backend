package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Patient;
import se331.rest.service.PatientService;
import se331.rest.util.LabMapper;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<?> getPatientLists(@RequestParam(value = "_limit",required = false) Integer perPage
    ,@RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String keyword){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Patient> pageOutput;
//        if (keyword ==null)
        pageOutput = patientService.getPatients(perPage,page);
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPatientDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }
    @GetMapping("/patientswithvaccine")
    public ResponseEntity<?> getPatientListsWithVaccine(@RequestParam(value = "_limit",required = false) Integer perPage
            ,@RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String keyword){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Patient> pageOutput;
//        if (keyword ==null)
        pageOutput = patientService.getPatientsVaccineNot("Not Vaccinated",perPage,page);
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPatientDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }
    @GetMapping("patient/{id}")
    public ResponseEntity<?> getPatient(@PathVariable("id")Long id){
        Patient output = patientService.getPatient(id);
        if (output != null)
            return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDTO(output));
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
    }

    @PostMapping("/patient")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient){
        Patient output = patientService.save(patient);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDTO(output));
    }
    @PostMapping("/patientimage")
    public ResponseEntity<?> changeimage(@RequestBody Patient patient){
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDTO(patientService.save(patient)));
    }
}
