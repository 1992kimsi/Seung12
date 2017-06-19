package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

public class MySQLMemberDao implements MemberDao {

	@Override
	public List<Member> getList(String query) {
		String sql = "SELECT * FROM MEMBER WHERE ID LIKE '%" + query + "%'";
		List<Member> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false"; // DB占쏙옙占쏙옙
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // 占쏙옙占쏙옙遣占� 占싸듸옙
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			Member member = null;

			while (rs.next()) {
				member = new Member();
				member.setId(rs.getString("ID"));
				member.setPwd(rs.getString("PWD"));

				list.add(member);
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
	public int add(Member member) {
		
		String sql = "INSERT INTO MEMBER(MID,PWD,NAME,PHONE,REGDATE) VALUES(?,?,?,?,SYSDATE)"; // Member占쏙옙 占쏙옙占쏙옙 占쌍는곤옙占쏙옙 占싫아넣댐옙 占쌜억옙
		List<Member> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass"); 
			// Statement st = con.createStatement(); // 占싫아넣댐옙 占심뤄옙占쏙옙 占쏙옙占쏙옙 占쏙옙占썅만 占쏙옙占쏙옙
			PreparedStatement st = con.prepareStatement(sql);			
			st.setString(1, member.getId());
			st.setString(2, member.getPwd());
			st.setString(3, member.getName());
			st.setString(4, member.getPhone());

			// 占쏙옙占쏙옙占� 占쌍댐옙 占쏙옙占쏙옙 executeQuery()
			// SELECT
			// 占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙 executeUpdate()
			// INSERT, UPDATE, DELETE
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Member get(String id) {
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		Member member = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false"; // DB占쏙옙占쏙옙
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // 占쏙옙占쏙옙遣占� 占싸듸옙
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setPwd(rs.getString("PWD"));
				member.setNicName(rs.getString("NICNAME"));
				member.setPhoto(rs.getString("PHOTO"));
				member.setGender(rs.getString("GENDER"));
				member.setBirthday(rs.getString("BIRTHDAY"));
				member.setIsLunar(rs.getInt("IS_LUNAR"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));
				member.setZipCode(rs.getString("ZIPCODE"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setAddressDetail(rs.getString("ADDRESS_DETAIL"));
				member.setRegDate(rs.getDate("REG_DATE"));
				member.setRegIP(rs.getString("REG_IP"));
				member.setRegEnv(rs.getString("REG_ENV"));
				member.setPwdModifyKey(rs.getString("PWD_MODIFY_KEY"));
				member.setRegAdmin(rs.getString("REG_ADMIN"));
				member.setGuid(rs.getString("GUID"));
				member.setDisabled(rs.getBoolean("DISABLED"));				
			}

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}

}
