package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.DraftDao;
import com.yue.model.Draft;

@Service
public class DraftService {
	@Autowired
	private DraftDao DraftDao;
	
	public Draft queryBackDraftById(String draId){
    	return DraftDao.queryBackDraftById(draId);
    }
	
	public List<Draft> queryBackAllDraftPage(){
    	return DraftDao.queryBackAllDraftPage();
    }
	
//	public int updateDraftCheck(Draft draft){
//    	return DraftDao.updateDraftCheck(draft);
//    }
	
//	public List<Draft>  queryBackDraftByCheck(String draCheck){
//    	return DraftDao.queryBackDraftByCheck(draCheck);
//    }
//	
}
