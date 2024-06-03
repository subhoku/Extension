package com.ext.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

public class KycAuditDtlMdlMapper implements RowMapper<KycAuditDtlMdl> {

	@Override
	public KycAuditDtlMdl mapRow(ResultSet rs, int rowNum) throws SQLException {
		KycAuditDtlMdl mdl=new KycAuditDtlMdl();
		mdl.setPfkdClntCmpnName(rs.getString(1));     
		mdl.setPfkdClntProjName(rs.getString(2));
		mdl.setPfkdClntProjStatus (rs.getString(3));
		mdl.setPfdClntCmpnName(rs.getString(4));
		mdl.setPfdClntProjName(rs.getString(5));
		mdl.setPfdClntProjType(String.valueOf(rs.getInt(6)));
		mdl.setPfdClntProjSourcelink(rs.getString(7));
		mdl.setPfdClntProjNoofcontracts(rs.getString(8));
		mdl.setPfdClntProjNameofcontracts(rs.getString(9));
		mdl.setPfdClntProjAuditedby(rs.getString(10));
		mdl.setPfdClntProjAuditingdate(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(11)));
		mdl.setPfdClntProjAuditedreportslink(rs.getString(12));
		mdl.setPfdClntProjTrustscore(rs.getString(13));
		mdl.setPfdClntProjTotalvolume(rs.getString(14));
		mdl.setPfdClntProjCirculatingsupply(rs.getString(15));
		mdl.setPfdClntProjMarketcap(rs.getString(16));
		mdl.setPfdClntProjCoinranking(rs.getString(17));
		mdl.setPfdClntProjTokenlaunched(rs.getString(18));
		mdl.setPfdClntProjClasOfBlChn(rs.getString(19));
		mdl.setPfdClntProjCntrctTyp(rs.getString(20));
		mdl.setPfkdCreatedDate(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(11)));
		if("1".equals(mdl.getPfkdClntProjStatus())) {
			mdl.setPfkdClntProjStatus ("Done");
		}else {
			mdl.setPfkdClntProjStatus ("Pending");
		}
		return mdl;
	}

}
