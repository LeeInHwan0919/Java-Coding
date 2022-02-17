package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;

public class JobsDynamicDaoImpl implements IJobsDynamicDao {

	private Logger logger = Logger.getLogger(JobsDynamicDaoImpl.class);
	private final String NS = "com.min.edu.model.JobsDynamicDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	@Override
	public List<MyBatisVo> getJobsIf(Map<String, Object> map) {
		logger.info("입력받은 map의 값 : " + map);
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobsIf", map);
	}

	@Override
	public List<MyBatisVo> getJobsList(List<String> list) {
		logger.info("foreach 문과 List로 처리");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobsList", list);
	}

	@Override
	public List<MyBatisVo> getJobsMap(Map<String, String[]> map) {
		logger.info("foreach 문과 Map으로 처리");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobsMap", map);
	}

	@Override
	public List<MyBatisVo> getJobsChoose(MyBatisVo vo) {
		logger.info("choose 문을 통한 선택적 where 절");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobsChoose",vo);
	}

	@Override
	public List<MyBatisVo> getJobsTrim(MyBatisVo vo) {
		logger.info("Trim 문을 통한 단일 혹은 복합 쿼리의 사용 prefix/suffix overries");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getJobsTrim",vo);
	}

	@Override
    public int updateJobsSet(MyBatisVo vo) {
        logger.info("Set 문을 이용해서 set의 한개 혹은 여러개를 처리할 수 있도록 suffixOverrides 자동으로 한다");
        SqlSession session = manager.openSession();
        session.update(NS+"updateJobsSet", vo);
        return 0;
    }

	@Override
	public int updateJobsTrim(MyBatisVo vo) {
		logger.info("Set문법을 Trim문법으로 변경하여 자동");
		SqlSession session = manager.openSession(true);
		int row = session.update(NS+"updateJobsTrim", vo);
		return row;
	}

}
