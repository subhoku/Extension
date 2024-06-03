package com.ext.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ext.entity.Processformkycdtl;
import com.ext.model.ProcessformkycdtlMdl;
import com.ext.repository.ProcessformkycdtlRepository;
import com.ext.service.ProcessformkycdtlService;
import com.ext.util.CommonUtils;

@Service
public class ProcessformkycdtlServiceImpl implements ProcessformkycdtlService {
	@Autowired
	private ProcessformkycdtlRepository repo;
	
	public static final Logger logger = LogManager.getLogger(ProcessformkycdtlServiceImpl.class.getName());
	
	@Override
	public int addProcessformkycdtl(ProcessformkycdtlMdl model) throws Exception {
		Processformkycdtl entt=new Processformkycdtl();
		entt.setPfkdClntCmpnName(CommonUtils.isNull(model.getPfkdClntCmpnName())?"":model.getPfkdClntCmpnName());
		entt.setPfkdClntCmpnWebsite(CommonUtils.isNull(model.getPfkdClntCmpnWebsite())?"":model.getPfkdClntCmpnWebsite());
		entt.setPfkdClntProjName(CommonUtils.isNull(model.getPfkdClntProjName())?"":model.getPfkdClntProjName());
		entt.setPfkdClntProjStatus(CommonUtils.isNull(model.getPfkdClntProjStatus())?"":model.getPfkdClntProjStatus());
		entt.setPfkdCreatedDate(new Date());
		Processformkycdtl kycDtl = repo.saveAndFlush(entt);
		if(!CommonUtils.isNull(kycDtl))
		return 1;
		else
			return 0;
	}

	@Override
	public int updateProcessformkycdtl(ProcessformkycdtlMdl model) throws Exception {
		Processformkycdtl kycDtl=null;
		Processformkycdtl entt=repo.getReferenceById(Long.parseLong(model.getPfkdId()));
		if(!CommonUtils.isNull(entt)) {
			entt.setPfkdClntCmpnName(CommonUtils.isNull(model.getPfkdClntCmpnName())?entt.getPfkdClntCmpnName():model.getPfkdClntCmpnName());
			entt.setPfkdClntCmpnWebsite(CommonUtils.isNull(model.getPfkdClntCmpnWebsite())?entt.getPfkdClntCmpnWebsite():model.getPfkdClntCmpnWebsite());
			entt.setPfkdClntProjName(CommonUtils.isNull(model.getPfkdClntProjName())?entt.getPfkdClntProjName():model.getPfkdClntProjName());
			entt.setPfkdClntProjStatus(CommonUtils.isNull(model.getPfkdClntProjStatus())?entt.getPfkdClntProjStatus():model.getPfkdClntProjStatus());
			entt.setPfkdUpdatedDt(new Date());
			kycDtl = repo.saveAndFlush(entt);
		}
		
		if(!CommonUtils.isNull(kycDtl))
		return 1;
		else
			return 0;
	}

	@Override
	public int deleteProcessformkycdtl(Long Id) throws Exception {
		repo.deleteById(Id);
		return 1;
	}

	@Override
	public ProcessformkycdtlMdl fetchById(String id) throws Exception {
		ProcessformkycdtlMdl mdl=null;
		Optional<Processformkycdtl> opt=repo.findById(Long.parseLong(id));
		if(opt.isPresent()) {
			Processformkycdtl dtl= opt.get();
			mdl=new ProcessformkycdtlMdl();
			mdl.setPfkdId(String.valueOf(dtl.getPfkdId()));
			mdl.setPfkdClntCmpnName(dtl.getPfkdClntCmpnName());
			mdl.setPfkdClntCmpnWebsite(dtl.getPfkdClntCmpnWebsite());
			mdl.setPfkdClntProjName(dtl.getPfkdClntProjName());
			mdl.setPfkdClntProjStatus(dtl.getPfkdClntProjStatus());
		}
		return mdl;
	}

	@Override
	public List<ProcessformkycdtlMdl> fetchAllDtl() throws Exception {
		List<ProcessformkycdtlMdl> mdlst=new ArrayList<ProcessformkycdtlMdl>();
		List<Processformkycdtl>dtlst=repo.findAll();
		dtlst.forEach(dtl->{
			ProcessformkycdtlMdl mdl=new ProcessformkycdtlMdl();
			mdl.setPfkdId(String.valueOf(dtl.getPfkdId()));
			mdl.setPfkdClntCmpnName(dtl.getPfkdClntCmpnName());
			mdl.setPfkdClntCmpnWebsite(dtl.getPfkdClntCmpnWebsite());
			mdl.setPfkdClntProjName(dtl.getPfkdClntProjName());
			mdl.setPfkdClntProjStatus(dtl.getPfkdClntProjStatus());
			mdlst.add(mdl);
		});
		return mdlst;
	}

	@Override
	public List<ProcessformkycdtlMdl> fetchAllDtlByStatus(String status) throws Exception {
		List<ProcessformkycdtlMdl> mdlst=new ArrayList<ProcessformkycdtlMdl>();
		List<Processformkycdtl>dtlst=repo.findByPfkdClntProjStatus(status);
		dtlst.forEach(dtl->{
			ProcessformkycdtlMdl mdl=new ProcessformkycdtlMdl();
			mdl.setPfkdId(String.valueOf(dtl.getPfkdId()));
			mdl.setPfkdClntCmpnName(dtl.getPfkdClntCmpnName());
			mdl.setPfkdClntCmpnWebsite(dtl.getPfkdClntCmpnWebsite());
			mdl.setPfkdClntProjName(dtl.getPfkdClntProjName());
			mdl.setPfkdClntProjStatus(dtl.getPfkdClntProjStatus());
			mdlst.add(mdl);
		});
		return mdlst;
	}

}
