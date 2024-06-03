package com.ext.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "A request body model used in POST requests to create a User Details entity")
@NoArgsConstructor
public class UserDetails {
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 50") String email;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 100") String accessToken;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 100") String orgname;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 20") String type;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 20") String fromTbl;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 20") String refid;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 50") String uType;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 20") String uRole;
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 500") String profilePic;
	
	@JsonCreator
	public UserDetails(@JsonProperty("email") String email, @JsonProperty("accessToken") String accessToken,
			@JsonProperty("username") String orgname,
			@JsonProperty("type") String type,
			@JsonProperty("fromTbl") String fromTbl,
			@JsonProperty("refid") String refid,
			@JsonProperty("uType") String uType,
			@JsonProperty("uRole") String uRole,
			@JsonProperty("profilePic") String profilePic) {
		super();
		this.email = email;
		this.accessToken = accessToken;
		this.orgname = orgname;
		this.type = type;
		this.fromTbl = fromTbl;
		this.refid = refid;
		this.uType = uType;
		this.uRole = uRole;
		this.profilePic = profilePic;
	}
	
}
