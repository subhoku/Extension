package com.ext.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "A request body model used in POST requests to create a Auth Request entity")
public class AuthRequest {
	@NotNull
	@Email
	@Length(min = 5, max = 50)
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 50") String email;
	
	@NotNull
	@Length(min = 5, max = 10)
	private @ApiModelProperty(required = false, value = "REST representation of the Auth Request Length min = 5, max = 64") String password;
	
	@JsonCreator
	public AuthRequest(@JsonProperty("email")String email,@JsonProperty("password")String password){
		 this.email = email;
		 this.password = password;
	}

}
