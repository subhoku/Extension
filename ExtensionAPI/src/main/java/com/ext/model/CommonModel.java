package com.ext.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiResponses;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
@ApiModel(description = "A common response body model used in All kind of requests")
public class CommonModel {
	private ResponseHeaderModel responseHeader;
	private BussinessformdtlMdl bussinessformdtlMdl;
	private List<BussinessformdtlMdl> bussinessformdtlMdlLst;
	private EnquirydtlMdl enquirydtlMdl;
	private List<EnquirydtlMdl> enquirydtlMdlsLst;
	private OfficeadminmstMdl officeadminmstMdl;
	private List<OfficeadminmstMdl>officeadminmstMdlLst;
	private ProcessformautiddtlMdl processformautiddtlMdl;
	private List<ProcessformautiddtlMdl> processformautiddtlMdlst;
	private ProcessformkycdtlMdl processformkycdtlMdl;
	private List<ProcessformkycdtlMdl> processformkycdtlMdlst;
    private TicketdtlMdl ticketdtlMdl;
    private List<TicketdtlMdl> ticketdtlMdlst;
    private List<KycAuditDtlMdl> kycAuditDtlMdlst;
    private AuthResponse authResponse;
    private UserDetails userDetails;
}
