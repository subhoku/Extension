package com.ext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ext.entity.Officeadminmst;

public interface OfficeadminmstRepository extends JpaRepository<Officeadminmst, Long> {
   List<Officeadminmst>findByOamCreatedBy(@Param("cby") String cby);
}
