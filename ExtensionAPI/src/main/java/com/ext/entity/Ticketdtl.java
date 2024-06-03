package com.ext.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "ticketdtl")
@Data
public class Ticketdtl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tkt_id")
	private Long tktId;
	
	@Column(name = "tkt_user_id")
	private String tktUserId; 
	
	@Column(name = "tkt_subject")
	private String tktSubject;
	
	@Column(name = "tkt_priority")
	private String tktPriority; 
	
	@Column(name = "tkt_massage")
	private String tktMassage;
	
	@Column(name = "tkt_status")
	private String tktStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tkt_created_dt")
	private Date tktCreatedDt;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tkt_updatedDt")
	private Date tktUpdateddt;


}
