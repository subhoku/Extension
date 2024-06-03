package com.ext.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ext.entity.Bussinessformdtl;
import com.ext.entity.User;
import com.ext.model.BussinessformdtlMdl;
import com.ext.repository.BussinessformdtlRepository;
import com.ext.repository.UserRepository;
import com.ext.service.BussinessformdtlService;
import com.ext.util.CommonUtils;

@Service
public class BussinessformdtlServiceImpl implements BussinessformdtlService {
   @Autowired
	private BussinessformdtlRepository repo;
   
   @Autowired
   private UserRepository userRepo;
   
   public static final Logger logger = LogManager.getLogger(BussinessformdtlServiceImpl.class.getName());
   
	@Override
	public int addUserDtl(BussinessformdtlMdl model) throws Exception {
		User uentt=null;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Bussinessformdtl entt=new Bussinessformdtl();
		entt.setCompanyName(CommonUtils.isNull(model.getCompanyName())?"":model.getCompanyName());
		entt.setCompanyEmailid(CommonUtils.isNull(model.getCompanyEmailid())?"":model.getCompanyEmailid());
		entt.setCompanyMobileno(CommonUtils.isNull(model.getCompanyMobileno())?"":model.getCompanyMobileno());
		entt.setCompanyType(CommonUtils.isNull(model.getCompanyType())?"":model.getCompanyType());
		entt.setCompanyPwd(CommonUtils.isNull(model.getCompanyPassword())?"":model.getCompanyPassword());
		entt.setCompanyPassword(CommonUtils.isNull(model.getCompanyPassword())?"":passwordEncoder.encode(model.getCompanyPassword()));
		entt.setCompanyUserTp("SB");
		entt.setCompanyCreatedBy(model.getUserId());
		Bussinessformdtl bussinessformdtl=repo.saveAndFlush(entt);
		if(!CommonUtils.isNull(bussinessformdtl)) {
			if(!CommonUtils.isNull(bussinessformdtl.getCompanyEmailid()) && !CommonUtils.isNull(bussinessformdtl.getCompanyPassword())) {
				User user=new User();
				user.setEmail(bussinessformdtl.getCompanyEmailid());
				user.setPassword(bussinessformdtl.getCompanyPassword());
				user.setType(bussinessformdtl.getCompanyType());
				user.setRefid(bussinessformdtl.getCompanyId());
				user.setOrgname(CommonUtils.isNull(bussinessformdtl.getCompanyName())?"":bussinessformdtl.getCompanyName());
				user.setFromtbl("bussinessformdtl");
				user.setUType("SB");
				user.setURole("1");
				uentt=userRepo.saveAndFlush(user);
			}
			if(!CommonUtils.isNull(bussinessformdtl) && !CommonUtils.isNull(uentt)) {
				return 1;
			}else {
				return 0;
			}
			
		}else {
			return 0;
		}
			
	}

	@Override
	public int updateUserDtl(BussinessformdtlMdl model) throws Exception {
		User uentt=null;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Bussinessformdtl bussinessformdtl=null;
		Bussinessformdtl entt=repo.getReferenceById(Long.parseLong(model.getCompanyId()));
		if(!CommonUtils.isNull(entt)) {
		entt.setCompanyName(CommonUtils.isNull(model.getCompanyName())?entt.getCompanyName():model.getCompanyName());
		entt.setCompanyEmailid(CommonUtils.isNull(model.getCompanyEmailid())?entt.getCompanyEmailid():model.getCompanyEmailid());
		entt.setCompanyMobileno(CommonUtils.isNull(model.getCompanyMobileno())?entt.getCompanyMobileno():model.getCompanyMobileno());
		entt.setCompanyType(CommonUtils.isNull(model.getCompanyType())?entt.getCompanyType():model.getCompanyType());
		entt.setCompanyPwd(CommonUtils.isNull(model.getCompanyPassword())?entt.getCompanyPassword():model.getCompanyPassword());
		entt.setCompanyPassword(CommonUtils.isNull(model.getCompanyPassword())?entt.getCompanyPassword():passwordEncoder.encode(model.getCompanyPassword()));
		entt.setCompanyUserTp(CommonUtils.isNull(model.getCompanyUserTp())?entt.getCompanyUserTp():model.getCompanyUserTp());
		entt.setCompanyUpdatedBy(model.getUserId());
		bussinessformdtl=repo.saveAndFlush(entt);
		}
		
		if(!CommonUtils.isNull(bussinessformdtl)) {
				if(!CommonUtils.isNull(bussinessformdtl.getCompanyEmailid()) && !CommonUtils.isNull(bussinessformdtl.getCompanyPassword())) {
					Optional<User> opt=userRepo.findByRefid(bussinessformdtl.getCompanyId());
					if(opt.isPresent()) {
					User user=opt.get();	
					user.setEmail(CommonUtils.isNull(bussinessformdtl.getCompanyEmailid())?user.getEmail():bussinessformdtl.getCompanyEmailid());
					user.setPassword(CommonUtils.isNull(bussinessformdtl.getCompanyPassword())?user.getPassword():bussinessformdtl.getCompanyPassword() );
					user.setType(CommonUtils.isNull(bussinessformdtl.getCompanyType())?user.getType():bussinessformdtl.getCompanyType());
					user.setRefid(bussinessformdtl.getCompanyId());
					user.setOrgname(CommonUtils.isNull(bussinessformdtl.getCompanyName())?user.getOrgname() : bussinessformdtl.getCompanyName());
					user.setFromtbl("bussinessformdtl");
					user.setUType("SB");
					user.setURole("1");
					uentt=userRepo.saveAndFlush(user);
					}
				}
				if(!CommonUtils.isNull(bussinessformdtl) && !CommonUtils.isNull(uentt)) {
					return 1;
				}else {
					return 0;
				}
		}else {
			return 0;
		}
	}

	@Override
	public int deleteUserDtl(Long Id) throws Exception {
		repo.deleteById(Id);
		Optional<User> opt=userRepo.findByRefid(Id);
		if(!CommonUtils.isNull(opt.get())) {
			userRepo.deleteById(opt.get().getId());
		}
		return 1;
	}

	@Override
	public BussinessformdtlMdl fetchUserById(String id) throws Exception {
		BussinessformdtlMdl mdl=null;
		Optional<Bussinessformdtl> opt=repo.findById(Long.parseLong(id));
		if(opt.isPresent()) {
			Bussinessformdtl dtl= opt.get();
			mdl=new BussinessformdtlMdl();
			mdl.setCompanyId(String.valueOf(dtl.getCompanyId()));
			mdl.setCompanyName(dtl.getCompanyName());
			mdl.setCompanyEmailid(dtl.getCompanyEmailid());
			mdl.setCompanyMobileno(dtl.getCompanyMobileno());
			mdl.setCompanyType(String.valueOf(dtl.getCompanyType()));
			mdl.setCompanyPassword(String.valueOf(dtl.getCompanyPwd()));
		}
		return mdl;
		
	}

	@Override
	public List<BussinessformdtlMdl> fetchAllUsersDtl() throws Exception {
		List<BussinessformdtlMdl> mdlst=new ArrayList<BussinessformdtlMdl>();
		List<Bussinessformdtl>dtlst=repo.findAll();
		
		dtlst.forEach(dtl->{
			BussinessformdtlMdl mdl=new BussinessformdtlMdl();
			mdl.setCompanyId(String.valueOf(dtl.getCompanyId()));
			mdl.setCompanyName(dtl.getCompanyName());
			mdl.setCompanyEmailid(dtl.getCompanyEmailid());
			mdl.setCompanyMobileno(dtl.getCompanyMobileno());
			mdl.setCompanyType(String.valueOf(dtl.getCompanyType()));
			mdl.setCompanyPassword(String.valueOf(dtl.getCompanyPwd()));
			mdlst.add(mdl);
		});
		return mdlst;
	}

	@Override
	public List<BussinessformdtlMdl> fetchAllUsersDtlByLogin(String id) throws Exception {
		List<Bussinessformdtl> findByCompanyCreatedBy = repo.findByCompanyCreatedBy(id);
		List<BussinessformdtlMdl> mdlst=new ArrayList<BussinessformdtlMdl>();
		findByCompanyCreatedBy.forEach(dtl->{
			BussinessformdtlMdl mdl=new BussinessformdtlMdl();
			mdl.setCompanyId(String.valueOf(dtl.getCompanyId()));
			mdl.setCompanyName(dtl.getCompanyName());
			mdl.setCompanyEmailid(dtl.getCompanyEmailid());
			mdl.setCompanyMobileno(dtl.getCompanyMobileno());
			mdl.setCompanyType(String.valueOf(dtl.getCompanyType()));
			mdl.setCompanyPassword(String.valueOf(dtl.getCompanyPwd()));
			mdlst.add(mdl);
		});
		return mdlst;
	}

}
