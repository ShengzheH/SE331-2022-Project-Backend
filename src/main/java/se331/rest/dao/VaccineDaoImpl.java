package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Vaccine;
import se331.rest.repository.VaccineRepository;

@Repository
public class VaccineDaoImpl implements VaccineDao{
    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public Integer getVaccineSize() {
        return Math.toIntExact(vaccineRepository.count());
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }
}
