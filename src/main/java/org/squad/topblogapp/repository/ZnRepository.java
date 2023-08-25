package org.squad.topblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.squad.topblogapp.entity.ZnRecord;

@Repository
public interface ZnRepository extends JpaRepository<ZnRecord, Long> {
}
