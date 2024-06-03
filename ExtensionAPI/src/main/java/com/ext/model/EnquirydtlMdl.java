package com.ext.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "A request body model used in POST requests to create a Kyc Enquiry Detail entity")
@NoArgsConstructor
public class EnquirydtlMdl {
	private @ApiModelProperty(required = false, value = "REST representation of the Enquiry Detail Model enq Id Length min = 0, max = 20")        String enqId; 
	private @ApiModelProperty(required = false, value = "REST representation of the Enquiry Detail Model enq Name Length min = 0, max = 255")     String enqName;
	private @ApiModelProperty(required = false, value = "REST representation of the Enquiry Detail Model enq Mobile no Length min = 0, max = 255")String enqMobileno; 
	private @ApiModelProperty(required = false, value = "REST representation of the Enquiry Detail Model enq Email id Length min = 0, max = 255") String enqEmailid; 
	private @ApiModelProperty(required = false, value = "REST representation of the Enquiry Detail Model enq Msg Length min = 0, max = 255")      String enqMsg; 
	private @ApiModelProperty(required = false, value = "REST representation of the Enquiry Detail Model enq Created Date")                       String enqCreatedDt;

	@JsonCreator
	public EnquirydtlMdl(@JsonProperty("enqId") String enqId, @JsonProperty("enqName") String enqName,
			@JsonProperty("enqMobileno") String enqMobileno, @JsonProperty("enqEmailid") String enqEmailid,
			@JsonProperty("enqMsg") String enqMsg, @JsonProperty("enqCreatedDt") String enqCreatedDt) {
		this.enqId = enqId;
		this.enqName = enqName;
		this.enqMobileno = enqMobileno;
		this.enqEmailid = enqEmailid;
		this.enqMsg = enqMsg;
		this.enqCreatedDt = enqCreatedDt;
	}
	
	
}
