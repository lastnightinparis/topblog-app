package org.squad.topblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.squad.topblogapp.entity.TgRecord;

@Repository
public interface TgRepository extends JpaRepository<TgRecord, Long> {
}
