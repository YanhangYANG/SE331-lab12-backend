package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Org;

import java.util.List;

public interface OrgRepository extends JpaRepository<Org, Long> {
    List<Org> findAll();
}
