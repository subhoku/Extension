package com.ext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ext.entity.Processformkycdtl;

public interface ProcessformkycdtlRepository extends JpaRepository<Processformkycdtl, Long> {
   List<Processformkycdtl> findByPfkdClntProjStatus(String pfkdClntProjStatus); 
}
