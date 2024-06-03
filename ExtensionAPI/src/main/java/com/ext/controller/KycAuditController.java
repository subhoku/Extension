package com.ext.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ext.model.CommonModel;
import com.ext.model.KycAuditDtlMdl;
import com.ext.model.ResponseHeaderModel;
import com.ext.service.KycAuditService;
import com.ext.util.CommonUtils;
import com.ext.util.Constants;

@CrossOrigin(maxAge = 3600)
@RestController
public class KycAuditController {
	@Autowired
	private KycAuditService service;
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_FETCH_KYCAUDITDTL_BY_URL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseEntity<CommonModel> fetchById(@RequestBody String requestParams,HttpServletRequest request){
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		String companyurl=null;
		
		if (requestParams.contains("fetchData")) {
			JSONObject fetchObj = jsonObject.getJSONObject("fetchData");
			companyurl = fetchObj.optString("companyurl");
		}
		List<KycAuditDtlMdl> getkycauditdetailbycompany =null;
		try {
			getkycauditdetailbycompany = service.getkycauditdetailbycompany(companyurl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!CommonUtils.isNull(getkycauditdetailbycompany)&&getkycauditdetailbycompany.size()>0){
			coModel.setKycAuditDtlMdlst(getkycauditdetailbycompany);
			headerModel.setStatusMsg("S");
			headerModel.setTs("1");
			headerModel.setTxn(dateFormat.format(new Date()));
			coModel.setResponseHeader(headerModel);
		}else{
			headerModel.setStatusMsg("F");
			headerModel.setErrMsg("No Record Found");
			headerModel.setTs("0");
			headerModel.setTxn(dateFormat.format(new Date()));
			coModel.setResponseHeader(headerModel);
		}
		
		return new ResponseEntity<CommonModel>(coModel,HttpStatus.OK);
	}

}
