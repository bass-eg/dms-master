package com.bass.dms.server.documentservice.repository;

import com.bass.dms.server.common.entity.ContentObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ContentObjectRepo extends JpaRepository<ContentObject,Long> {
    @Query("select c from ContentObject c where c.name=:name")
    ContentObject getContentObjectByName(String name);
}
