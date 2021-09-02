package se331.lab.rest.service;//package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrgDao;
import se331.lab.rest.entity.Organizer;

@Service
public class OrgImpl implements OrganizerService{
    @Autowired
    OrgDao orgDao;

    @Override
    public Integer GetOrgSize() {
        return orgDao.getOrgSize();
    }

    @Override
    public Page<Organizer> getOrgs(Integer pageSize, Integer page) {
        return orgDao.getOrgs(pageSize, page);
    }

    @Override
    public Organizer getOrg(Long id) {
        return orgDao.getOrg(id);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return orgDao.save(organizer);
    }
}
