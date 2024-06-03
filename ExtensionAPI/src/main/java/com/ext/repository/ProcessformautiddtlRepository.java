package com.ext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ext.entity.Processformautiddtl;

public interface ProcessformautiddtlRepository extends JpaRepository<Processformautiddtl, Long> {
	List<Processformautiddtl> findByPfdCreatedBy(@Param("cby") String cby);
	List<Processformautiddtl> findByPfdStatus(String pfdStatus);
}
