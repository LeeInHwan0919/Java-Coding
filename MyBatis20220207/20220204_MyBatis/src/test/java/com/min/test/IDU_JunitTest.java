package com.min.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.model.IJobsIDUDao;
import com.min.edu.model.JobsIDUDaoImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.MyBatisVo;

public class IDU_JunitTest {

//	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}

//	@Test
	public void insertTest() {
		IJobsIDUDao dao = new JobsIDUDaoImpl();
		//java의 객체의 전달은 pass By Reference : 얕은 복사
		MyBatisVo vo = new MyBatisVo("IT", "Developer", 1000,2000);
		int row = dao.insert01(vo);
		assertEquals(row, 1);
	}
	
//	@Test
	public void deleteTest() {
		IJobsIDUDao dao = new JobsIDUDaoImpl();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", "PR_REP");
		int row = dao.delete01(map);
		assertEquals(row, 1);
	}
	
	@Test
	public void updateTest() {
		IJobsIDUDao dao = new JobsIDUDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newid", "SW");
		map.put("newtitle", "SOFTWARE");
		map.put("oldid", "IT");
		map.put("oldtitle", "DEVELOPER");
		int row = dao.update01(map);
		assertEquals(row, 1);
	}
	
}
