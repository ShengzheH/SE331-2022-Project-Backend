package se331.rest.service;

import se331.rest.entity.Vaccine;

public interface VaccineService {
    Integer getVaccineSize();
    Vaccine getVaccine(Long id);
    Vaccine save(Vaccine vaccine);
}
