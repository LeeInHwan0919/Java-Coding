package com.min.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.IJobsSelectDao;
import com.min.edu.model.JobsSelectDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;

/*
 * ■ assert명령어는 완성된 객체를 테스트 하기 위한 메소드
 * assertArrayEquals(a,b)
 * assertNotNull(a)
 * assertTrue(a)
 * ■ Annotation
 * @Test 테스트가 수행되는 메소드
 * @Before 다른 테스트가 수행되기 전에 실행되는 메소드
 * @After 다른 테스트를 수행 후에 실행되는 메소드
 */
public class MyBatis_JunitTest {

	SqlSession session;
	IJobsSelectDao dao = new JobsSelectDaoImpl();
	
//	@Test //얘가없으면 run Junit Test가 뜨지 않음
	@Before
	public void createSession() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		session = manager.openSession(); // Transaction이 자동으로 처리 됨. default(false)
		assertNotNull(session);
	}

	@Test
	public void select02() {
		MyBatisVo vo = dao.select02("IT_PROG");
		System.out.println("IT_PROG 정보 " + vo);
		assertNotNull(vo);
	}
	
	//org.apache.ibatis.exceptions.PersistenceException:밑에 test 작성하고 뜸
//	@Test
	public void select01() {
		int n = dao.select01("IT_PROG");
		System.out.println("IT_PROG 의 " + n);
		assertNotNull(n);
	}
	
//	@Test
	public void selectJobsAll() {
		List<MyBatisVo> jobsAll = 
		session.selectList("com.min.edu.jobs.selectJobsAll");
		System.out.println(jobsAll);
		assertNotNull(jobsAll);
	}

}
