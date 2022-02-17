package com.min.edu.ctrl;

import org.apache.log4j.Logger;

import com.min.edu.model.IInfoService;
import com.min.edu.model.InfoServiceImpl;
import com.min.edu.vo.InfoVo;

public class InfoController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private IInfoService service;
	
	public InfoController() {
		service = new InfoServiceImpl();
	}
	
	public InfoVo commandInsert(InfoVo vo) {
		logger.info("InfoController insert 실행");
		return service.afterInsert(vo);
	}
	
}
