package com.newlecture.web.entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mysql.MySQLMemberDao;

public class Program {
	public static void main(String[] args) {

		// MVC
		// ================== Controller ===================================================
		String uid;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�˻��� ���̵� : ");
		uid = scan.nextLine();
		
		MemberDao memberDao = new MySQLMemberDao();
		List<Member> list = memberDao.getList(uid);
		
		// ================== Model===================================================
		// ����ϱ� ���� ������ = ��
		
		
		// ================== View ===================================================
		
		for (Member m : list) {
			System.out.println("ID�� "+m.getId()+"�̰� �н������ "+m.getPwd()+"�̴�");
		}
		// if(mid.contains("a")) >> a�� ���� ID�� ���
		//System.out.printf("id�� '%s'�̰� �н������ '%s'�̴�\n", mid, pwd);
		
		/*Member t = new Member();
		t.setId("�׽�Ʈ1");
		t.setPwd("111");
		t.setName("�����̰�");
		
		memberDao.add(t);*/
		
		/*list = memberDao.getList(uid);
		
		System.out.println("-------------------------------------------");
		// ================== View ===================================================
		for (Member m : list) {
			System.out.println("ID�� "+m.getId()+"�̰� �н������ "+m.getPwd()+"�̴�");
		}*/
		
	}
	
}


