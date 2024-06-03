package com.ext.service;

import java.util.List;

import com.ext.model.BussinessformdtlMdl;


public interface BussinessformdtlService {
     int addUserDtl(BussinessformdtlMdl model) throws Exception;
     int updateUserDtl(BussinessformdtlMdl model) throws Exception;
     int deleteUserDtl(Long Id) throws Exception;
     BussinessformdtlMdl fetchUserById(String id) throws Exception;
     List<BussinessformdtlMdl> fetchAllUsersDtl() throws Exception;
     List<BussinessformdtlMdl> fetchAllUsersDtlByLogin(String id) throws Exception;
}
