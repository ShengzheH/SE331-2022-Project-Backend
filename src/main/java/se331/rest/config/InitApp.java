package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccineRepository vaccineRepository;
    @Autowired
    CommentRepository commentRepository;
    String name;
    String sur_name;
    String age;
    String hometown;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Doctor dor1;
        dor1 = doctorRepository.save(Doctor.builder()
                .name("dor1name")
                .sur_name("dor1surname")
                .age("40")
                .hometown("DC")
                .build());
        Patient p1,p2;
    }
}
