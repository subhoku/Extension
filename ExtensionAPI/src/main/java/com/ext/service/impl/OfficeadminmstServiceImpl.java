package com.ext.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ext.entity.Officeadminmst;
import com.ext.entity.User;
import com.ext.model.OfficeadminmstMdl;
import com.ext.model.ResponseHeaderModel;
import com.ext.model.UploadObject;
import com.ext.repository.OfficeadminmstRepository;
import com.ext.repository.UserRepository;
import com.ext.service.OfficeadminmstService;
import com.ext.util.CommonUtils;
import com.ext.util.Constants;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@SuppressWarnings("restriction")
@Service
public class OfficeadminmstServiceImpl implements OfficeadminmstService {
	@Autowired
    private OfficeadminmstRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	public static final Logger logger = LogManager.getLogger(OfficeadminmstServiceImpl.class.getName()); 
	
	@Override
	public int addOfficeadminmst(OfficeadminmstMdl model) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		ResponseHeaderModel resp=null;
		User uentt=null;
		Officeadminmst entt=new Officeadminmst();
		entt.setOamName(CommonUtils.isNull(model.getOamName())?"":model.getOamName());
		entt.setOamEmailid(CommonUtils.isNull(model.getOamEmailid())?"":model.getOamEmailid());
		entt.setOamMobileno(CommonUtils.isNull(model.getOamMobileno())?"":model.getOamMobileno());
		entt.setOamPwd(CommonUtils.isNull(model.getOamPassword())?"":model.getOamPassword());
		entt.setOamPassword(CommonUtils.isNull(model.getOamPassword())?"":passwordEncoder.encode(model.getOamPassword()));
		entt.setOamType(CommonUtils.isNull(model.getOamType())?"":model.getOamType());
		entt.setOamDob(CommonUtils.isNull(model.getOamDob())?null:new SimpleDateFormat("dd/MM/yyyy").parse(model.getOamDob()));
		entt.setOamCreateddt(new Date());
		entt.setOamCreatedBy(CommonUtils.isNull(model.getUserId())?"":model.getUserId());
		if(!CommonUtils.isNull(model.getOamUserType()) && "SA".equals(model.getOamUserType()) && "0".equals(model.getOamUserRole())) {
			entt.setOamUserType("SA");
			entt.setOamUserRole("0");
		}else if(!CommonUtils.isNull(model.getOamUserType()) && "SB".equals(model.getOamUserType()) && "1".equals(model.getOamUserRole())) {
			entt.setOamUserType("SB");
			entt.setOamUserRole("1");
		}else {
			entt.setOamUserType("SB");
			entt.setOamUserRole("2");
		}
		if(!CommonUtils.isNull(model.getUploadObject())) {
			  resp=uploadImg(model.getUploadObject());
			  if(!CommonUtils.isNull(resp) && "S".equals(resp.getStatus())) {
				entt.setOamProfilepic(resp.getStatusMsg());
			  }else {
				  entt.setOamProfilepic(resp.getErr()); 
			  }
		}
		Officeadminmst officeadminmst = repo.saveAndFlush(entt);
		if (!CommonUtils.isNull(officeadminmst)) {
			if (!CommonUtils.isNull(officeadminmst.getOamEmailid())
					&& !CommonUtils.isNull(officeadminmst.getOamPassword())) {
				User user = new User();
				user.setEmail(officeadminmst.getOamEmailid());
				user.setPassword(officeadminmst.getOamPassword());
				user.setType(CommonUtils.isNull(officeadminmst.getOamType())?"":officeadminmst.getOamType());
				user.setRefid(officeadminmst.getOamId());
				user.setOrgname(officeadminmst.getOamName());
				user.setFromtbl("officeadminmst");
				if(!CommonUtils.isNull(officeadminmst.getOamUserType()) && "SA".equals(officeadminmst.getOamUserType()) && "0".equals(officeadminmst.getOamUserRole())) {
					user.setUType("SA");
					user.setURole("0");
				}else if(!CommonUtils.isNull(officeadminmst.getOamUserType()) && "SB".equals(officeadminmst.getOamUserType()) && "1".equals(officeadminmst.getOamUserRole())) {
					user.setUType("SB");
					user.setURole("1");
				}else {
					user.setUType("SB");
					user.setURole("2");
				}
				if(!CommonUtils.isNull(resp) && "S".equals(resp.getStatus())) {
					user.setProfilePic(officeadminmst.getOamProfilepic());
				  }else {
					  user.setProfilePic("");
				  }
				uentt = userRepo.saveAndFlush(user);
			}
			if (!CommonUtils.isNull(officeadminmst) && !CommonUtils.isNull(uentt)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	@Override
	public int updateOfficeadminmst(OfficeadminmstMdl model) throws Exception {
		Officeadminmst offcDtl=null;
		User uentt=null;
		ResponseHeaderModel resp=null;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Officeadminmst entt=repo.getReferenceById(Long.parseLong(model.getOamId()));
		if(!CommonUtils.isNull(entt)) {
			entt.setOamName(CommonUtils.isNull(model.getOamName())?entt.getOamName():model.getOamName());
			entt.setOamEmailid(CommonUtils.isNull(model.getOamEmailid())?entt.getOamEmailid():model.getOamEmailid());
			entt.setOamMobileno(CommonUtils.isNull(model.getOamMobileno())?entt.getOamMobileno():model.getOamMobileno());
			entt.setOamPwd(CommonUtils.isNull(model.getOamPassword())?entt.getOamPwd():model.getOamPassword());
			entt.setOamPassword(CommonUtils.isNull(model.getOamPassword())?entt.getOamPassword():passwordEncoder.encode(model.getOamPassword()));
			entt.setOamType(CommonUtils.isNull(model.getOamType())?entt.getOamType():model.getOamType());
			entt.setOamDob(CommonUtils.isNull(model.getOamDob())? null : CommonUtils.getDateInDMY(model.getOamDob()));
			entt.setOamUpdateddt(new Date());
			entt.setOamupdatedBy(CommonUtils.isNull(model.getUserId())?entt.getOamupdatedBy():model.getUserId());
			if(!CommonUtils.isNull(model.getOamUserType()) && "SA".equals(model.getOamUserType()) && "0".equals(model.getOamUserRole())) {
				entt.setOamUserType("SA");
				entt.setOamUserRole("0");
			}else if(!CommonUtils.isNull(model.getOamUserType()) && "SB".equals(model.getOamUserType()) && "1".equals(model.getOamUserRole())) {
				entt.setOamUserType("SB");
				entt.setOamUserRole("1");
			}else {
				entt.setOamUserType("SB");
				entt.setOamUserRole("2");
			}
			if(!CommonUtils.isNull(model.getUploadObject())) {
				  resp=uploadImg(model.getUploadObject());
				  if(!CommonUtils.isNull(resp) && "S".equals(resp.getStatus())) {
					entt.setOamProfilepic(resp.getStatusMsg());
				  }else {
					  entt.setOamProfilepic(resp.getErr()); 
				  }
			}
			offcDtl = repo.saveAndFlush(entt);
		}
		
		if (!CommonUtils.isNull(offcDtl)) {
			if (!CommonUtils.isNull(offcDtl.getOamEmailid())
					&& !CommonUtils.isNull(offcDtl.getOamPassword())) {
			    Optional<User> opt=userRepo.findByRefid(offcDtl.getOamId());
			    if(opt.isPresent()) {
			    User user=opt.get();	
				user.setEmail(CommonUtils.isNull(offcDtl.getOamEmailid())?user.getEmail():offcDtl.getOamEmailid());
				user.setPassword(CommonUtils.isNull(offcDtl.getOamPassword())?user.getPassword():offcDtl.getOamPassword() );
				user.setType(CommonUtils.isNull(offcDtl.getOamType())?user.getType():offcDtl.getOamType());
				user.setRefid(offcDtl.getOamId());
				user.setOrgname(CommonUtils.isNull(offcDtl.getOamName())?user.getOrgname():offcDtl.getOamName());
				user.setFromtbl("officeadminmst");
				if(!CommonUtils.isNull(offcDtl.getOamUserType()) && "SA".equals(offcDtl.getOamUserType()) && "0".equals(offcDtl.getOamUserRole())) {
					user.setUType("SA");
					user.setURole("0");
				}else if(!CommonUtils.isNull(offcDtl.getOamUserType()) && "SB".equals(offcDtl.getOamUserType()) && "1".equals(offcDtl.getOamUserRole())) {
					user.setUType("SB");
					user.setURole("1");
				}else {
					user.setUType("SB");
					user.setURole("2");
				}
				if(!CommonUtils.isNull(resp) && "S".equals(resp.getStatus())) {
					user.setProfilePic(offcDtl.getOamProfilepic());
				  }else {
					  user.setProfilePic("");
				  }
				uentt = userRepo.saveAndFlush(user);
				
			    }
			}
			if (!CommonUtils.isNull(offcDtl) && !CommonUtils.isNull(uentt)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	@Override
	public int deleteOfficeadminmst(Long Id) throws Exception {
		repo.deleteById(Id);
		Optional<User> opt=userRepo.findByRefid(Id);
		if(!CommonUtils.isNull(opt.get())) {
			userRepo.deleteById(opt.get().getId());
		}
		return 1;
	}

	@Override
	public OfficeadminmstMdl fetchById(String id) throws Exception {
		OfficeadminmstMdl mdl=null;
		Optional<Officeadminmst> opt=repo.findById(Long.parseLong(id));
		if(opt.isPresent()) {
			Officeadminmst dtl= opt.get();
			mdl=new OfficeadminmstMdl();
			mdl.setOamId(String.valueOf(dtl.getOamId()));
			mdl.setOamName(dtl.getOamName());
			mdl.setOamEmailid(dtl.getOamEmailid());
			mdl.setOamMobileno(dtl.getOamMobileno());
			mdl.setOamDob(CommonUtils.isNull(dtl.getOamDob())?"" : new SimpleDateFormat("dd/MM/yyyy").format(dtl.getOamDob()));
			mdl.setOamPassword(dtl.getOamPwd());
			mdl.setOamType(CommonUtils.isNull(dtl.getOamType())?"" : dtl.getOamType());
			mdl.setOamProfilepic(CommonUtils.isNull(dtl.getOamProfilepic())?"" : dtl.getOamProfilepic());
		}
		return mdl;
	}

	@Override
	public List<OfficeadminmstMdl> fetchAllDtl() throws Exception {
		List<OfficeadminmstMdl> mdlst=new ArrayList<OfficeadminmstMdl>();
		List<Officeadminmst>dtlst=repo.findAll();
		dtlst.forEach(dtl->{
			OfficeadminmstMdl mdl=new OfficeadminmstMdl();
			mdl.setOamId(String.valueOf(dtl.getOamId()));
			mdl.setOamName(dtl.getOamName());
			mdl.setOamEmailid(dtl.getOamEmailid());
			mdl.setOamMobileno(dtl.getOamMobileno());
			mdl.setOamDob(CommonUtils.isNull(dtl.getOamDob())?"":new SimpleDateFormat("dd/MM/yyyy").format(dtl.getOamDob()));
			mdl.setOamPassword(dtl.getOamPwd());
			mdl.setOamType(CommonUtils.isNull(dtl.getOamType())?"" : dtl.getOamType());
			mdl.setOamProfilepic(CommonUtils.isNull(dtl.getOamProfilepic())?"" : dtl.getOamProfilepic());
			mdlst.add(mdl);
		});
		return mdlst;
	}
	
	
	private ResponseHeaderModel uploadImg(UploadObject uploadObj) {
		ResponseHeaderModel response=new ResponseHeaderModel();
		String filepath="";
		if (uploadObj != null && uploadObj.getUploadData() != null)
	      {
	         String uploadData = uploadObj.getUploadData();
	         if (uploadData.length() > 0)
	         {
	            System.out.println(uploadData.substring(0, 100));
	            String[] splitData = uploadData.split(";");
	            if (splitData != null && splitData.length == 2)
	            {
	               String mediaType = splitData[0];
	               System.out.println(mediaType);
	               if (splitData[1] != null && splitData[1].length() > 0)
	               {
	                  String[] splitAgain = splitData[1].split(",");
	                  if (splitAgain != null && splitAgain.length == 2)
	                  {
	                     String encodingType = splitAgain[0];
	                     System.out.println(encodingType);
	                     String imageValue = splitAgain[1];
	                     
	                     byte[] imageBytes = Base64.decode(imageValue);
	                     System.out.println("File Uploaded has " + imageBytes.length + " bytes");
	                     System.out.println("Wrote to file " +Constants.IMAGE_UPLOAD_PATH + uploadObj.getFileName());
	                     filepath=Constants.IMAGE_UPLOAD_PATH + uploadObj.getFileName();
	                     File fileToWrite = new File(filepath);
	                     try
	                     {
	                        FileUtils.writeByteArrayToFile(fileToWrite, imageBytes);
	                     }
	                     catch (Exception ex)
	                     {
	                    	response.setStatus("F");
	                    	response.setErr(ex.getMessage());
	                        ex.printStackTrace();
	                     }
	                  }
	               }
	            }
	         }
	      }
	      
			/*GenericResponse resp = new GenericResponse();
			UUID randomId = UUID.randomUUID();
			resp.setId(randomId.toString().replace("\\-", ""));
			resp.setSuccess(true);
			resp.setDetailMessage("Upload file is successful.");
			ResponseEntity<GenericResponse> retVal = ResponseEntity.ok(resp);*/
		   response.setStatus("S");
		   response.setStatusMsg(filepath);
	      return response;
	}

	@Override
	public List<OfficeadminmstMdl> fetchAllDtlByLogin(String id) throws Exception {
		List<OfficeadminmstMdl> mdlst=new ArrayList<OfficeadminmstMdl>();
		
		List<Officeadminmst> findByOamCreatedBy = repo.findByOamCreatedBy(id);
		findByOamCreatedBy.forEach(dtl->{
			OfficeadminmstMdl mdl=new OfficeadminmstMdl();
			mdl.setOamId(String.valueOf(dtl.getOamId()));
			mdl.setOamName(dtl.getOamName());
			mdl.setOamEmailid(dtl.getOamEmailid());
			mdl.setOamMobileno(dtl.getOamMobileno());
			mdl.setOamDob(CommonUtils.isNull(dtl.getOamDob())?"":new SimpleDateFormat("dd/MM/yyyy").format(dtl.getOamDob()));
			mdl.setOamPassword(dtl.getOamPwd());
			mdl.setOamType(CommonUtils.isNull(dtl.getOamType())?"" : dtl.getOamType());
			mdl.setOamProfilepic(CommonUtils.isNull(dtl.getOamProfilepic())?"" : dtl.getOamProfilepic());
			mdlst.add(mdl);
		});
		return mdlst;
	}
    
}
