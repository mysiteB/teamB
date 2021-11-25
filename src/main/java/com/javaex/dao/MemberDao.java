package com.javaex.dao;

import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.MemberVo;
import com.javaex.vo.OrderInfoVo;





public interface MemberDao {
	public int insert(MemberVo vo);

	MemberVo getMember( String id, String password );

	public ArrayList<OrderInfoVo> getList(String no);

	
	
}