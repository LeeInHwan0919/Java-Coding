package com.min.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.model.IJobsDynamicDao;
import com.min.edu.model.JobsDynamicDaoImpl;
import com.min.edu.vo.MyBatisVo;

public class Dynamic_JunitTest {

	private IJobsDynamicDao dao;
	
	@Before
	public void create() {
		dao = new JobsDynamicDaoImpl();
	}
	
	@Test
	public void updateJobsTrim() {
		MyBatisVo vo = new MyBatisVo();
//		vo.setJob_title("개발자");
		vo.setMin_salary(100000);
		int row = dao.updateJobsTrim(vo);
		System.out.println(row);
	}
	
//	@Test
	public void updateJobsSet() {
		MyBatisVo vo = new MyBatisVo();
		vo.setJob_title("P");
//		vo.setJob_id("I");
		int row = dao.updateJobsSet(vo);
		System.out.println(row);
	}
	
//	@Test
	public void getJobsTrim() {
		MyBatisVo vo = new MyBatisVo();
		vo.setJob_title("Programmer");
		vo.setJob_id("IT_PROG");
		List<MyBatisVo> lists = dao.getJobsTrim(vo);
		System.out.println(lists);
	}
	
//	@Test
	public void getJobsChoose() {
		MyBatisVo vo = new MyBatisVo();
		vo.setJob_title("SOFTWARE");
		vo.setJob_id("IT_PROG");
		List<MyBatisVo> lists = dao.getJobsChoose(vo);
		System.out.println(lists);
	}
	
//	@Test
	public void getJobsMap() {
		String[] checks = {"IT_PROG", "ST_CLERK"};
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("ids", checks);
		List<MyBatisVo> lists = dao.getJobsMap(map);
		System.out.println(lists);
	}
	
//	@Test
	public void getJobsList() {
		String[] checks = {"IT_PROG", "ST_CLERK"};
		List<String> list = Arrays.asList(checks);
		List<MyBatisVo> lists = dao.getJobsList(list);
		System.out.println(lists);
	}
	
//	@Test
	public void getJobIf() {
		Map<String, Object> map =
				new HashMap<String, Object>();
		map.put("job_id", "ST_CLERK");
		List<MyBatisVo> lists = dao.getJobsIf(map);
		System.out.println(lists);
	}

}
