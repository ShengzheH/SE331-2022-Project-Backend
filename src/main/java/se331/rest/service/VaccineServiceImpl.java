package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.rest.dao.VaccineDao;
import se331.rest.entity.Vaccine;
@Service
public class VaccineServiceImpl implements VaccineService{
    @Autowired
    VaccineDao vaccineDao;
    @Override
    public Integer getVaccineSize() {
        return vaccineDao.getVaccineSize();
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineDao.getVaccine(id);
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineDao.save(vaccine);
    }
}
