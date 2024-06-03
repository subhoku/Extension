package com.ext.service;

import java.util.List;

import com.ext.model.TicketdtlMdl;

public interface TicketdtlService {
	int addTicketdtl(TicketdtlMdl model) throws Exception;
    int updateTicketdtl(TicketdtlMdl model) throws Exception;
    int deleteTicketdtl(Long Id) throws Exception;
    TicketdtlMdl fetchById(String id) throws Exception;
    List<TicketdtlMdl> fetchAllDtl() throws Exception;
}
