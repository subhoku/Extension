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
@ApiModel(description = "A Ticket Detail model for Request and Response")
public class TicketdtlMdl {
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktId Length min = 0, max = 20") String tktId;
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktUserId Length min = 0, max = 20") String tktUserId;
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktSubject Length min = 0, max = 20") String tktSubject;
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktPriority Length min = 0, max = 20") String tktPriority;
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktMassage Length min = 0, max = 20") String tktMassage;
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktStatus Length min = 0, max = 20") String tktStatus;
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktCreatedDt Length min = 0, max = 20") String tktCreatedDt;
	private @ApiModelProperty(required = false, value = "REST representation of the Ticket Details Model tktUpdateddt Length min = 0, max = 20") String tktUpdateddt;

	@JsonCreator
	public TicketdtlMdl(@JsonProperty("tktId") String tktId, @JsonProperty("tktUserId") String tktUserId,
			@JsonProperty("tktSubject") String tktSubject, @JsonProperty("tktPriority") String tktPriority,
			@JsonProperty("tktMassage") String tktMassage, @JsonProperty("tktStatus") String tktStatus,
			@JsonProperty("tktCreatedDt") String tktCreatedDt, @JsonProperty("tktUpdateddt") String tktUpdateddt) {
		super();
		this.tktId = tktId;
		this.tktUserId = tktUserId;
		this.tktSubject = tktSubject;
		this.tktPriority = tktPriority;
		this.tktMassage = tktMassage;
		this.tktStatus = tktStatus;
		this.tktCreatedDt = tktCreatedDt;
		this.tktUpdateddt = tktUpdateddt;
	}
}
