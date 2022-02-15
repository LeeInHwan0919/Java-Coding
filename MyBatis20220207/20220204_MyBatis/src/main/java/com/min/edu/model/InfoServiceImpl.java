package com.min.edu.model;

import org.apache.log4j.Logger;

import com.min.edu.vo.InfoVo;

public class InfoServiceImpl implements IInfoService {
	private Logger logger = Logger.getLogger(this.getClass());
	private IInfoSelectkeyDao dao;
	
	public InfoServiceImpl() {
		dao = new InfoSelectkeyDaoImpl();
	}
	
	@Override
	public InfoVo afterInsert(InfoVo vo) {
		logger.info("입력 후 상세조회 실행");
		int row = dao.insertInfo(vo);
		logger.info("입력 한 갯수 :" + row);
		InfoVo resultVo = dao.selectOneInfo(vo);
		
		return resultVo;
	}

}
