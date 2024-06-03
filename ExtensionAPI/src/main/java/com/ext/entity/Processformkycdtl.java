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
@Table(name = "")
@Data
public class Processformkycdtl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pfkd_id")
	private Long pfkdId;
	
	@Column(name = "pfkd_clnt_cmpn_name")
	private String pfkdClntCmpnName;
	
	@Column(name = "pfkd_clnt_cmpn_Website")
	private String pfkdClntCmpnWebsite; 
	
	@Column(name = "pfkd_Clnt_proj_name")
	private String pfkdClntProjName;
	
	@Column(name = "pfkd_Clnt_proj_Status")
	private String pfkdClntProjStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "pfkd_created_date")
	private Date pfkdCreatedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "pfkd_updated_dt")
	private Date pfkdUpdatedDt;


}
