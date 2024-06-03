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
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@ApiModel(description = "A Bussiness form detail model for Request and Response")
public class BussinessformdtlMdl {
	private @ApiModelProperty(required = false, value = "REST representation of the Bussiness form detail model company Id Length min = 0, max = 20")  String companyId; 
	private @ApiModelProperty(required = false, value = "REST representation of the Bussiness form detail model company Name Length min = 0, max = 255")  String companyName;
	private @ApiModelProperty(required = false, value = "REST representation of the Bussiness form detail model company Type Length min = 0, max = 11")  String companyType;
	private @ApiModelProperty(required = false, value = "REST representation of the Bussiness form detail model company Mobileno Length min = 0, max = 255")  String companyMobileno;
	private @ApiModelProperty(required = false, value = "REST representation of the Bussiness form detail model company Emailid Length min = 0, max = 255")  String companyEmailid; 
	private @ApiModelProperty(required = false, value = "REST representation of the Bussiness form detail model company Password Length min = 0, max = 255")  String companyPassword;
	private @ApiModelProperty(required = false, value = "REST representation of the Bussiness form detail model company User Typ Length min = 0, max = 255") String companyUserTp;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamUserRole") String userId;
	@JsonCreator
	public BussinessformdtlMdl(@JsonProperty("companyId") String companyId, 
			@JsonProperty("companyName") String companyName, 
			@JsonProperty("companyType") String companyType, 
			@JsonProperty("companyMobileno") String companyMobileno,
			@JsonProperty("companyEmailid") String companyEmailid, 
			@JsonProperty("companyPassword") String companyPassword,
			@JsonProperty("companyUserTp") String companyUserTp,
			@JsonProperty("userId") String userId) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyType = companyType;
		this.companyMobileno = companyMobileno;
		this.companyEmailid = companyEmailid;
		this.companyPassword = companyPassword;
		this.companyUserTp = companyUserTp;
		this.userId = userId;
	}
}
