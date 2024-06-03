package com.ext.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bussinessformdtl")
@Data
public class Bussinessformdtl implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Company_id")
	private Long companyId;
	
	@Column(name = "Company_name")
	private String companyName;
	
	@Column(name = "Company_type")
	private String companyType;
	
	@Column(name = "Company_mobileno")
	private String companyMobileno;
	
	private String companyEmailid;
	
	@Column(name = "Company_password")
	private String companyPassword;
	
	@Column(name = "company_user_type")
	private String companyUserTp;
	
	@Column(name = "company_created_by")
	private String companyCreatedBy;
	
	@Column(name = "company_updated_by")
	private String companyUpdatedBy;
	
	@Column(name = "company_pwd")
	private String companyPwd;

}
