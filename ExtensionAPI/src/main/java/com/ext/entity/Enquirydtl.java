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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enquirydtl")
@Data
@NoArgsConstructor
public class Enquirydtl implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_id")
	private Long enqId;
	
	@Column(name = "enq_name")
	private String enqName;
	
	@Column(name = "enq_mobileno")
	private String enqMobileno;
	
	@Column(name = "enq_EmailId")
	private String enqEmailid;
	
	@Column(name = "enq_msg")
	private String enqMsg;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "enq_created_dt")
	private Date enqCreatedDt;
}
