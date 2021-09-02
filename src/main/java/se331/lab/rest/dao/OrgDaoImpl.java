package se331.lab.rest.dao;//package se331.lab.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrgDaoImpl implements OrgDao {
    List<Organizer> ordList;

    @PostConstruct
    public void init() {
        ordList = new ArrayList<>();
        ordList.add(Organizer.builder()
                .id(123L)
                .address("Meow Town")
                .orgName("Kat Laydee")
                .build()
        );
        ordList.add(Organizer.builder()
                .id(456L)
                .address("Flora City")
                .orgName("Fern Pollin")
                .build()
        );
        ordList.add(Organizer.builder()
                .id(789L)
                .address("Playa Del Carmen")
                .orgName("Carey Wales")
                .build()
        );
        ordList.add(Organizer.builder()
                .id(1001L)
                .address("Woof Town")

                .orgName("Dawg Dahd")
                .build()
        );
        ordList.add(Organizer.builder()
                .id(1002L)
                .address("Tin City")

                .orgName("Kahn Opiner")
                .build()
        );
        ordList.add(Organizer.builder()
                .id(1003L)
                .address("Highway 50")
                .orgName("Brody Kill")
                .build()
        );
    }

    @Override
    public Integer getOrgSize() {
        return ordList.size();
    }

    @Override
    public Page<Organizer> getOrgs(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? ordList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(ordList.subList(firstIndex, firstIndex + pageSize));

    }

    @Override
    public Organizer getOrg(Long id) {
        return ordList.stream().filter(org -> org.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(ordList.get(ordList.size()-1).getId()+1);
        ordList.add(organizer);
        return organizer;
    }
}
