package com.ext.service;

import java.util.List;

import com.ext.model.BussinessformdtlMdl;
import com.ext.model.EnquirydtlMdl;

public interface EnquirydtlService {
	int addEnquirydtl(EnquirydtlMdl model) throws Exception;
    int updateEnquirydtl(EnquirydtlMdl model) throws Exception;
    int deleteEnquirydtl(Long Id) throws Exception;
    EnquirydtlMdl fetchById(String id) throws Exception;
    List<EnquirydtlMdl> fetchAllDtl() throws Exception;
}
