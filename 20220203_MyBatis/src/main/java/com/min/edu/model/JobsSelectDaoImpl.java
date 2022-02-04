package com.min.edu.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;

public class JobsSelectDaoImpl implements IJobsSelectDao {
// 1) 사용자 로그
	private Logger log = Logger.getLogger(this.getClass());
// 2) SqlSessionFactory
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
// 3) 클래스에서 호출하게 NameSpace를 변수 선언
	private final String NS = "com.min.edu.model.JobsSelectDaoImpl.select01";
	@Override
	public Integer select01(String id) {
		log.info("Primitive를 사용한 Parameter 전달과 결과 값 받기");
		SqlSession session =  manager.openSession(false); // default false Transaction이 동작되는 환경
		int n = session.selectOne(NS+"select01",id);
		return n;
	}
	@Override
	public MyBatisVo select02(String id) {
		log.info("Primitive를 사용하여 Parameter를 전달 결과는 VO객체로 반환한다. \n"
				+ "MyBatis 절 되는 Parameter 를 Object처리가 되기 때문에 작성하지 않아도 된다.");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"select02", id);
	}
	

}
