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
@ApiModel(description = "A request body model used in POST requests to create a Auth response entity")
@NoArgsConstructor

public class AuthResponse {
	  
	private String ts;
	private String txn;
	private String respCode;
	private String status;
	private String statusMsg;
	private String err;
	private String errMsg;
	private UserDetails userDetails;


}
