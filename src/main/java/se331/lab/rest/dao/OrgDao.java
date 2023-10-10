package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Org;

import java.util.List;

public interface OrgDao {
    Integer getOrgSize();
    Page<Org> getOrgs(Integer pageSize, Integer page);
    Org getOrg(Long id);
    Org save(Org org);

}