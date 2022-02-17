package com.min.edu.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.InfoVo;

/**
 * Info의 기능을 단위로 갖고있는 클래스
 * @author rladn
 *
 */
public class InfoSelectkeyDaoImpl implements IInfoSelectkeyDao{

	private Logger logger = Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.InfoSelectkeyDaoImpl.";
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	
	@Override
	public int insertInfo(InfoVo vo) {
		logger.info("insertInfo 처음 입력받은 VO의 SEQ값 " + vo.getSeq());
		SqlSession session = manager.openSession(true);
		int row = session.insert(NS+"insertinfo", vo);
		logger.info("insertInfo 쿼리에서 selectkey에 의해 변경된 VO의 seq값" + vo.getSeq());
		return row;
	}

	@Override
	public InfoVo selectOneInfo(InfoVo vo) {
		logger.info("selectOneInfo 방금입력된 SEQ값 : " + vo.getSeq());
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectOneOInfo", vo);
	}
	
}
