package com.ext.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ext.entity.Ticketdtl;
import com.ext.model.TicketdtlMdl;
import com.ext.repository.TicketdtlRepository;
import com.ext.service.TicketdtlService;
import com.ext.util.CommonUtils;

@Service
public class TicketdtlServiceImpl implements TicketdtlService {
	@Autowired
	private TicketdtlRepository repo;
	
	public static final Logger logger = LogManager.getLogger(TicketdtlServiceImpl.class.getName());

	@Override
	public int addTicketdtl(TicketdtlMdl model) throws Exception {
		Ticketdtl entt=new Ticketdtl();
		entt.setTktSubject(CommonUtils.isNull(model.getTktSubject())?"":model.getTktSubject());
		entt.setTktMassage(CommonUtils.isNull(model.getTktMassage())?"":model.getTktMassage());
		entt.setTktPriority(CommonUtils.isNull(model.getTktPriority())?"":model.getTktPriority());
		entt.setTktStatus("O");
		entt.setTktUserId(CommonUtils.isNull(model.getTktUserId())?"":model.getTktUserId());
		entt.setTktCreatedDt(new Date());
		Ticketdtl tckDtl = repo.saveAndFlush(entt);
		if(!CommonUtils.isNull(tckDtl))
		return 1;
		else
			return 0;
	}

	@Override
	public int updateTicketdtl(TicketdtlMdl model) throws Exception {
		Ticketdtl tktDtl=null;
		Ticketdtl entt=repo.getReferenceById(Long.parseLong(model.getTktId()));
		if(!CommonUtils.isNull(entt)) {
			entt.setTktSubject(CommonUtils.isNull(model.getTktSubject())?entt.getTktSubject():model.getTktSubject());
			entt.setTktMassage(CommonUtils.isNull(model.getTktMassage())?entt.getTktMassage():model.getTktMassage());
			entt.setTktPriority(CommonUtils.isNull(model.getTktPriority())?entt.getTktPriority():model.getTktPriority());
			entt.setTktStatus(CommonUtils.isNull(model.getTktStatus())?entt.getTktStatus():model.getTktStatus());
			entt.setTktUserId(CommonUtils.isNull(model.getTktUserId())?entt.getTktUserId():model.getTktUserId());
			entt.setTktUpdateddt(new Date());
			tktDtl = repo.saveAndFlush(entt);
		}
		
		if(!CommonUtils.isNull(tktDtl))
		return 1;
		else
			return 0;
	}

	@Override
	public int deleteTicketdtl(Long Id) throws Exception {
		repo.deleteById(Id);
		return 1;
	}

	@Override
	public TicketdtlMdl fetchById(String id) throws Exception {
		TicketdtlMdl mdl=null;
		Optional<Ticketdtl> opt=repo.findById(Long.parseLong(id));
		if(opt.isPresent()) {
			Ticketdtl dtl= opt.get();
			mdl=new TicketdtlMdl();
			mdl.setTktId(String.valueOf(dtl.getTktId()));
			mdl.setTktSubject(dtl.getTktSubject());
			mdl.setTktMassage(dtl.getTktMassage());
			mdl.setTktPriority(dtl.getTktPriority());
			mdl.setTktStatus(dtl.getTktStatus());
			mdl.setTktUserId(dtl.getTktUserId());
		}
		return mdl;
	}

	@Override
	public List<TicketdtlMdl> fetchAllDtl() throws Exception {
		List<TicketdtlMdl> mdlst=new ArrayList<TicketdtlMdl>();
		List<Ticketdtl>dtlst=repo.findAll();
		dtlst.forEach(dtl->{
			TicketdtlMdl mdl=new TicketdtlMdl();
			mdl.setTktId(String.valueOf(dtl.getTktId()));
			mdl.setTktSubject(dtl.getTktSubject());
			mdl.setTktMassage(dtl.getTktMassage());
			mdl.setTktPriority(dtl.getTktPriority());
			mdl.setTktStatus(dtl.getTktStatus());
			mdl.setTktUserId(dtl.getTktUserId());
			mdlst.add(mdl);
		});
		return mdlst;
	}

}
