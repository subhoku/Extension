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
@ApiModel(description = "A Office Admin Master Model for Request and Response")
public class OfficeadminmstMdl {
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamId Length min = 0, max = 11") String oamId;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamName Length min = 0, max = 255") String oamName;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamType Length min = 0, max = 255") String oamType;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamMobileno Length min = 0, max = 255") String oamMobileno;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamEmailid Length min = 0, max = 255") String oamEmailid;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamDob") String oamDob;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamPassword Length min = 0, max = 255") String oamPassword;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamProfilepic Length min = 0, max = 255") String oamProfilepic;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamCreateddt") String oamCreateddt;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamUpdateddt") String oamUpdateddt;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamUserType") String oamUserType;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamCreatedBy") String oamCreatedBy;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamupdatedBy") String oamupdatedBy;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamUserRole") String oamUserRole;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model oamUserRole") String userId;
	private @ApiModelProperty(required = false, value = "REST representation of the Office Admin Mst Model uploadObject") UploadObject uploadObject;

	@JsonCreator
	public OfficeadminmstMdl(@JsonProperty("oamId") String oamId, @JsonProperty("oamName") String oamName,
			@JsonProperty("oamType") String oamType, @JsonProperty("oamMobileno") String oamMobileno,
			@JsonProperty("oamEmailid") String oamEmailid, @JsonProperty("oamDob") String oamDob,
			@JsonProperty("oamPassword") String oamPassword, @JsonProperty("oamProfilepic") String oamProfilepic,
			@JsonProperty("oamCreateddt") String oamCreateddt,@JsonProperty("oamUpdateddt") String oamUpdateddt,
			@JsonProperty("oamUserType") String oamUserType,@JsonProperty("oamCreatedBy") String oamCreatedBy,
			@JsonProperty("oamupdatedBy") String oamupdatedBy,@JsonProperty("oamUserRole") String oamUserRole,
			@JsonProperty("userId") String userId,@JsonProperty("uploadObject") UploadObject uploadObject) {
		super();
		this.oamId = oamId;
		this.oamName = oamName;
		this.oamType = oamType;
		this.oamMobileno = oamMobileno;
		this.oamEmailid = oamEmailid;
		this.oamDob = oamDob;
		this.oamPassword = oamPassword;
		this.oamProfilepic = oamProfilepic;
		this.oamCreateddt = oamCreateddt;
		this.oamUpdateddt = oamUpdateddt;
		this.oamUserType = oamUserType;
		this.oamCreatedBy = oamCreatedBy;
		this.oamupdatedBy = oamupdatedBy;
		this.oamUserRole = oamUserRole;
		this.userId = userId;
		this.uploadObject = uploadObject;
	}

}
