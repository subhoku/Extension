package com.ext.service;

import java.util.List;

import com.ext.model.ProcessformautiddtlMdl;

public interface ProcessformautiddtlService {
	int addProcessformautiddtl(ProcessformautiddtlMdl model) throws Exception;
    int updateProcessformautiddtl(ProcessformautiddtlMdl model) throws Exception;
    int deleteProcessformautiddtl(Long Id) throws Exception;
    ProcessformautiddtlMdl fetchById(String id) throws Exception;
    List<ProcessformautiddtlMdl> fetchAllDtl() throws Exception;
    List<ProcessformautiddtlMdl> fetchAllDtlByLogin(String id) throws Exception;
    List<ProcessformautiddtlMdl> fetchAllDtlByStatus(String status) throws Exception;
}
