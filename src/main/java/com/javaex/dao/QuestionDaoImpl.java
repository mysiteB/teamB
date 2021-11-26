package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.QuestionVo;
import com.javaex.vo.ReviewVo;

public class QuestionDaoImpl implements QuestionDao{
	
	private static QuestionDao instance;
	public QuestionDaoImpl() {}
	public static QuestionDao getInstance() {
		if (instance == null) {
			instance = new QuestionDaoImpl();
		}
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
	    Connection conn = null;
	    try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
	      conn = DriverManager.getConnection(dburl, "mysiteB", "1234");
	    } catch (ClassNotFoundException e) {
	      System.err.println("JDBC 드라이버 로드 실패!");
	    }
	    return conn;
	}
	
	@Override
	public int insert(QuestionVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0;

		try {
		  conn = getConnection();
		  
		  System.out.println("insert 질문 : ["+vo.getQno()+"]");
		  
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "insert into question\r\n"
					+ "values (seq_question_no.nextval, ?, ?, to_char(sysdate, 'YY-MM-DD HH24:MI'), ?, ?);";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getProno());
			pstmt.setInt(2, vo.getMemno());
			pstmt.setString(3, vo.getQcontent());
			pstmt.setInt(4, vo.getQavail());
			
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		return count;
	}

	@Override
	public int delete(int qNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
		  conn = getConnection();

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "update question\r\n"
					+ "set qavail = 0\r\n"
					+ "where qno = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, qNo);

			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 삭제");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		return count;
	}

	@Override
	public List<QuestionVo> getList(int page, int limit, int proNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total_record = getListCount(proNo);
		
		int start = (page - 1) * limit;
		int index = start + 1;
		String sql;
		
		//기본 정렬: 최신 날짜 순
				
		List<QuestionVo> list = new ArrayList<QuestionVo>();
				
		if (proNo > 0 || proNo < 0) {
			sql = "select q.*, m.memid\r\n"
					+ "from question q, product p, regmember m\r\n"
					+ "where q.prono = p.prono\r\n"
					+ "and q.prono = "+proNo+"\r\n"
					+ "order by qDate desc";
			
			System.out.println("특정 상품 리스트 뿌림");
		}
		else { 
			sql = "select q.*, m.memid\r\n"
					+ "from question q, product p, regmember m\r\n"
					+ "where q.prono = p.prono\r\n"
					+ "order by qDate desc";
			
			System.out.println("전체 다 뿌림");
		}
		
		try {
			conn = getConnection();
			 
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			while (rs.absolute(index)) {
				QuestionVo vo = new QuestionVo();
				vo.setQno(rs.getInt("qNo"));
				vo.setProno(rs.getInt("proNo"));
				vo.setMemno(rs.getInt("memNo"));
				vo.setQdate(rs.getString("qDate"));
				vo.setQcontent(rs.getString("qContent"));
				vo.setQavail(rs.getInt("qAvail"));
								
				vo.setMemid(rs.getString("memid").substring(0,2) + "***"); 
			
				list.add(vo);
				if (index < (start + limit) && index <= total_record)
					index++;
			
				else 
					break;
			}
			
		} catch (Exception ex) {
			System.out.println("getList() error : " + ex);
		} finally {
			try {
				if (rs != null) 
					rs.close();							
				if (pstmt != null) 
					pstmt.close();				
				if (conn != null) 
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}			
		}
		return list;
	}

	@Override
	public int getListCount(int proNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		String query;
		
		if(proNo > 0 || proNo < 0) {
			query = "select count(*) from question where proNo = " + proNo; //특정 상품
		}else {
			query = "select count(*) from question"; //전체 상품
		}
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				count = rs.getInt(1);
			System.out.println(count);
		} catch (Exception ex)	{
			System.out.println("리스트 카운트 에러 " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		return count;
	}

}
