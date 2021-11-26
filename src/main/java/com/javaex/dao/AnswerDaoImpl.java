package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.AnswerVo;
import com.javaex.vo.QuestionVo;

public class AnswerDaoImpl implements AnswerDao{

	private static AnswerDao instance;
	
	public AnswerDaoImpl() {}
	public static AnswerDao getInstance() {
		if (instance == null) {
			instance = new AnswerDaoImpl();
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
	public int adminck(int memNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		int adminck = 0;
		
		String query = "select adminck from regmember where memno = "+memNo;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				adminck = rs.getInt(1);
			
		} catch (Exception ex) {
			System.out.println("admin check error" + ex);
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
		return adminck;
	}
	
	@Override
	public int insert(AnswerVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		int count = 0;
		int adminck = 0;
		
		try {
		  conn = getConnection();
		  
		  System.out.println("insert 질문 : ["+vo.getaNo()+"]");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query;
			if (adminck(vo.getMemNo()) == 1) {
				query = "insert into answer values (seq_answer_no.nextval, ?, ?, to_char(sysdate, 'YY-MM-DD HH24:MI'), ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getqNo());
			pstmt.setInt(2, vo.getMemNo());
			pstmt.setString(3, vo.getaContent());
			pstmt.setInt(4, vo.getaAvail());
			
			count = pstmt.executeUpdate();
			}

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
	public int delete(int aNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
		  conn = getConnection();

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "update answer set aavail = 0 where ano = " + aNo;
			pstmt = conn.prepareStatement(query);

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
	public List<AnswerVo> getList(int page, int limit, int qNo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getListCount(int qNo) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public List<AnswerVo> getList(int page, int limit, int qNo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int total_record = getListCount(proNo);
//		
//		int start = (page - 1) * limit;
//		int index = start + 1;
//		String sql;
//		
//		//기본 정렬: 최신 날짜 순
//				
//		List<QuestionVo> list = new ArrayList<QuestionVo>();
//				
//		if (proNo > 0 || proNo < 0) {
//			sql = "select q.*, m.memid\r\n"
//					+ "from question q, product p, regmember m\r\n"
//					+ "where q.prono = p.prono\r\n"
//					+ "and q.prono = "+proNo+"\r\n"
//					+ "order by qDate desc";
//			
//			System.out.println("특정 상품 리스트 뿌림");
//		}
//		else { 
//			sql = "select q.*, m.memid\r\n"
//					+ "from question q, product p, regmember m\r\n"
//					+ "where q.prono = p.prono\r\n"
//					+ "order by qDate desc";
//			
//			System.out.println("전체 다 뿌림");
//		}
//		
//		try {
//			conn = getConnection();
//			 
//			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			rs = pstmt.executeQuery();
//			while (rs.absolute(index)) {
//				QuestionVo vo = new QuestionVo();
//				vo.setQno(rs.getInt("qNo"));
//				vo.setProno(rs.getInt("proNo"));
//				vo.setMemno(rs.getInt("memNo"));
//				vo.setQdate(rs.getString("qDate"));
//				vo.setQcontent(rs.getString("qContent"));
//				vo.setQavail(rs.getInt("qAvail"));
//								
//				vo.setMemid(rs.getString("memid").substring(0,2) + "***"); 
//			
//				list.add(vo);
//				if (index < (start + limit) && index <= total_record)
//					index++;
//			
//				else 
//					break;
//			}
//			
//		} catch (Exception ex) {
//			System.out.println("getList() error : " + ex);
//		} finally {
//			try {
//				if (rs != null) 
//					rs.close();							
//				if (pstmt != null) 
//					pstmt.close();				
//				if (conn != null) 
//					conn.close();
//			} catch (Exception ex) {
//				throw new RuntimeException(ex.getMessage());
//			}			
//		}
//		return list;
//	}

//	@Override
//	public int getListCount(int qNo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		int count = 0;
//		
//		String query;
//		
//		if(qNo > 0 || qNo < 0) {
//			query = "select count(*) from answer where qNo = " + qNo; //특정 상품
//		}else {
//			query = "select count(*) from answer"; //전체 상품
//		}
//		
//		try {
//			
//			conn = getConnection();
//			pstmt = conn.prepareStatement(query);
//			rs = pstmt.executeQuery();
//			
//			if (rs.next())
//				count = rs.getInt(1);
//			System.out.println(count);
//		} catch (Exception ex)	{
//			System.out.println("리스트 카운트 에러 " + ex);
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception ex) {
//				throw new RuntimeException(ex.getMessage());
//			}
//		}
//		return count;
//	}

}
