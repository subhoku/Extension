package com.ext.model;

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
@ApiModel(description = "A Process Form KYC Detail Model for Request and Response")
public class ProcessformkycdtlMdl {
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form KYC Details Model pfkdId Length min = 0, max = 11") String pfkdId;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form KYC Details Model pfkdClntCmpnName Length min = 0, max = 255") String pfkdClntCmpnName;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form KYC Details Model pfkdClntCmpnWebsite Length min = 0, max = 255") String pfkdClntCmpnWebsite;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form KYC Details Model pfkdClntProjName Length min = 0, max = 255") String pfkdClntProjName;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form KYC Details Model pfkdClntProjStatus Length min = 0, max = 255") String pfkdClntProjStatus;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form KYC Details Model pfkdCreatedDate Length min = 0, max = 255") String pfkdCreatedDate;
	private @ApiModelProperty(required = false, value = "REST representation of the Process Form KYC Details Model pfkdUpdatedDt Length") String pfkdUpdatedDt;

	@JsonCreator
	public ProcessformkycdtlMdl(@JsonProperty("pfkdId") String pfkdId,
			@JsonProperty("pfkdClntCmpnName") String pfkdClntCmpnName,
			@JsonProperty("pfkdClntCmpnWebsite") String pfkdClntCmpnWebsite,
			@JsonProperty("pfkdClntProjName") String pfkdClntProjName,
			@JsonProperty("pfkdClntProjStatus") String pfkdClntProjStatus,
			@JsonProperty("pfkdCreatedDate") String pfkdCreatedDate,
			@JsonProperty("pfkdUpdatedDt") String pfkdUpdatedDt) {
		super();
		this.pfkdId = pfkdId;
		this.pfkdClntCmpnName = pfkdClntCmpnName;
		this.pfkdClntCmpnWebsite = pfkdClntCmpnWebsite;
		this.pfkdClntProjName = pfkdClntProjName;
		this.pfkdClntProjStatus = pfkdClntProjStatus;
		this.pfkdCreatedDate = pfkdCreatedDate;
		this.pfkdUpdatedDt = pfkdUpdatedDt;
	}
}
