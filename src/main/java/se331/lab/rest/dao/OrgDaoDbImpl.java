package se331.lab.rest.dao;//package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Repository
@Profile("db")
public class OrgDaoDbImpl implements OrgDao{
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public Integer getOrgSize() {
        return Math.toIntExact(organizerRepository.count());
    }

    @Override
    public Page<Organizer> getOrgs(Integer pageSize, Integer page) {
        return organizerRepository.findAll(PageRequest.of(page-1, pageSize));
    }

    @Override
    public Organizer getOrg(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
}
