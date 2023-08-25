package org.squad.topblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.squad.topblogapp.entity.VkRecord;

@Repository
public interface VkRepository extends JpaRepository<VkRecord, Long> {
}
