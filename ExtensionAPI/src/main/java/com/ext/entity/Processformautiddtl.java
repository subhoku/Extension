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
@Table(name = "processformautiddtl")
@Data
public class Processformautiddtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pfd_id")
	private Long pfdId;
	
	@Column(name = "pfd_clnt_cmpn_name")
	private String pfdClntCmpnName;
	
	@Column(name = "pfd_clnt_cmpn_Website")
	private String pfdClntCmpnWebsite;
	
	@Column(name = "pfd_clnt_proj_name")
	private String pfdClntProjName;
	
	@Column(name = "pfd_clnt_proj_type")
	private String pfdClntProjType;
	
	@Column(name = "pfd_clnt_proj_sourcelink")
	private String pfdClntProjSourcelink;
	
	@Column(name = "pfd_clnt_proj_noOfContracts")
	private String pfdClntProjNoofcontracts;
	
	@Column(name = "pfd_clnt_proj_nameOfContracts")
	private String pfdClntProjNameofcontracts;
	
	@Column(name = "pfd_clnt_proj_AuditedBy")
	private String pfdClntProjAuditedby;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "pfd_clnt_proj_AuditingDate")
	private Date pfdClntProjAuditingdate;
	
	@Column(name = "pfd_clnt_proj_AuditedReportsLink")
	private String pfdClntProjAuditedreportslink;
	
	@Column(name = "pfd_clnt_proj_TrustScore")
	private String pfdClntProjTrustscore;
	
	@Column(name = "pfd_clnt_proj_TotalVolume")
	private String pfdClntProjTotalvolume;
	
	@Column(name = "pfd_clnt_proj_circulatingsupply")
	private String pfdClntProjCirculatingsupply; 
	
	@Column(name = "pfd_clnt_proj_MarketCap")
	private String pfdClntProjMarketcap;
	
	@Column(name = "pfd_clnt_proj_CoinRanking")
	private String pfdClntProjCoinranking;
	
	@Column(name = "pfd_clnt_proj_TokenLaunched")
	private String pfdClntProjTokenlaunched; 
	
	@Column(name = "pfd_clnt_proj_tech_used")
	private String pfdClntProjTechUsed; 
	
	@Column(name = "pfd_clnt_proj_Clas_of_bl_chn")
	private String pfdClntProjClasOfBlChn; 
	
	@Column(name = "pfd_clnt_proj_typ_of_tkn")
	private String pfdClntProjTypOfTkn; 
	
	@Column(name = "pfd_clnt_proj_tkn_standrd")
	private String pfdClntProjTknStandrd;
	
	@Column(name = "pfd_clnt_proj_utility_of_coin")
	private String pfdClntProjUtilityOfCoin; 
	
	@Column(name = "pfd_clnt_proj_backed_by_bcoin")
	private String pfdClntProjBackedByBcoin; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "pfd_clnt_created_dt")
	private Date pfdClntCreatedDt; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "pfd_clnt_updated_dt")
	private Date pfdClntUpdatedDt;
	
	@Column(name = "pfd_created_by")
	private String pfdCreatedBy; 
	
	@Column(name = "pfd_updated_by")
	private String pfdUpdatedBy; 
	
	@Column(name = "pfd_status")
	private String pfdStatus; 

}
