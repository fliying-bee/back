package com.yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.ProcureDetailDao;
import com.yue.model.ProcureDetail;

@Service
public class ProcureDetailService {
	@Autowired
	private ProcureDetailDao ProcureDetailDao;
	
	public int insertProcureDetail(ProcureDetail procureDetail){
    	return ProcureDetailDao.insertProcureDetail(procureDetail);
    }
	public int deleteProcureDetail(ProcureDetail procureDetail){
    	return ProcureDetailDao.deleteProcureDetail(procureDetail);
    }
	public int updateProcureDetail(ProcureDetail procureDetail){
    	return ProcureDetailDao.updateProcureDetail(procureDetail);
    }
}
