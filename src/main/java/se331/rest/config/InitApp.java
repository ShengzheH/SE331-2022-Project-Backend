package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Comment;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;

import java.util.ArrayList;
import java.util.List;

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
        p1 = patientRepository.save(Patient.builder()
                .name("p1name")
                .sur_name("p1surname")
                .age("20")
                .hometown("New York")
                .doctor(dor1)
                .build());
        p2 = patientRepository.save(Patient.builder()
                .name("p2name")
                .sur_name("p2surname")
                .age("25")
                .hometown("BeiJing")
                .doctor(dor1)
                .build());
        Vaccine v1,v2;
        v1 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("dose1")
                .firstdose_time("2022-04-12")
                .vaccined_status("FirstDose")
                .patient(p1).build());
        v2 = vaccineRepository.save(Vaccine.builder()
//                .firstdose_name("dose1")
//                .firstdose_time("2022-04-12")
//                .seconddose_name("dose2")
//                .seconddose_time("2022-05-12")
                .vaccined_status("Not Vaccinated")
                .patient(p2)
                .build());
//        patientRepository.AddVaccine(v1.getId(),p1.getId());
//        patientRepository.AddVaccine(v2.getId(),p2.getId());
        p1.setVaccineinfo(v1);
        p2.setVaccineinfo(v2);
        Comment c1,c2;
        c1 = commentRepository.save(Comment.builder()
                .comment("This is dor1 to p1 comment")
                .doctor(dor1)
                .patient(p1).build());
        c2 = commentRepository.save(Comment.builder()
                .comment("This is dor1 to p2 comment")
                .doctor(dor1)
                .patient(p2).build());
        List<Comment> commentList = new ArrayList<>();
        List<Comment> commentList1 = new ArrayList<>();
        List<Comment> commentList2 = new ArrayList<>();
        commentList.add(c1);
        commentList.add(c2);
        commentList1.add(c1);
        commentList2.add(c2);
        p1.setComments(commentList1);
        p2.setComments(commentList2);
        dor1.setComments(commentList);
        dor1.getPatients().add(p1);
        dor1.getPatients().add(p2);
        patientRepository.save(p1);
        patientRepository.save(p2);
        doctorRepository.save(dor1);
    }
}
