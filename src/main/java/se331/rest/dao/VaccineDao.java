package se331.rest.dao;

import se331.rest.entity.Vaccine;

public interface VaccineDao {
    Integer getVaccineSize();
    Vaccine getVaccine(Long id);
    Vaccine save(Vaccine vaccine);
}
