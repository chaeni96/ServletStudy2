package com.iu.c1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.c1.util.DBConnector;

public class BankBookDAO {
	
	private DBConnector dbConnector;
	
	public BankBookDAO () {
		dbConnector = new DBConnector();
	}
	
	//상품 전체 조회
	public ArrayList<BankBookDTO> getList() {
		
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
		
		String sql = "SELECT * FROM BANKBOOK";
		
		try {
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				
				bankBookDTO.setBookName(rs.getString("bookName"));
				bankBookDTO.setBookNumber(rs.getLong("bookNumber"));
				bankBookDTO.setBookRate(rs.getDouble("bookRate"));
				bankBookDTO.setBookSale(rs.getInt("bookSale"));
				
				ar.add(bankBookDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		return ar;
		
		
	}
	
	//상품 상세 조회
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		BankBookDTO result = null;
		
		Connection con = dbConnector.getConnect();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER = ?";
		
		try {
			st = con.prepareStatement(sql);
			
			st.setLong(1, bankBookDTO.getBookNumber());
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new BankBookDTO();
				result.setBookNumber(rs.getLong("bookNumber"));
				result.setBookName(rs.getString("bookName"));
				result.setBookRate(rs.getDouble("bookRate"));
				result.setBookSale(rs.getInt("bookSale"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		return result;
	}

}
