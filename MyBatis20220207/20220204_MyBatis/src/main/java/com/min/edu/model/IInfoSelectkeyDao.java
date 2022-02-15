package com.min.edu.model;

import com.min.edu.vo.InfoVo;

/**
 * 각각의 기능을 가지고 있는 interface
 * insert / select
 *
 */
public interface IInfoSelectkeyDao {

	/**
	 * info테이블에 name과 phone을 입력하는 기능
	 * @param vo String name, String phone
	 * @return 성공한 row의 갯수
	 */
	public int insertInfo(InfoVo vo);
	/**
	 * info테이블에서 insert 후에 재입력된 seq값을 VO로 전달받아 select 실행
	 * @param vo 변경된 seq값 Vo
	 * @return seq에 맞는 row결과
	 */
	public InfoVo selectOneInfo(InfoVo vo);
	
}
