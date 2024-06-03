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
import com.ext.model.ResponseHeaderModel;
import com.ext.model.TicketdtlMdl;
import com.ext.service.TicketdtlService;
import com.ext.util.CommonUtils;
import com.ext.util.Constants;
import com.google.gson.Gson;

@CrossOrigin(maxAge = 3600)
@RestController
public class TicketdtlController {
	@Autowired
	private TicketdtlService service;
	
	public static final Logger logger = LogManager.getLogger(TicketdtlController.class.getName());
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_POST_TKTDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseHeaderModel saveData(@RequestBody String requestParams,HttpServletRequest request){
		ResponseHeaderModel responseHeaderModel = new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		try {
		if (requestParams.contains("postData")) {
			JSONObject postObj = jsonObject.getJSONObject("postData");
			Gson gson = new Gson();
			TicketdtlMdl model=gson.fromJson(postObj.toString(), TicketdtlMdl.class);
			int count=service.addTicketdtl(model);
			if(count>0){
				responseHeaderModel.setStatusMsg("S");
			}else{
				responseHeaderModel.setStatus("F");
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
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_UPDATE_TKTDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseHeaderModel updateData(@RequestBody String requestParams,HttpServletRequest request){
		ResponseHeaderModel responseHeaderModel = new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		try {
		if (requestParams.contains("updateData")) {
			JSONObject postObj = jsonObject.getJSONObject("updateData");
			Gson gson = new Gson();
			TicketdtlMdl model=gson.fromJson(postObj.toString(), TicketdtlMdl.class);
			int count=service.updateTicketdtl(model);
			if(count>0){
				responseHeaderModel.setStatusMsg("S");
			}else{
				responseHeaderModel.setStatus("F");
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
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_DELETE_TKTDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseHeaderModel deleteById(@RequestBody String requestParams,HttpServletRequest request){
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		JSONObject jsonObject = new JSONObject(requestParams);
		String id=null;
		try {
			if (requestParams.contains("deleteData")) {
				JSONObject postObj = jsonObject.getJSONObject("deleteData");
				id=postObj.optString("id");
				int count=service.deleteTicketdtl(Long.parseLong(id));
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
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_FETCH_TKTDTL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseEntity<CommonModel> fetchAllData(){
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		List<TicketdtlMdl> lst=null;
		try {
			lst = service.fetchAllDtl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!CommonUtils.isNull(lst) && lst.size()>0){
			coModel.setTicketdtlMdlst(lst);
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
	
	@RequestMapping(method=RequestMethod.POST,value=Constants.CONST_FETCH_TKTDTL_BY_ID,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
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
		TicketdtlMdl tkt = null;
		try {
			tkt = service.fetchById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!CommonUtils.isNull(tkt)){
			coModel.setTicketdtlMdl(tkt);
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
