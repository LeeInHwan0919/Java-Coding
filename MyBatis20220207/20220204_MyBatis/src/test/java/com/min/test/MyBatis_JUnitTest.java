 package com.min.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.IJobsSelectDao;
import com.min.edu.model.JobsSelectDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;


/*
 * ★assert 명령어는 완성된 객체를 테스트 하기 위한 메소드
 * 	assertArrayEquals(a,b)
 * 	assertNotNull(a)
 * 	assertTrue(a)
 * ★Annotation
 * 	@Test 테스타가 수행되는 메소드
 * 	@Before 다른 테스트가 수행되기 전에 실행되는 메소드ㄴ
 * 	@After 다른 테스트가 수행된 후에 실행되는 메소드
 */
public class MyBatis_JUnitTest {
	
	SqlSession session;
	IJobsSelectDao dao = new JobsSelectDaoImpl();
	
	@Before
	public void creatSession() {
		SqlSessionFactory manager =  SqlSessionFactoryManager.getFactory();
		session = manager.openSession();	//Transaction이 자동으로 처리됨 default(false)
		assertNotNull(session);
		
	}
	@Test
	public void select07() {
		String str = "8000"; // 큰값을 넣으면 범위이기 때문에 toomuch?뭐시기가 나옴....값이 여러개인데 selectone으로 결과를 담을 수 없음 -> 그래서 List로 바꿈
		List<MyBatisVo> vo = dao.select07(str);
		System.out.println(vo);
		assertNotNull(vo);
	}
	
//	@Test
	public void select06() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", 2007155);
		MyBatisVo vo = dao.select06(map);
		System.out.println(vo);
		assertNotNull(vo);	// selectOne 메소드는 공집합이면 null을 반환한다
	}
	
//	@Test
	public void select05() {
		MyBatisVo vo = new MyBatisVo("IT_PROG","Programmer",0,0);
		List<MyBatisVo> one = dao.select05(vo);
		System.out.println(one.get(0));
		assertEquals("결과값 있음", one.size(), 1);
	}
	
//	@Test
	public void select04() {
		Map<String, MyBatisVo> jobsMap = dao.select04();
		System.out.println(jobsMap);
		assertNotNull(jobsMap);
	}
	
//	@Test
	public void select03_1() {
		List<MyBatisVo> lists = dao.select03_1();
		System.out.println(lists);
		// selectlist는 결과를 List객체로 반환하기 때문에 Null 절대로 발생되지 않음.
		// selectOne은 결과가 공집합인 경우 Null로 반환한다
		assertNotNull(lists);
	}
	
//	@Test
	public void select03() {
		String str = "IT_PROG";
		Object obj = str;
		MyBatisVo vo = dao.select03(obj);
		System.out.println(vo);
		assertNotNull(vo);
	}
	
	
//	@Test
	public void select02() {
		MyBatisVo vo = dao.select02("IT_PROG");
		System.out.println("IT_PROG 정보 : " + vo);
		assertNotNull(vo);
	}
	
	
//	@Test
	public void select01() {
		int n = dao.select01("IT_PROG");
		System.out.println("IT_PROG의 "+n);
		assertNotNull(n);
	}
	
//	@Test
	public void selectJobsAll() {
		List<MyBatisVo> jobsAll = session.selectList("com.min.edu.jobs.selectJobsAll");
		System.out.println(jobsAll);
		assertNotNull(jobsAll);
		
	}

}
