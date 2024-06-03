package com.ext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ext.entity.Bussinessformdtl;
import com.ext.entity.Product;

public interface BussinessformdtlRepository extends JpaRepository<Bussinessformdtl, Long>{
	List<Bussinessformdtl> findByCompanyCreatedBy(@Param("cby") String cby);
}
