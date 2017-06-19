package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.LanguageDao;
import com.newlecture.web.entity.Language;

public class MyBatisLanguageDao implements LanguageDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Language> getList(int page, String field, String query) {
		LanguageDao languageDao;
		languageDao = sqlSession.getMapper(LanguageDao.class);

		return languageDao.getList(page, field, query);
	}

	@Override
	public List<Language> getList(int page) {

		return getList(page, "TITLE", "");
	}

	@Override
	public List<Language> getList() {

		return getList(1, "TITLE", "");
	}

	@Override
	public Language get(String id) {
		LanguageDao languageDao;
		languageDao = sqlSession.getMapper(LanguageDao.class);

		return languageDao.get(id);
	}

	@Override
	public int add(Language language) {
		LanguageDao languageDao;
		languageDao = sqlSession.getMapper(LanguageDao.class);

		return languageDao.add(language);
	}

	@Override
	public int update(Language language) {
		LanguageDao languageDao;
		languageDao = sqlSession.getMapper(LanguageDao.class);

		return languageDao.update(language);
	}

	@Override
	public int delete(String id) {
		LanguageDao languageDao;
		languageDao = sqlSession.getMapper(LanguageDao.class);

		return languageDao.delete(id);
	}

	@Override
	public List<Language> getListOfLecture(String lectureId) {
		LanguageDao languageDao;
		languageDao = sqlSession.getMapper(LanguageDao.class);

		return languageDao.getListOfLecture(lectureId);
	}
}