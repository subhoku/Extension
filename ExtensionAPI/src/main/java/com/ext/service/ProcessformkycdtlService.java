package com.ext.service;

import java.util.List;

import com.ext.model.ProcessformkycdtlMdl;

public interface ProcessformkycdtlService {
	int addProcessformkycdtl(ProcessformkycdtlMdl model) throws Exception;
    int updateProcessformkycdtl(ProcessformkycdtlMdl model) throws Exception;
    int deleteProcessformkycdtl(Long Id) throws Exception;
    ProcessformkycdtlMdl fetchById(String id) throws Exception;
    List<ProcessformkycdtlMdl> fetchAllDtl() throws Exception;
    List<ProcessformkycdtlMdl> fetchAllDtlByStatus(String status) throws Exception;
}
