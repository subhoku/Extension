package com.ext.model;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.NON_NULL)
@NoArgsConstructor
@ApiModel(description = "A Process Form Audit Detail model for Request and Response")
public class ProcessformautiddtlMdl {
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdId Length min = 0, max = 11") String pfdId;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntCmpnName Length min = 0, max = 255") String pfdClntCmpnName;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntCmpnWebsite Length min = 0, max = 255") String pfdClntCmpnWebsite;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjName Length min = 0, max = 255") String pfdClntProjName;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjType Length min = 0, max = 11") String pfdClntProjType;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjSourcelink Length min = 0, max = 255") String pfdClntProjSourcelink;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjNoofcontracts Length min = 0, max = 255") String pfdClntProjNoofcontracts;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjNameofcontracts Length min = 0, max = 255") String pfdClntProjNameofcontracts;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjAuditedby Length min = 0, max = 255") String pfdClntProjAuditedby;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjAuditingdate Length") String pfdClntProjAuditingdate;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjAuditedreportslink Length min = 0, max = 255") String pfdClntProjAuditedreportslink;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjTrustscore Length min = 0, max = 255") String pfdClntProjTrustscore;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjTotalvolume Length min = 0, max = 255") String pfdClntProjTotalvolume;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjCirculatingsupply Length min = 0, max = 255") String pfdClntProjCirculatingsupply;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjMarketcap Length min = 0, max = 255") String pfdClntProjMarketcap;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjCoinranking Length min = 0, max = 255") String pfdClntProjCoinranking;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjTokenlaunched Length min = 0, max = 255") String pfdClntProjTokenlaunched;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjTechUsed Length min = 0, max = 255") String pfdClntProjTechUsed;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjClasOfBlChn Length min = 0, max = 255") String pfdClntProjClasOfBlChn;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjTypOfTkn Length min = 0, max = 255") String pfdClntProjTypOfTkn;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntCreatedDt Length") String pfdClntCreatedDt;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntUpdatedDt Length") String pfdClntUpdatedDt;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjTknStandrd Length")  String pfdClntProjTknStandrd; 
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjUtilityOfCoin Length")String pfdClntProjUtilityOfCoin;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdClntProjBackedByBcoin Length") String pfdClntProjBackedByBcoin;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdUserid Length")String pfdUserid; 
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form Autid Details Model pfdStatus Length")String pfdStatus;
	@JsonCreator
	public ProcessformautiddtlMdl(@JsonProperty("pfdId") String pfdId,
			@JsonProperty("pfdClntCmpnName") String pfdClntCmpnName,
			@JsonProperty("pfdClntCmpnWebsite") String pfdClntCmpnWebsite,
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
			@JsonProperty("pfdClntProjTechUsed") String pfdClntProjTechUsed,
			@JsonProperty("pfdClntProjClasOfBlChn") String pfdClntProjClasOfBlChn,
			@JsonProperty("pfdClntProjTypOfTkn") String pfdClntProjTypOfTkn,
			@JsonProperty("pfdClntCreatedDt") String pfdClntCreatedDt,
			@JsonProperty("pfdClntUpdatedDt") String pfdClntUpdatedDt,
			@JsonProperty("pfdClntProjTknStandrd") String pfdClntProjTknStandrd,
			@JsonProperty("pfdClntProjUtilityOfCoin") String pfdClntProjUtilityOfCoin,
			@JsonProperty("pfdClntProjBackedByBcoin") String pfdClntProjBackedByBcoin,
			@JsonProperty("pfdUserid") String pfdUserid,
			@JsonProperty("pfdStatus") String pfdStatus) {
		super();
		this.pfdId = pfdId;
		this.pfdClntCmpnName = pfdClntCmpnName;
		this.pfdClntCmpnWebsite = pfdClntCmpnWebsite;
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
		this.pfdClntProjTechUsed = pfdClntProjTechUsed;
		this.pfdClntProjClasOfBlChn = pfdClntProjClasOfBlChn;
		this.pfdClntProjTypOfTkn = pfdClntProjTypOfTkn;
		this.pfdClntCreatedDt = pfdClntCreatedDt;
		this.pfdClntUpdatedDt = pfdClntUpdatedDt;
		this.pfdClntProjTknStandrd = pfdClntProjTknStandrd;
		this.pfdClntProjUtilityOfCoin = pfdClntProjUtilityOfCoin;
		this.pfdUserid = pfdUserid;
		this.pfdStatus = pfdStatus;
	}

}
