package com.yue.dao;

import java.util.List;

import com.yue.model.Draft;

public interface DraftDao {
	//更新
	public int updateDraftCheck(Draft Draft);
	//根据ID查
	public Draft queryBackDraftById(String draId);
	//分页查询所有
	public List<Draft> queryBackAllDraftPage();
	//分页查询所有
	public List<Draft> queryAllDraftPage(String userId);
	//插入
	public int insertDraft(Draft Draft);
}
