package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;

public class JobsBindingDaoImpl implements IJobsBindingDao{

	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.JobsBindingDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	@Override
	public List<MyBatisVo> binding01(Map<String, Object> map) {
		logger.info("Mybatis에서 바인딩 문법 # $이다.");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"binding01", map);
	}

	@Override
	public List<MyBatisVo> binding02(Map<String, Object> map) {
		logger.info("like문을 사용할 때는 mapper XML 꼭 확인하고 작업");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"binding02", map);
	}

}
