package com.ext.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ext.entity.User;
import com.ext.model.AuthRequest;
import com.ext.model.AuthResponse;
import com.ext.model.CommonModel;
import com.ext.model.ResponseHeaderModel;
import com.ext.model.UserDetails;
import com.ext.util.CommonUtils;
import com.ext.util.JwtTokenUtil;
import com.google.gson.Gson;

@RestController
public class AuthApi {
	@Autowired
	AuthenticationManager authManager;
	@Autowired
	JwtTokenUtil jwtUtil;
	
	@PostMapping("/auth/login")
    public ResponseEntity<CommonModel> login(@RequestBody String request) {
		JSONObject jsonObject = new JSONObject(request);
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
        try {
        	JSONObject postObj = jsonObject.getJSONObject("loginRequest");
        	Gson gson = new Gson();
			AuthRequest model=gson.fromJson(postObj.toString(), AuthRequest.class);
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    		model.getEmail(), 
                    		model.getPassword()
                            )
            ); 
            User user = (User) authentication.getPrincipal();
            if(!CommonUtils.isNull(user)) {
            	String accessToken = jwtUtil.generateAccessToken(user);
                AuthResponse response = new AuthResponse();
                UserDetails userDetails=new UserDetails();
                response.setStatusMsg("S");
                userDetails.setAccessToken(accessToken);
                userDetails.setOrgname(user.getOrgname());
                userDetails.setType(user.getType());
                userDetails.setFromTbl(user.getFromtbl());
                userDetails.setRefid(String.valueOf(user.getRefid()));
                userDetails.setUType(user.getUType());
                userDetails.setURole(user.getURole());
                userDetails.setProfilePic(user.getProfilePic());
                response.setUserDetails(userDetails);
                
                coModel.setUserDetails(userDetails);
    			headerModel.setStatusMsg("S");
    			headerModel.setTs("1");
    			headerModel.setTxn(dateFormat.format(new Date()));
    			coModel.setResponseHeader(headerModel);
            }else {
            	headerModel.setStatusMsg("F");
    			headerModel.setErrMsg("No Record Found");
    			headerModel.setTs("0");
    			headerModel.setTxn(dateFormat.format(new Date()));
    			coModel.setResponseHeader(headerModel);
            }
        } catch (BadCredentialsException ex) {
        	headerModel.setStatusMsg("F");
			headerModel.setErrMsg(ex.getMessage());
			headerModel.setTs("0");
			headerModel.setTxn(dateFormat.format(new Date()));
			coModel.setResponseHeader(headerModel);
        }catch (Exception ex) {
        	headerModel.setStatusMsg("F");
			headerModel.setErrMsg(ex.getMessage());
			headerModel.setTs("0");
			headerModel.setTxn(dateFormat.format(new Date()));
			coModel.setResponseHeader(headerModel);
		}
        return new ResponseEntity<CommonModel>(coModel,HttpStatus.OK);
    }
	
	@PostMapping("/auth/logout")
    public ResponseHeaderModel logout(@RequestBody String request) {
		JSONObject jsonObject = new JSONObject(request);
		CommonModel coModel=new CommonModel();
		ResponseHeaderModel headerModel=new ResponseHeaderModel();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
        try {
        	JSONObject postObj = jsonObject.getJSONObject("logoutRequest");
        	Gson gson = new Gson();
			AuthRequest model=gson.fromJson(postObj.toString(), AuthRequest.class);
            boolean accessToken = jwtUtil.validateAccessToken(postObj.optString("accessToken"));
            AuthResponse response = new AuthResponse();
            if(accessToken) {
            headerModel.setStatusMsg("S");
            response.setUserDetails(null);
            }
            else {
            headerModel.setStatusMsg("F");
            }
            headerModel.setTs("1");
			headerModel.setTxn(dateFormat.format(new Date()));
             
        } catch (BadCredentialsException ex) {
        	ex.printStackTrace();
			headerModel.setStatusMsg("F");
			headerModel.setErrMsg(ex.getMessage());
        }catch (Exception ex) {
        	ex.printStackTrace();
			headerModel.setStatusMsg("F");
			headerModel.setErrMsg(ex.getMessage());
		}
        return headerModel;
    }

}
