package com.ext.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@ApiModel(description = "A request body model used in POST requests to create a Kyc Audit Dtl entity")
public class KycAuditDtlMdl {
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfkdClntCmpnName Length min = 0, max = 255") String pfkdClntCmpnName;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfkdClntProjName Length min = 0, max = 255") String pfkdClntProjName;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfkdClntProjStatus Length min = 0, max = 20") String pfkdClntProjStatus;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntCmpnName Length min = 0, max = 255") String pfdClntCmpnName;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjName Length min = 0, max = 255") String pfdClntProjName;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjType Length min = 0, max = 20") String pfdClntProjType;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjSourcelink Length min = 0, max = 255") String pfdClntProjSourcelink;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjNoofcontracts Length min = 0, max = 255") String pfdClntProjNoofcontracts;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjNameofcontracts Length min = 0, max = 255") String pfdClntProjNameofcontracts;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjAuditedby Length min = 0, max = 255") String pfdClntProjAuditedby;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjAuditingdate") String pfdClntProjAuditingdate;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjAuditedreportslink Length min = 0, max = 255") String pfdClntProjAuditedreportslink;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjTrustscore Length min = 0, max = 255") String pfdClntProjTrustscore;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjTotalvolume Length min = 0, max = 255") String pfdClntProjTotalvolume;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjCirculatingsupply Length min = 0, max = 255") String pfdClntProjCirculatingsupply;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjMarketcap Length min = 0, max = 255") String pfdClntProjMarketcap;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjCoinranking Length min = 0, max = 255") String pfdClntProjCoinranking;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjTokenlaunched Length min = 0, max = 255") String pfdClntProjTokenlaunched;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjClasOfBlChn Length min = 0, max = 255") String pfdClntProjClasOfBlChn;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfdClntProjCntrctTyp Length min = 0, max = 11") String pfdClntProjCntrctTyp;
	private @ApiModelProperty(required = false, value = "REST representation of the Kyc Audit Detail Model pfkdCreatedDate") String pfkdCreatedDate;

	public KycAuditDtlMdl(@JsonProperty("pfkdClntCmpnName") String pfkdClntCmpnName,
			@JsonProperty("pfkdClntProjName") String pfkdClntProjName,
			@JsonProperty("pfkdClntProjStatus") String pfkdClntProjStatus,
			@JsonProperty("pfdClntCmpnName") String pfdClntCmpnName,
			@JsonProperty("pfdClntProjName") String pfdClntProjName,
			@JsonProperty("pfdClntProjType") String pfdClntProjType,
			@JsonProperty("pfdClntProjSourcelink") String pfdClntProjSourcelink,
			@JsonProperty("pfdClntProjNoofcontracts") String pfdClntProjNoofcontracts,
			@JsonProperty("pfdClntProjNameofcontracts") String pfdClntProjNameofcontracts,
			@JsonProperty("pfdClntProjAuditedby") String pfdClntProjAuditedby,
			@JsonProperty("pfdClntProjAuditingdate") String pfdClntProjAuditingdate,
			@JsonProperty("pfdClntProjAuditedreportslink") String pfdClntProjAuditedreportslink,
			@JsonProperty("pfdClntProjTrustscore") String pfdClntProjTrustscore,
			@JsonProperty("pfdClntProjTotalvolume") String pfdClntProjTotalvolume,
			@JsonProperty("pfdClntProjCirculatingsupply") String pfdClntProjCirculatingsupply,
			@JsonProperty("pfdClntProjMarketcap") String pfdClntProjMarketcap,
			@JsonProperty("pfdClntProjCoinranking") String pfdClntProjCoinranking,
			@JsonProperty("pfdClntProjTokenlaunched") String pfdClntProjTokenlaunched,
			@JsonProperty("pfdClntProjClasOfBlChn") String pfdClntProjClasOfBlChn,
			@JsonProperty("pfdClntProjCntrctTyp") String pfdClntProjCntrctTyp,
			@JsonProperty("pfkdCreatedDate") String pfkdCreatedDate) {
		super();
		this.pfkdClntCmpnName = pfkdClntCmpnName;
		this.pfkdClntProjName = pfkdClntProjName;
		this.pfkdClntProjStatus = pfkdClntProjStatus;
		this.pfdClntCmpnName = pfdClntCmpnName;
		this.pfdClntProjName = pfdClntProjName;
		this.pfdClntProjType = pfdClntProjType;
		this.pfdClntProjSourcelink = pfdClntProjSourcelink;
		this.pfdClntProjNoofcontracts = pfdClntProjNoofcontracts;
		this.pfdClntProjNameofcontracts = pfdClntProjNameofcontracts;
		this.pfdClntProjAuditedby = pfdClntProjAuditedby;
		this.pfdClntProjAuditingdate = pfdClntProjAuditingdate;
		this.pfdClntProjAuditedreportslink = pfdClntProjAuditedreportslink;
		this.pfdClntProjTrustscore = pfdClntProjTrustscore;
		this.pfdClntProjTotalvolume = pfdClntProjTotalvolume;
		this.pfdClntProjCirculatingsupply = pfdClntProjCirculatingsupply;
		this.pfdClntProjMarketcap = pfdClntProjMarketcap;
		this.pfdClntProjCoinranking = pfdClntProjCoinranking;
		this.pfdClntProjTokenlaunched = pfdClntProjTokenlaunched;
		this.pfdClntProjClasOfBlChn = pfdClntProjClasOfBlChn;
		this.pfdClntProjCntrctTyp = pfdClntProjCntrctTyp;
		this.pfkdCreatedDate = pfkdCreatedDate;
	}

}
