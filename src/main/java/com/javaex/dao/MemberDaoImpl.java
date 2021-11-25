package com.javaex.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaex.vo.MemberVo;
import com.javaex.vo.OrderInfoVo;


public class MemberDaoImpl implements MemberDao {
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
	public int insert(MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			conn = getConnection();
			
			String query = "insert into regMember values ( ?, seq_regmember_no.nextval, ?, ?, ?, ? ,nvl(null,'0'))";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getMemName());
			pstmt.setString(2, vo.getMemPhone());
			pstmt.setString(3, vo.getMemAdd());
			pstmt.setString(4, vo.getMemId());
			pstmt.setString(5, vo.getMemPass());
	
			
			System.out.println("name->"+vo.getMemName());
			System.out.println("phone->"+ vo.getMemPhone());
			System.out.println("address->"+vo.getMemAdd());
			System.out.println("id->"+vo.getMemId());
			System.out.println("password->"+vo.getMemPass());
	
			count = pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
		
	}
	
	
	
	@Override
	public MemberVo getMember(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		
		try {
			conn = getConnection();
			String query = "select * from regMember where memid = ? and mempass = ? ";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
		
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				int no = rs.getInt("memno");
				String memname = rs.getString("memname");
				String memphone = rs.getString("memphone");
				String memadd = rs.getString("memadd");
				String adminck = rs.getString("adminck");
				
				vo = new MemberVo(id, password);
				vo.setMemNo(no);
				vo.setMemName(memname);
				vo.setMemPhone(memphone);
				vo.setMemAdd(memadd);
				vo.setAdminCk(adminck);
				System.out.println(vo.getMemId());
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("error: "+ e);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}
		return vo;
	}


	@Override
	public ArrayList<OrderInfoVo> getList(String no) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
