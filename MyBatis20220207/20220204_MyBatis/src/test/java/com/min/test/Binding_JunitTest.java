package com.min.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.model.IJobsBindingDao;
import com.min.edu.model.JobsBindingDaoImpl;
import com.min.edu.vo.MyBatisVo;

public class Binding_JunitTest {

	@Test
	public void bounding02() {
		IJobsBindingDao dao = new JobsBindingDaoImpl();
		Map<String, Object> map =
				new HashMap<String, Object>();
//		map.put("val", "IT"); //값만 전달하고 XML에서 concat
		map.put("val", "AD%");
		List<MyBatisVo> lists = dao.binding02(map);
		System.out.println(lists);
	}
	
	
//	@Test
	public void test() {
		IJobsBindingDao dao = new JobsBindingDaoImpl();
		Map<String, Object> map =
				new HashMap<String, Object>();
//		map.put("column", "JOB_ID");
		map.put("column", "'a'='a' or JOB_ID ");
		map.put("value", "IT_PROG");
		List<MyBatisVo> lists = dao.binding01(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	

}
