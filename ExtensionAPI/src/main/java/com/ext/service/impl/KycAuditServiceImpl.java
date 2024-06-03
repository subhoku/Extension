package com.ext.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ext.model.KycAuditDtlMdl;
import com.ext.model.KycAuditDtlMdlMapper;
import com.ext.service.KycAuditService;

@Service
public class KycAuditServiceImpl implements KycAuditService {
	@Autowired
    private JdbcTemplate jt;
	@Override
	public List<KycAuditDtlMdl> getkycauditdetailbycompany(String company) {
		String sql="SELECT t1.pfkd_clnt_cmpn_name, t1.pfkd_clnt_proj_name, t1.pfkd_clnt_proj_status,t2.pfd_clnt_cmpn_name,t2.pfd_clnt_proj_name,t2.pfd_clnt_proj_type,t2.pfd_clnt_proj_sourcelink,t2.pfd_clnt_proj_no_of_contracts,t2.pfd_clnt_proj_name_of_contracts,t2.pfd_clnt_proj_audited_by,t2.pfd_clnt_proj_auditing_date,t2.pfd_clnt_proj_audited_reports_link,t2.pfd_clnt_proj_trust_score,t2.pfd_clnt_proj_total_volume,t2.pfd_clnt_proj_circulatingsupply,t2.pfd_clnt_proj_market_cap,t2.pfd_clnt_proj_coin_ranking,t2.pfd_clnt_proj_token_launched,t2.pfd_clnt_proj_clas_of_bl_chn,t2.pfd_clnt_proj_cntrct_typ,t1.pfkd_created_date FROM processformkycdtl as t1, processformautiddtl as t2 WHERE t1.pfkd_clnt_cmpn_website=t2.pfd_clnt_cmpn_website and t1.pfkd_clnt_cmpn_website=? and t2.pfd_clnt_cmpn_website=?";
        List<KycAuditDtlMdl> alldtlst=jt.query(sql,new KycAuditDtlMdlMapper(),company,company);
        return alldtlst;
	}

}
