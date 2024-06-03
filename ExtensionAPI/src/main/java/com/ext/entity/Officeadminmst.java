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
@Table(name = "officeadminmst")
@Data
public class Officeadminmst implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "oam_id")
	private Long oamId;
	
	@Column(name = "oam_Name")
	private String oamName;
	
	@Column(name = "oam_Type")
	private String oamType;
	
	@Column(name = "oam_Mobileno")
	private String oamMobileno;
	
	@Column(name = "oam_Emailid")
	private String oamEmailid;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "oam_Dob")
	private Date oamDob;
	
	@Column(name = "oam_Password")
	private String oamPassword;
	
	@Column(name = "oam_Profilepic")
	private String oamProfilepic;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "oam_createdDt")
	private Date oamCreateddt;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "oam_updatedDt")
	private Date oamUpdateddt;
	
	@Column(name = "oam_user_type")
	private String oamUserType;
	
	@Column(name = "oam_created_by")
	private String oamCreatedBy;
	
	@Column(name = "oam_updated_by")
	private String oamupdatedBy;
	
	@Column(name = "oam_user_role")
	private String oamUserRole;
	
	@Column(name = "oam_pwd")
	private String oamPwd;

}
