package com.bass.dms.server.documentservice.repository;

import com.bass.dms.server.common.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
