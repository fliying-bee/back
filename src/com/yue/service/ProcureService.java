package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.ProcureDao;
import com.yue.model.Procure;
import com.yue.model.ProcureOrder;

@Service
public class ProcureService {
	@Autowired
	private ProcureDao ProcureDao;
	
	public int insertProcure(Procure Procure){
    	return ProcureDao.insertProcure(Procure);
    }
	public int updateProcure(ProcureOrder procureOrder){
    	return ProcureDao.updateProcure(procureOrder);
    }
	public int deleteProcure(Procure procure){
    	return ProcureDao.deleteProcure(procure);
    }
	public ProcureOrder queryBackProcureById(String ProcureId){
    	return ProcureDao.queryBackProcureById(ProcureId);
    }
	public ProcureOrder queryProcureById(String ProcureId){
    	return ProcureDao.queryProcureById(ProcureId);
    }
	public List<ProcureOrder> queryBackAllProcurePage(){
    	return ProcureDao.queryBackAllProcurePage();
    }
	public int updateProcureStatus(Procure procure){
    	return ProcureDao.updateProcureStatus(procure);
    }
}
