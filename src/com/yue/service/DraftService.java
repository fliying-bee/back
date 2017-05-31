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
	
	public List<Draft> queryAllDraftPage(String userId){
    	return DraftDao.queryAllDraftPage(userId);
    }
	
	public int updateDraftCheck(Draft draft){
    	return DraftDao.updateDraftCheck(draft);
    }
	public int insertDraft(Draft draft){
    	return DraftDao.insertDraft(draft);
    }
}
