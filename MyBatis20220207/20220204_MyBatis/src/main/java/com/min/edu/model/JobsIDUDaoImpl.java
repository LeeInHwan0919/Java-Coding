package com.min.edu.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;

public class JobsIDUDaoImpl implements IJobsIDUDao{

	private Logger logger = Logger.getLogger(JobsIDUDaoImpl.class);
	private final String NS = "com.min.edu.model.JobsIDUDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	@Override
	public int insert01(MyBatisVo vo) {
		SqlSession session = manager.openSession(true); // false일 경우 manual commit
		int row = session.insert(NS+"insert01", vo);
		return row;
	}

	@Override
	public int delete01(Map<String, Object> map) {
		logger.info("삭제 실행");
		SqlSession session = manager.openSession(true);
		// Map을 parameter로 사용할때는 key를 정확하게 입력
		int row = session.delete(NS+"delete01", map);
		return row;
	}

	@Override
	public int update01(Map<String, Object> map) {
		logger.info("수정 map을 통한 값을 전달");
		manager.openSession(true);
		SqlSession session = manager.openSession();
		int row = session.update(NS+"update01", map);
		return row;
	}
	
}
