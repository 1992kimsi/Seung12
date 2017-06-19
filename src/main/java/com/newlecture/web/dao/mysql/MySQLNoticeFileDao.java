package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.entity.NoticeFile;

public class MySQLNoticeFileDao implements NoticeFileDao {

	@Override
	public List<NoticeFile> getList(String noticeCode) {
		String sql = "SELECT * FROM NOTICE_FILE WHERE NOTICE_CODE=?"; //데이터에만 ? 사용 가능하기 때문에, title은 "+field+"라고 씀
		List<NoticeFile> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB연결
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // 드라이브 로드
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, noticeCode);
			
			ResultSet rs = st.executeQuery();
			
			NoticeFile file = null;

			while (rs.next()) {
				file = new NoticeFile();
				file.setCode(rs.getString("CODE"));
				file.setSrc(rs.getString("SRC"));
				file.setNoticeCode(rs.getString("NOTICE_CODE"));
								
				list.add(file);
			}

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int add(NoticeFile file) {
		
		return add(file.getSrc(), file.getNoticeCode());
	}

	@Override
	public int add(String src, String noticeCode) {
		String codeSql = "SELECT IFNULL(MAX(CAST(CODE AS UNSIGNED)), 0)+1 CODE FROM NOTICE_FILE";
		
		String sql = "INSERT INTO NOTICE_FILE(CODE,SRC,NOTICE_CODE) VALUES(?,?,?)"; 
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB연결
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // 드라이브 로드
			
			Statement codeSt = con.createStatement();
			ResultSet rs = codeSt.executeQuery(codeSql);
			rs.next();
			String code = rs.getString("CODE");
			rs.close();
			codeSt.close();
			
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, code);
			st.setString(2, src);
			st.setString(3, noticeCode);			
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
