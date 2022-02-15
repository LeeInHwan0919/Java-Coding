package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;

public class JobsSelectDaoImpl implements IJobsSelectDao {
//1) 사용자 로그
	private Logger log = Logger.getLogger(this.getClass());
//2) SqlSessionFactory
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
//3) 클래스에서 호출하게 NameSpace를 변수 선언
	private final String NS = "com.min.edu.model.JobsSelectDaoImpl.";
	
	@Override
	public Integer select01(String id) {
		log.info("Primitive를 사용한 Parameter 전달과 결과 값 받기");
		SqlSession session = manager.openSession();	//default가 false임. Transaction이 동작되는 환경
		int n = session.selectOne(NS+"select01", id);
		return n;
	}
	
	
	@Override
	public MyBatisVo select02(String id) {
		log.info("Primitive를 사용하여 Parameter를 전달. 결과는 VO객체로 반환한다 \n"
				+ "MyBatis 절달되는 Prameter를 Object 처리가 되기 때문에 작성하지 않아도 된다");
		SqlSession session =  manager.openSession();
		return session.selectOne(NS +"select02", id);
	}


	@Override
	public MyBatisVo select03(Object job_id) {
		log.info("Object로 Parameter를 전달. 결과릐 Column명이 다른 경우 resultMap");
		SqlSession session = manager.openSession();
		MyBatisVo vo = session.selectOne(NS + "select03", job_id);
		return vo;
	}


	@Override
	public List<MyBatisVo> select03_1() {
		log.info("결과의 Column을 Alias처리하여 다른 Vo에 입력받음");
		log.warn("selectOne은 잘 사용하지 않음. selectOne 공집합인 경우 Null을 반환함."
				+ " 하지만 selectList 결과가 List에 담겨 오기 때문에 Null이 발생되지 않는다.");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"select03_1");
	}


	@Override
	public Map<String, MyBatisVo> select04() {
		log.info("결과가 java.util.Map인 경우 key가 되는 컬럼의 값을 작성");
		Map<String, MyBatisVo> jobsMap = null;
		SqlSession session = manager.openSession();
		//{"key", "value"}
		//{"IT_PROG, MyBatisVo}, {"~~", MyBatisVo}
		jobsMap = session.selectMap(NS + "select04", "JOB_ID");
		return jobsMap;
	}


	@Override
	public List<MyBatisVo> select05(MyBatisVo vo) {
		log.info("입력 받은 Parameter가 여러개라면 DTO를 사용하여 값을 전달");
		SqlSession session = manager.openSession();
		List<MyBatisVo> one = session.selectList(NS+"select05", vo);
		return one;
	}


	@Override
	public MyBatisVo select06(Map<String, Object> map) {
		log.info("입력받는 Map 객체를 통해서 key에 맞는 Parameter를 여러개 전송할 수 있다");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"select06", map);

	}


	@Override
	public List<MyBatisVo> select07(Object obj) {
		log.info("CDATA를 통한 문자열 처리");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"select07", obj);
	}

}
