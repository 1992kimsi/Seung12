package com.newlecture.web.dao.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;


public class SpringMemberDao extends SimpleJdbcDaoSupport implements MemberDao {

	/*1. private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	/*2. private PlatformTransactionManager transactionManager;
	
	@Autowired
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}*/
	
	/*3. @Autowired
	private TransactionTemplate transactionTemplate;*/
	
	@Override
	public Member get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//SUPPORT -> 물었을때는 REQUIRED 참여는 하겠다. 가지고있지않다면 지원하지 않겠다.
	//NOT_SUPPORT -> 그냥 다 지원안할거야.
	@Transactional(propagation=Propagation.NOT_SUPPORTED,
			isolation=Isolation.DEFAULT)
	public int add(String code, String title, String content, int hit){
		String sql1="INSERT INTO NOTICE(CODE, TITLE, WRITER, HIT) "
				+ "VALUES('80', 'test1', 'newlec', 0)";
		
		return getJdbcTemplate().update(sql1);
	}

	//필요. 기본값, 자신을 호출할 때 트랜직션이 없으면 알아서 만듦(자기만의 트랜직션), 있으면 그걸 물고감
	@Transactional(propagation=Propagation.REQUIRED)
	public int pointUp(){
		String sql2 = "UPDATE MEMBER SET POINT = POINT + 1 "
				+ "WHERE MID = 'KSI'";
		
		return getJdbcTemplate().update(sql2);
	}
	
	
	@Override
	public List<Member> getList(String id) {
		// TODO Auto-generated method stub
		return getList(id, "", "");
	}

	@Override
	@Transactional()
	public List<Member> getList(String id, String pwd, String name) {
		
		String sql = "SELECT MID id, PWD pwd FROM MEMBER WHERE MID LIKE ?";
		
		/*String sql1="INSERT INTO NOTICE(CODE, TITLE, WRITER, HIT) "
						+ "VALUES('80', 'test1', 'newlec', 0)";
		  
		String sql2 = "UPDATE MEMBER SET POINT = POINT + 1 "
						+ "WHERE MID = 'KSI'";
		
		
		
		getJdbcTemplate().update(sql1);
		getJdbcTemplate().update(sql2);*/
		
		/*3. transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				getJdbcTemplate().update(sql1);
				getJdbcTemplate().update(sql2);
				
			}
		});*/	
		
		//2. TransactionDefinition def = new DefaultTransactionDefinition();
		//2. TransactionStatus status = transactionManager.getTransaction(def);
		
		/*2. getJdbcTemplate().update(sql1);
		getJdbcTemplate().update(sql2);
		
		transactionManager.commit(status);*/
		
		return getJdbcTemplate().query(sql,
			new BeanPropertyRowMapper(Member.class),
		    String.format("%%%s%%", id));
		
		/*1. return jdbcTemplate.query(sql, new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

			Member m = new Member();
			
			m.setId(rs.getString("mid"));
			m.setPwd(rs.getString("pwd"));
			
			return m;
			}
		});*/
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
