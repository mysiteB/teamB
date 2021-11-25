package com.javaex.dao;

import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.ProductVo;

public interface ProductDao {
	public int insert(ProductVo vo);		//새로운 상품 등록
	public int delete(int num);				//상품 삭제
	public int update(ProductVo vo);		//상품 정보 업데이트
	
	public ProductVo getProduct(int num);			//상품 상세정보
	public int getListCount();						//상품 갯수세기
	public int getListCount(String searchfrom, String kwd);		//상품 갯수세기
				//상품 목록
	public List<ProductVo> getList(int page, int limit, String searchFrom, String kwd, String orderBy);	//상품 목록
	
	public void updateHit(int num);			//상품 조회수 업데이트
	public ArrayList<ProductVo> getListByCateg(int page, String categ);//카테고리별 상품 리스트
}
