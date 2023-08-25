package org.squad.topblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.squad.topblogapp.entity.YtRecord;

@Repository
public interface YtRepository extends JpaRepository<YtRecord, Long> {
}
