package com.ext.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ext.entity.Processformautiddtl;
import com.ext.model.ProcessformautiddtlMdl;
import com.ext.repository.ProcessformautiddtlRepository;
import com.ext.service.ProcessformautiddtlService;
import com.ext.util.CommonUtils;

@Service
public class ProcessformautiddtlServiceImpl implements ProcessformautiddtlService {
	@Autowired
     private ProcessformautiddtlRepository repo;
	@Override
	public int addProcessformautiddtl(ProcessformautiddtlMdl model) throws Exception {
			Processformautiddtl entt=new Processformautiddtl();                                      
			entt.setPfdClntCmpnName(CommonUtils.isNull(model.getPfdClntCmpnName ())?"": model.getPfdClntCmpnName());                                    
			entt.setPfdClntCmpnWebsite(CommonUtils.isNull(model.getPfdClntCmpnWebsite())?"": model.getPfdClntCmpnWebsite());                                  
			entt.setPfdClntProjName (CommonUtils.isNull(model.getPfdClntProjName ())?"":model.getPfdClntProjName());
			entt.setPfdClntProjType(CommonUtils.isNull(model.getPfdClntProjType())?"":model.getPfdClntProjType());
			entt.setPfdClntProjSourcelink(CommonUtils.isNull(model.getPfdClntProjSourcelink())?"":model.getPfdClntProjSourcelink());
			entt.setPfdClntProjNoofcontracts(CommonUtils.isNull(model.getPfdClntProjNoofcontracts())?"":model.getPfdClntProjNoofcontracts());
			entt.setPfdClntProjNameofcontracts (CommonUtils.isNull(model.getPfdClntProjNameofcontracts())?"":model.getPfdClntProjNameofcontracts());
			entt.setPfdClntProjAuditedby(CommonUtils.isNull(model.getPfdClntProjAuditedby())?"":model.getPfdClntProjAuditedby());
			entt.setPfdClntProjAuditingdate(CommonUtils.isNull(model.getPfdClntProjAuditingdate())?null:new SimpleDateFormat("dd/MM/yyyy").parse(model.getPfdClntProjAuditingdate()));
			entt.setPfdClntProjAuditedreportslink (CommonUtils.isNull(model.getPfdClntProjAuditedreportslink())?"":model.getPfdClntProjAuditedreportslink());
			entt.setPfdClntProjTrustscore(CommonUtils.isNull(model.getPfdClntProjTrustscore())?"":model.getPfdClntProjTrustscore());
			entt.setPfdClntProjTotalvolume(CommonUtils.isNull(model.getPfdClntProjTotalvolume())?"":model.getPfdClntProjTotalvolume());
			entt.setPfdClntProjCirculatingsupply (CommonUtils.isNull(model.getPfdClntProjCirculatingsupply())?"":model.getPfdClntProjCirculatingsupply());
			entt.setPfdClntProjMarketcap(CommonUtils.isNull(model.getPfdClntProjMarketcap())?"":model.getPfdClntProjMarketcap());
			entt.setPfdClntProjCoinranking (CommonUtils.isNull(model.getPfdClntProjCoinranking())?"":model.getPfdClntProjCoinranking());
			entt.setPfdClntProjTokenlaunched (CommonUtils.isNull(model.getPfdClntProjTokenlaunched())?"":model.getPfdClntProjTokenlaunched());
			entt.setPfdClntProjTechUsed(CommonUtils.isNull(model.getPfdClntProjTechUsed())?"":model.getPfdClntProjTechUsed());
			entt.setPfdClntProjClasOfBlChn(CommonUtils.isNull(model.getPfdClntProjClasOfBlChn())?"":model.getPfdClntProjClasOfBlChn());
			entt.setPfdClntProjTypOfTkn(CommonUtils.isNull(model.getPfdClntProjTypOfTkn())?"":model.getPfdClntProjTypOfTkn());
			entt.setPfdClntProjTknStandrd(CommonUtils.isNull(model.getPfdClntProjTknStandrd())?"":model.getPfdClntProjTknStandrd());
			entt.setPfdClntProjUtilityOfCoin(CommonUtils.isNull(model.getPfdClntProjUtilityOfCoin())?"":model.getPfdClntProjUtilityOfCoin());
			entt.setPfdClntProjBackedByBcoin(CommonUtils.isNull(model.getPfdClntProjBackedByBcoin())?"":model.getPfdClntProjBackedByBcoin());
			entt.setPfdClntCreatedDt(new Date());
			entt.setPfdStatus("P");
			entt.setPfdCreatedBy(CommonUtils.isNull(model.getPfdUserid())?"":model.getPfdUserid());
			Processformautiddtl processformautiddtl = repo.saveAndFlush(entt);
		if(!CommonUtils.isNull(processformautiddtl))
		return 1;
		else
			return 0;
	}

	@Override
	public int updateProcessformautiddtl(ProcessformautiddtlMdl model) throws Exception {

		Processformautiddtl processformautiddtl=null;
		Processformautiddtl entt=repo.getReferenceById(Long.parseLong(model.getPfdId()));
		if(!CommonUtils.isNull(entt)) {
			entt.setPfdClntCmpnName(CommonUtils.isNull(model.getPfdClntCmpnName ())?entt.getPfdClntCmpnName(): model.getPfdClntCmpnName());                                    
			entt.setPfdClntCmpnWebsite(CommonUtils.isNull(model.getPfdClntCmpnWebsite())?entt.getPfdClntCmpnWebsite(): model.getPfdClntCmpnWebsite());                                  
			entt.setPfdClntProjName (CommonUtils.isNull(model.getPfdClntProjName ())?entt.getPfdClntProjName():model.getPfdClntProjName());
			entt.setPfdClntProjType(CommonUtils.isNull(model.getPfdClntProjType())?entt.getPfdClntProjType():model.getPfdClntProjType());
			entt.setPfdClntProjSourcelink(CommonUtils.isNull(model.getPfdClntProjSourcelink())?entt.getPfdClntProjSourcelink():model.getPfdClntProjSourcelink());
			entt.setPfdClntProjNoofcontracts(CommonUtils.isNull(model.getPfdClntProjNoofcontracts())?entt.getPfdClntProjNoofcontracts():model.getPfdClntProjNoofcontracts());
			entt.setPfdClntProjNameofcontracts (CommonUtils.isNull(model.getPfdClntProjNameofcontracts())?entt.getPfdClntProjNameofcontracts():model.getPfdClntProjNameofcontracts());
			entt.setPfdClntProjAuditedby(CommonUtils.isNull(model.getPfdClntProjAuditedby())?entt.getPfdClntProjAuditedby():model.getPfdClntProjAuditedby());
			entt.setPfdClntProjAuditingdate(CommonUtils.isNull(model.getPfdClntProjAuditingdate())?entt.getPfdClntProjAuditingdate():new SimpleDateFormat("dd/MM/yyyy").parse(model.getPfdClntProjAuditingdate()));
			entt.setPfdClntProjAuditedreportslink (CommonUtils.isNull(model.getPfdClntProjAuditedreportslink())?entt.getPfdClntProjAuditedreportslink():model.getPfdClntProjAuditedreportslink());
			entt.setPfdClntProjTrustscore(CommonUtils.isNull(model.getPfdClntProjTrustscore())?entt.getPfdClntProjTrustscore():model.getPfdClntProjTrustscore());
			entt.setPfdClntProjTotalvolume(CommonUtils.isNull(model.getPfdClntProjTotalvolume())?entt.getPfdClntProjTotalvolume():model.getPfdClntProjTotalvolume());
			entt.setPfdClntProjCirculatingsupply (CommonUtils.isNull(model.getPfdClntProjCirculatingsupply())?entt.getPfdClntProjCirculatingsupply():model.getPfdClntProjCirculatingsupply());
			entt.setPfdClntProjMarketcap(CommonUtils.isNull(model.getPfdClntProjMarketcap())?entt.getPfdClntProjMarketcap():model.getPfdClntProjMarketcap());
			entt.setPfdClntProjCoinranking(CommonUtils.isNull(model.getPfdClntProjCoinranking())?entt.getPfdClntProjCoinranking():model.getPfdClntProjCoinranking());
			entt.setPfdClntProjTokenlaunched (CommonUtils.isNull(model.getPfdClntProjTokenlaunched())?entt.getPfdClntProjTokenlaunched():model.getPfdClntProjTokenlaunched());
			entt.setPfdClntProjTechUsed(CommonUtils.isNull(model.getPfdClntProjTechUsed())?entt.getPfdClntProjTechUsed():model.getPfdClntProjTechUsed());
			entt.setPfdClntProjClasOfBlChn(CommonUtils.isNull(model.getPfdClntProjClasOfBlChn())?entt.getPfdClntProjClasOfBlChn():model.getPfdClntProjClasOfBlChn());
			entt.setPfdClntProjTypOfTkn(CommonUtils.isNull(model.getPfdClntProjTypOfTkn())?entt.getPfdClntProjTypOfTkn():model.getPfdClntProjTypOfTkn());
			entt.setPfdClntProjTknStandrd(CommonUtils.isNull(model.getPfdClntProjTknStandrd())?entt.getPfdClntProjTknStandrd():model.getPfdClntProjTknStandrd());
			entt.setPfdClntProjUtilityOfCoin(CommonUtils.isNull(model.getPfdClntProjUtilityOfCoin())?entt.getPfdClntProjUtilityOfCoin():model.getPfdClntProjUtilityOfCoin());
			entt.setPfdClntProjBackedByBcoin(CommonUtils.isNull(model.getPfdClntProjBackedByBcoin())?entt.getPfdClntProjBackedByBcoin():model.getPfdClntProjBackedByBcoin());
			entt.setPfdClntUpdatedDt(new Date());
			entt.setPfdStatus(CommonUtils.isNull(model.getPfdStatus())?entt.getPfdStatus():model.getPfdStatus());
			entt.setPfdUpdatedBy(CommonUtils.isNull(model.getPfdUserid())?entt.getPfdUpdatedBy():model.getPfdUserid());
			processformautiddtl = repo.saveAndFlush(entt);
		}
		
		if(!CommonUtils.isNull(processformautiddtl))
		return 1;
		else
			return 0;
	}

	@Override
	public int deleteProcessformautiddtl(Long Id) throws Exception {
		repo.deleteById(Id);
		return 1;
	}

	@Override
	public ProcessformautiddtlMdl fetchById(String id) throws Exception {
		ProcessformautiddtlMdl model=null;
		Optional<Processformautiddtl> opt=repo.findById(Long.parseLong(id));
		if (opt.isPresent()) {
			Processformautiddtl dtl = opt.get();
			model = new ProcessformautiddtlMdl();
			model.setPfdId(String.valueOf(dtl.getPfdId()));
			model.setPfdClntCmpnName(dtl.getPfdClntCmpnName());
			model.setPfdClntCmpnWebsite(dtl.getPfdClntCmpnWebsite());
			model.setPfdClntProjName(dtl.getPfdClntProjName());
			model.setPfdClntProjType(String.valueOf(dtl.getPfdClntProjType()));
			model.setPfdClntProjSourcelink(dtl.getPfdClntProjSourcelink());
			model.setPfdClntProjNoofcontracts(dtl.getPfdClntProjNoofcontracts());
			model.setPfdClntProjNameofcontracts(dtl.getPfdClntProjNameofcontracts());
			model.setPfdClntProjAuditedby(dtl.getPfdClntProjAuditedby());
			model.setPfdClntProjAuditingdate(
					new SimpleDateFormat("dd/MM/yyyy").format(dtl.getPfdClntProjAuditingdate()));
			model.setPfdClntProjAuditedreportslink(dtl.getPfdClntProjAuditedreportslink());
			model.setPfdClntProjTrustscore(dtl.getPfdClntProjTrustscore());
			model.setPfdClntProjTotalvolume(dtl.getPfdClntProjTotalvolume());
			model.setPfdClntProjCirculatingsupply(dtl.getPfdClntProjCirculatingsupply());
			model.setPfdClntProjMarketcap(dtl.getPfdClntProjMarketcap());
			model.setPfdClntProjCoinranking(dtl.getPfdClntProjCoinranking());
			model.setPfdClntProjTokenlaunched(dtl.getPfdClntProjTokenlaunched());
			model.setPfdClntProjTechUsed(dtl.getPfdClntProjTechUsed());
			model.setPfdClntProjClasOfBlChn(dtl.getPfdClntProjClasOfBlChn());
			model.setPfdClntProjTypOfTkn(dtl.getPfdClntProjTypOfTkn());
			model.setPfdClntProjTknStandrd(dtl.getPfdClntProjTknStandrd());
			model.setPfdClntProjUtilityOfCoin(dtl.getPfdClntProjUtilityOfCoin());
			model.setPfdClntProjBackedByBcoin(dtl.getPfdClntProjBackedByBcoin());
			model.setPfdStatus(dtl.getPfdStatus());
		}
		return model;
	}

	@Override
	public List<ProcessformautiddtlMdl> fetchAllDtl() throws Exception {
		List<ProcessformautiddtlMdl> mdlst=new ArrayList<ProcessformautiddtlMdl>();
		List<Processformautiddtl>dtlst=repo.findAll();
		dtlst.forEach(dtl->{
			ProcessformautiddtlMdl model=new ProcessformautiddtlMdl();
			model.setPfdId(String.valueOf(dtl.getPfdId()));
			model.setPfdClntCmpnName(dtl.getPfdClntCmpnName());
			model.setPfdClntCmpnWebsite(dtl.getPfdClntCmpnWebsite());
			model.setPfdClntProjName(dtl.getPfdClntProjName());
			model.setPfdClntProjType(String.valueOf(dtl.getPfdClntProjType()));
			model.setPfdClntProjSourcelink(dtl.getPfdClntProjSourcelink());
			model.setPfdClntProjNoofcontracts(dtl.getPfdClntProjNoofcontracts());
			model.setPfdClntProjNameofcontracts(dtl.getPfdClntProjNameofcontracts());
			model.setPfdClntProjAuditedby(dtl.getPfdClntProjAuditedby());
			model.setPfdClntProjAuditingdate(new SimpleDateFormat("dd/MM/yyyy").format(dtl.getPfdClntProjAuditingdate()));
			model.setPfdClntProjAuditedreportslink(dtl.getPfdClntProjAuditedreportslink());
			model.setPfdClntProjTrustscore(dtl.getPfdClntProjTrustscore());
			model.setPfdClntProjTotalvolume(dtl.getPfdClntProjTotalvolume());
			model.setPfdClntProjCirculatingsupply(dtl.getPfdClntProjCirculatingsupply());
			model.setPfdClntProjMarketcap(dtl.getPfdClntProjMarketcap());
			model.setPfdClntProjCoinranking(dtl.getPfdClntProjCoinranking());
			model.setPfdClntProjTokenlaunched(dtl.getPfdClntProjTokenlaunched());
			model.setPfdClntProjTechUsed(dtl.getPfdClntProjTechUsed());
			model.setPfdClntProjClasOfBlChn(dtl.getPfdClntProjClasOfBlChn());
			model.setPfdClntProjTypOfTkn(dtl.getPfdClntProjTypOfTkn());
			model.setPfdClntProjTknStandrd(dtl.getPfdClntProjTknStandrd());
			model.setPfdClntProjUtilityOfCoin(dtl.getPfdClntProjUtilityOfCoin());
			model.setPfdClntProjBackedByBcoin(dtl.getPfdClntProjBackedByBcoin());
			model.setPfdStatus(dtl.getPfdStatus());
			mdlst.add(model);
		});
		return mdlst;
	}

	@Override
	public List<ProcessformautiddtlMdl> fetchAllDtlByLogin(String id) throws Exception {
		List<ProcessformautiddtlMdl> mdlst=new ArrayList<ProcessformautiddtlMdl>();
		
		List<Processformautiddtl> findByPfdCreatedBy = repo.findByPfdCreatedBy(id);
		findByPfdCreatedBy.forEach(dtl->{
			ProcessformautiddtlMdl model=new ProcessformautiddtlMdl();
			model.setPfdId(String.valueOf(dtl.getPfdId()));
			model.setPfdClntCmpnName(dtl.getPfdClntCmpnName());
			model.setPfdClntCmpnWebsite(dtl.getPfdClntCmpnWebsite());
			model.setPfdClntProjName(dtl.getPfdClntProjName());
			model.setPfdClntProjType(String.valueOf(dtl.getPfdClntProjType()));
			model.setPfdClntProjSourcelink(dtl.getPfdClntProjSourcelink());
			model.setPfdClntProjNoofcontracts(dtl.getPfdClntProjNoofcontracts());
			model.setPfdClntProjNameofcontracts(dtl.getPfdClntProjNameofcontracts());
			model.setPfdClntProjAuditedby(dtl.getPfdClntProjAuditedby());
			model.setPfdClntProjAuditingdate(new SimpleDateFormat("dd/MM/yyyy").format(dtl.getPfdClntProjAuditingdate()));
			model.setPfdClntProjAuditedreportslink(dtl.getPfdClntProjAuditedreportslink());
			model.setPfdClntProjTrustscore(dtl.getPfdClntProjTrustscore());
			model.setPfdClntProjTotalvolume(dtl.getPfdClntProjTotalvolume());
			model.setPfdClntProjCirculatingsupply(dtl.getPfdClntProjCirculatingsupply());
			model.setPfdClntProjMarketcap(dtl.getPfdClntProjMarketcap());
			model.setPfdClntProjCoinranking(dtl.getPfdClntProjCoinranking());
			model.setPfdClntProjTokenlaunched(dtl.getPfdClntProjTokenlaunched());
			model.setPfdClntProjTechUsed(dtl.getPfdClntProjTechUsed());
			model.setPfdClntProjClasOfBlChn(dtl.getPfdClntProjClasOfBlChn());
			model.setPfdClntProjTypOfTkn(dtl.getPfdClntProjTypOfTkn());
			model.setPfdClntProjTknStandrd(dtl.getPfdClntProjTknStandrd());
			model.setPfdClntProjUtilityOfCoin(dtl.getPfdClntProjUtilityOfCoin());
			model.setPfdClntProjBackedByBcoin(dtl.getPfdClntProjBackedByBcoin());
			model.setPfdStatus(dtl.getPfdStatus());
			mdlst.add(model);
		});
		return mdlst;
	}

	@Override
	public List<ProcessformautiddtlMdl> fetchAllDtlByStatus(String status) throws Exception {
		List<ProcessformautiddtlMdl> mdlst=new ArrayList<ProcessformautiddtlMdl>();
		List<Processformautiddtl>dtlst=repo.findByPfdStatus(status);
		dtlst.forEach(dtl->{
			ProcessformautiddtlMdl model=new ProcessformautiddtlMdl();
			model.setPfdId(String.valueOf(dtl.getPfdId()));
			model.setPfdClntCmpnName(dtl.getPfdClntCmpnName());
			model.setPfdClntCmpnWebsite(dtl.getPfdClntCmpnWebsite());
			model.setPfdClntProjName(dtl.getPfdClntProjName());
			model.setPfdClntProjType(String.valueOf(dtl.getPfdClntProjType()));
			model.setPfdClntProjSourcelink(dtl.getPfdClntProjSourcelink());
			model.setPfdClntProjNoofcontracts(dtl.getPfdClntProjNoofcontracts());
			model.setPfdClntProjNameofcontracts(dtl.getPfdClntProjNameofcontracts());
			model.setPfdClntProjAuditedby(dtl.getPfdClntProjAuditedby());
			model.setPfdClntProjAuditingdate(new SimpleDateFormat("dd/MM/yyyy").format(dtl.getPfdClntProjAuditingdate()));
			model.setPfdClntProjAuditedreportslink(dtl.getPfdClntProjAuditedreportslink());
			model.setPfdClntProjTrustscore(dtl.getPfdClntProjTrustscore());
			model.setPfdClntProjTotalvolume(dtl.getPfdClntProjTotalvolume());
			model.setPfdClntProjCirculatingsupply(dtl.getPfdClntProjCirculatingsupply());
			model.setPfdClntProjMarketcap(dtl.getPfdClntProjMarketcap());
			model.setPfdClntProjCoinranking(dtl.getPfdClntProjCoinranking());
			model.setPfdClntProjTokenlaunched(dtl.getPfdClntProjTokenlaunched());
			model.setPfdClntProjTechUsed(dtl.getPfdClntProjTechUsed());
			model.setPfdClntProjClasOfBlChn(dtl.getPfdClntProjClasOfBlChn());
			model.setPfdClntProjTypOfTkn(dtl.getPfdClntProjTypOfTkn());
			model.setPfdClntProjTknStandrd(dtl.getPfdClntProjTknStandrd());
			model.setPfdClntProjUtilityOfCoin(dtl.getPfdClntProjUtilityOfCoin());
			model.setPfdClntProjBackedByBcoin(dtl.getPfdClntProjBackedByBcoin());
			model.setPfdStatus(dtl.getPfdStatus());
			mdlst.add(model);
		});
		return mdlst;
	}

}
