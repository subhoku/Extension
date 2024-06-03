package com.ext.service;

import java.util.List;

import com.ext.model.OfficeadminmstMdl;

public interface OfficeadminmstService {
	int addOfficeadminmst(OfficeadminmstMdl model) throws Exception;
    int updateOfficeadminmst(OfficeadminmstMdl model) throws Exception;
    int deleteOfficeadminmst(Long Id) throws Exception;
    OfficeadminmstMdl fetchById(String id) throws Exception;
    List<OfficeadminmstMdl> fetchAllDtl() throws Exception;
    List<OfficeadminmstMdl> fetchAllDtlByLogin(String id) throws Exception;
}
