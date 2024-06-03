package com.ext.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.ext.model.ProcessformautiddtlMdl;
import com.ext.model.ResponseHeaderModel;
import com.ext.service.ProcessformautiddtlService;
import com.ext.util.CommonUtils;
import com.ext.util.Constants;
import com.google.gson.Gson;

@CrossOrigin(maxAge = 3600)
@RestController
public class ProcessformautiddtlController {
	@Autowired
	private ProcessformautiddtlService service;
	
	public static final Logger logger = LogManager.getLogger(ProcessformautiddtlController.class.getName());
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_POST_AUDITDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseHeaderModel saveData(@RequestBody String requestParams,HttpServletRequest request){
		CommonModel coModel=new CommonModel();
		String errMsg = "", errCode = "";
		ResponseHeaderModel responseHeaderModel = new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		try {
		if (requestParams.contains("postData")) {
			JSONObject postObj = jsonObject.getJSONObject("postData");
			Gson gson = new Gson();
			ProcessformautiddtlMdl model=gson.fromJson(postObj.toString(), ProcessformautiddtlMdl.class);
			String auditDt=model.getPfdClntProjAuditingdate();
			if(!CommonUtils.validateJavaDate(auditDt)) {
				errMsg="Invalid Date,please enter date in dd/mm/yyyy fomat";
				errCode="5000";
			}
			if(CommonUtils.isNull(errMsg) && CommonUtils.isNull(errCode)) {
				int count=service.addProcessformautiddtl(model);
				if(count>0){
					responseHeaderModel.setStatusMsg("S");
				}else{
					responseHeaderModel.setStatus("F");
				}
			}else {
				responseHeaderModel.setStatusMsg("F");
				responseHeaderModel = CommonUtils.setResponseModel("1", errCode,errMsg);
				coModel.setResponseHeader(responseHeaderModel);
			}
			
			
			responseHeaderModel.setTs("1");
			responseHeaderModel.setTxn(dateFormat.format(new Date()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseHeaderModel.setStatus("F");
			responseHeaderModel.setErrMsg(e.getMessage());
		}
		return responseHeaderModel;
	}
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_UPDATE_AUDITDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseHeaderModel updateData(@RequestBody String requestParams,HttpServletRequest request){
		String errMsg = "", errCode = "";
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel responseHeaderModel = new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		try {
		if (requestParams.contains("updateData")) {
			JSONObject postObj = jsonObject.getJSONObject("updateData");
			Gson gson = new Gson();
			ProcessformautiddtlMdl model=gson.fromJson(postObj.toString(), ProcessformautiddtlMdl.class);
			String auditDt=model.getPfdClntProjAuditingdate();
//			if(!CommonUtils.validateJavaDate(auditDt)) {
//				errMsg="Invalid Date,please enter date in dd/mm/yyyy fomat";
//				errCode="5000";
//			}
			if(CommonUtils.isNull(errMsg) && CommonUtils.isNull(errCode)) {
			int count=service.updateProcessformautiddtl(model);
			if(count>0){
				responseHeaderModel.setStatusMsg("S");
			}else{
				responseHeaderModel.setStatus("F");
			}
			}else {
				responseHeaderModel.setStatusMsg("F");
				responseHeaderModel = CommonUtils.setResponseModel("1", errCode,errMsg);
				coModel.setResponseHeader(responseHeaderModel);
			}
			responseHeaderModel.setTs("1");
			responseHeaderModel.setTxn(dateFormat.format(new Date()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseHeaderModel.setStatus("F");
			responseHeaderModel.setErrMsg(e.getMessage());
		}
		return responseHeaderModel;
	}
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_DELETE_AUDITDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseHeaderModel deleteById(@RequestBody String requestParams,HttpServletRequest request){
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		String id=null;
		try {
			if (requestParams.contains("deleteData")) {
				JSONObject postObj = jsonObject.getJSONObject("deleteData");
				id=postObj.optString("id");
				int count=service.deleteProcessformautiddtl(Long.parseLong(id));
				if(count>0){
					headerModel.setStatusMsg("S");
				}else{
					headerModel.setStatus("F");
				}
				headerModel.setTs("1");
				headerModel.setTxn(dateFormat.format(new Date()));
				}
			} catch (Exception e) {
				e.printStackTrace();
				headerModel.setStatus("F");
				headerModel.setErrMsg(e.getMessage());
			}
		
		return headerModel;
	}
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_FETCH_AUDITDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseEntity<CommonModel> fetchAllData(@RequestBody String requestParams,HttpServletRequest request){
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		List<ProcessformautiddtlMdl> lst=null;
		JSONObject jsonObject = new JSONObject(requestParams);
		String id=null;
		
		if (requestParams.contains("fetchData")) {
			JSONObject fetchObj = jsonObject.getJSONObject("fetchData");
			id = fetchObj.optString("id");
		}
		
		try {
			if(!CommonUtils.isNull(id)) {
				lst = service.fetchAllDtlByLogin(id);
			}else {
				lst = service.fetchAllDtl();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!CommonUtils.isNull(lst) && lst.size()>0){
			coModel.setProcessformautiddtlMdlst(lst);
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
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_FETCH_BY_ID_AUDITDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseEntity<CommonModel> fetchById(@RequestBody String requestParams,HttpServletRequest request){
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		String id=null;
		
		if (requestParams.contains("fetchData")) {
			JSONObject fetchObj = jsonObject.getJSONObject("fetchData");
			id = fetchObj.optString("id");
		}
		ProcessformautiddtlMdl auditMdl = null;
		try {
			auditMdl = service.fetchById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!CommonUtils.isNull(auditMdl)){
			coModel.setProcessformautiddtlMdl(auditMdl);
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
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_FETCH_AUDITDTLBYSTATUS,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseEntity<CommonModel> fetchAllDataByStatus(){
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		List<ProcessformautiddtlMdl> lst=null;
		try {
			    String status="P";
				lst = service.fetchAllDtlByStatus(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!CommonUtils.isNull(lst) && lst.size()>0){
			coModel.setProcessformautiddtlMdlst(lst);
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
