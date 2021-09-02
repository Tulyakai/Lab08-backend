package se331.lab.rest.service;//package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Organizer;

public interface OrganizerService {

    Integer GetOrgSize();
    Page<Organizer> getOrgs(Integer pageSize, Integer page);
    Organizer getOrg(Long id);
    Organizer save(Organizer organizer);
}
