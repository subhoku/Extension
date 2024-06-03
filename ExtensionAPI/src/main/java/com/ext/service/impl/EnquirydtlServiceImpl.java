package com.ext.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ext.entity.Enquirydtl;
import com.ext.model.EnquirydtlMdl;
import com.ext.repository.EnquirydtlRepository;
import com.ext.service.EnquirydtlService;
import com.ext.util.CommonUtils;

@Service
public class EnquirydtlServiceImpl implements EnquirydtlService {
	@Autowired
	private EnquirydtlRepository repo;
	
	public static final Logger logger = LogManager.getLogger(EnquirydtlServiceImpl.class.getName()); 
	
	@Override
	public int addEnquirydtl(EnquirydtlMdl model) throws Exception {
		Enquirydtl entt=new Enquirydtl();
		entt.setEnqName(CommonUtils.isNull(model.getEnqName())?"":model.getEnqName());
		entt.setEnqEmailid(CommonUtils.isNull(model.getEnqEmailid())?"":model.getEnqEmailid());
		entt.setEnqMobileno(CommonUtils.isNull(model.getEnqMobileno())?"":model.getEnqMobileno());
		entt.setEnqMsg(CommonUtils.isNull(model.getEnqMsg())?"":model.getEnqMsg());
		entt.setEnqCreatedDt(new Date());
		Enquirydtl enqDtl = repo.saveAndFlush(entt);
		if(!CommonUtils.isNull(enqDtl))
		return 1;
		else
			return 0;
	}
	
	@Override
	public int updateEnquirydtl(EnquirydtlMdl model) throws Exception {
		Enquirydtl enqDtl=null;
		Enquirydtl entt=repo.getReferenceById(Long.parseLong(model.getEnqId()));
		if(!CommonUtils.isNull(entt)) {
			entt.setEnqName(CommonUtils.isNull(model.getEnqName())?entt.getEnqName():model.getEnqName());
			entt.setEnqEmailid(CommonUtils.isNull(model.getEnqEmailid())?entt.getEnqEmailid():model.getEnqEmailid());
			entt.setEnqMobileno(CommonUtils.isNull(model.getEnqMobileno())?entt.getEnqMobileno():model.getEnqMobileno());
			entt.setEnqMsg(CommonUtils.isNull(model.getEnqMsg())?entt.getEnqMsg():model.getEnqMsg());
			enqDtl = repo.saveAndFlush(entt);
		}
		
		if(!CommonUtils.isNull(enqDtl))
		return 1;
		else
			return 0;
	}

	@Override
	public int deleteEnquirydtl(Long Id) throws Exception {
		repo.deleteById(Id);
		return 1;
	}

	@Override
	public EnquirydtlMdl fetchById(String id) throws Exception {
		EnquirydtlMdl mdl=null;
		Optional<Enquirydtl> opt=repo.findById(Long.parseLong(id));
		if(opt.isPresent()) {
			Enquirydtl dtl= opt.get();
			mdl=new EnquirydtlMdl();
			mdl.setEnqId(String.valueOf(dtl.getEnqId()));
			mdl.setEnqName(dtl.getEnqName());
			mdl.setEnqEmailid(dtl.getEnqEmailid());
			mdl.setEnqMobileno(dtl.getEnqMobileno());
			mdl.setEnqMsg(dtl.getEnqMsg());
		}
		return mdl;
	}

	@Override
	public List<EnquirydtlMdl> fetchAllDtl() throws Exception {
		List<EnquirydtlMdl> mdlst=new ArrayList<EnquirydtlMdl>();
		List<Enquirydtl>dtlst=repo.findAll();
		dtlst.forEach(dtl->{
			EnquirydtlMdl mdl=new EnquirydtlMdl();
			mdl.setEnqId(String.valueOf(dtl.getEnqId()));
			mdl.setEnqName(dtl.getEnqName());
			mdl.setEnqEmailid(dtl.getEnqEmailid());
			mdl.setEnqMobileno(dtl.getEnqMobileno());
			mdl.setEnqMsg(dtl.getEnqMsg());
			mdlst.add(mdl);
		});
		return mdlst;
	}

}
