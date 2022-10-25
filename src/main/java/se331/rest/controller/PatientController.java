package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se331.rest.entity.Patient;
import se331.rest.service.PatientService;
import se331.rest.util.LabMapper;

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
}
