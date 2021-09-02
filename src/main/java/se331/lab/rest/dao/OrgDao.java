package se331.lab.rest.dao;//package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrgDao {
    Integer getOrgSize();
    Page<Organizer> getOrgs(Integer pageSize, Integer page);
    Organizer getOrg(Long id);
    Organizer save(Organizer organizer);
}
