package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.ProductVo;

public class ProductDaoImpl implements ProductDao{
	
	private static ProductDao instance;
	public ProductDaoImpl() {
		
	}
	public static ProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDaoImpl();
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
	public int insert(ProductVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0;

		try {
		  conn = getConnection();
		  
		  System.out.println("insert 상품이름 : ["+vo.getProName()+"]");
		  
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "insert into product\r\n"
					+ "values (seq_product_no.nextval, ?, ?, ?, ?, ?, ?, ?, to_char(sysdate, 'YY-MM-DD HH24:MI'), 0)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getProName());
			pstmt.setString(2, vo.getProCateg());
			pstmt.setInt(3, vo.getProStock());
			pstmt.setInt(4, vo.getProPrice());
			pstmt.setString(5, vo.getProDesc());
			pstmt.setInt(6, vo.getProOnSale());
			pstmt.setString(7, vo.getProFileName());
			
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
	public int delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
		  conn = getConnection();

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "delete from product where proNo = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, num);

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
	public int update(ProductVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
		  conn = getConnection();

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "update product\r\n"
					+ "set proName = ?, proCateg = ?, proStock = ?, proPrice = ?, proDesc = ?, proOnSale = ?, proFileName = ?\r\n"
					+ "where proNo = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getProName());
			pstmt.setString(2, vo.getProCateg());
			pstmt.setInt(3, vo.getProStock());
			pstmt.setInt(4, vo.getProPrice());
			pstmt.setString(5, vo.getProDesc());
			pstmt.setInt(6, vo.getProOnSale());
			pstmt.setString(7, vo.getProFileName());
			pstmt.setInt(8, vo.getProNo());
			
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 수정");

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
	public ProductVo getProduct(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVo vo = new ProductVo();
		updateHit(num);

		try {
		  conn = getConnection();

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "select * from product where proNo = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			// 4.결과처리
			if (rs.next()) {
				int proNo = rs.getInt("proNo");
				String proName = rs.getString("proName");
				String proCateg = rs.getString("proCateg");
				int proStock = rs.getInt("proStock");
				int proPrice = rs.getInt("proPrice");
				String proDesc = rs.getString("proDesc");
				int proOnSale = rs.getInt("proOnSale");
				String proFileName = rs.getString("proFileName");
				String proDate = rs.getString("proDate");
				int proHit = rs.getInt("proHit");

				vo = new ProductVo();
				vo.setProNo(proNo);
				vo.setProName(proName);
				vo.setProCateg(proCateg);
				vo.setProStock(proStock);
				vo.setProPrice(proPrice);
				vo.setProDesc(proDesc);
				vo.setProOnSale(proOnSale);
				vo.setProFileName(proFileName);
				vo.setProDate(proDate);
				vo.setProHit(proHit);
				
			}

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

		return vo;
	}

	public int getListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String query;
				
		try {
			query = "select count(*) from product";

			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			if (rs.next())
				count = rs.getInt(1);
			System.out.println(count);
		} catch (Exception ex)	{
			System.out.println("getListCount() : " + ex);
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
	
	public int getListCount(String searchfrom, String kwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		String query;
		
		
		if(searchfrom == null || kwd == null) {
			query = "select count(*) from product";
		}else {
			query = "select count(prono) from product where instr(" + searchfrom + " , '" + kwd + "') > 0";
		}
		
		try {
			
		
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs.next())
				count = rs.getInt(1);
			System.out.println(count);
		} catch (Exception ex)	{
			System.out.println("getListCount(searchfrom, kwd) : " + ex);
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
	

	
	public List<ProductVo> getList(int page, int limit , String searchFrom, String kwd, String orderBy){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total_record = getListCount(searchFrom, kwd);
		ReviewDao dao2 = new ReviewDaoImpl();
		int start = (page - 1) * limit;
		int index = start + 1;
		String sql;
		if (orderBy == null || "".equals(orderBy)) {
			orderBy = "proDate";
		}
		
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		
		
		if (searchFrom == null ||"".equals(searchFrom)  || kwd == null || "".equals(kwd)) {
			sql = "select * "
					+ "from product order by proDate";
			System.out.println("일로 들어왔읍니다");
		}
		else { 
			sql = "select pdt.* \r\n"
				+ "from (select rownum num, pd.*\r\n"
				+ "from (select * from product\r\n"
				+ "where instr("+searchFrom+", ?) > 0)pd\r\n"
				+ "order by "+orderBy+")pdt\r\n"
				+ "where num between ? and ?";
			System.out.println("그지같게 일로 들어왔읍니다");
		}
		
		try {
			conn = getConnection();
			 
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			while (rs.absolute(index)) {
				ProductVo vo = new ProductVo();
				vo.setProNo(rs.getInt("proNo"));
				vo.setProName(rs.getString("proName"));
				vo.setProCateg(rs.getString("proCateg"));
				vo.setProStock(rs.getInt("proStock"));
				vo.setProPrice(rs.getInt("proPrice"));
				vo.setProDesc(rs.getString("proDesc"));
				vo.setProOnSale(rs.getInt("proOnSale"));
				vo.setProFileName(rs.getString("proFileName"));
				vo.setProDate(rs.getString("proDate"));
				vo.setProHit(rs.getInt("proHit"));
				
				vo.setProRate(dao2.rateAvg(vo.getProNo()));
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
		System.out.println(dao2.rateAvg(62));
		return list;
	}
	
	
	public void updateHit(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select proHit from product where proNo = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			int hit = 0;

			if (rs.next()) {
				hit = rs.getInt("proHit") + 1;
				System.out.println("조회수 늘어남");
			}
			sql = "update product set proHit= ? where proNo= ? ";
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, hit);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			System.out.println(hit);
		} catch (Exception ex) {
			System.out.println("updateHit() : " + ex);
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
		
	}
	
	public ArrayList<ProductVo> getListByCateg(int page, String categ){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();

		try {
			conn = getConnection();
			 
			String sql = "select pdt.* \r\n"
					+ "from (select rownum num, pd.*\r\n"
					+ "from (select * from product\r\n"
					+ "where procateg = ?)pd\r\n"
					+ "order by prono)pdt\r\n"
					+ "where num between ? and ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, categ);
			pstmt.setInt(2, page * 5);
			rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setProNo(rs.getInt("proNo"));
				vo.setProName(rs.getString("proName"));
				vo.setProCateg(rs.getString("proCateg"));
				vo.setProStock(rs.getInt("proStock"));
				vo.setProPrice(rs.getInt("proPrice"));
				vo.setProDesc(rs.getString("proDesc"));
				vo.setProOnSale(rs.getInt("proOnSale"));
				vo.setProFileName(rs.getString("proFileName"));
				vo.setProDate(rs.getString("proDate"));
				vo.setProHit(rs.getInt("proHit"));
				
				list.add(vo);

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
	
	
	
}

