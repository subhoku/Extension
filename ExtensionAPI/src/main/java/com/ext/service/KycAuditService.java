package com.ext.service;

import java.util.List;

import com.ext.model.KycAuditDtlMdl;

public interface KycAuditService {
	
	public List<KycAuditDtlMdl> getkycauditdetailbycompany(String company);

}
