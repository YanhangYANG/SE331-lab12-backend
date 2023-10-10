package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Org;
import se331.lab.rest.repository.OrgRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class OrgDaoDblmpl implements OrgDao {
  final OrgRepository orgRepository;

    @Override
    public Integer getOrgSize() {
        return Math.toIntExact(orgRepository.count());
    }

    @Override
    public Page<Org> getOrgs(Integer pageSize, Integer page) {
        if (page == null) {
            page = 1;  // 设置默认页码为1
        }
        if (pageSize == null) {
            pageSize = 10;  // 设置默认每页的记录数量为10
        }
        return orgRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Org getOrg(Long id) {
        return orgRepository.findById(id).orElse(null);
    }

    @Override
    public Org save(Org org) {
        return orgRepository.save(org);
    }

}
