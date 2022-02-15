package com.min.edu.model;

import com.min.edu.vo.InfoVo;

/**
 * 여러개의 DAO를 조합하여 처리하는 interface
 * 
 *
 */
public interface IInfoService {
	/**
	 * 두개의 동작인 insert와 select를 묶어서 실행 시켜 주는 메소드
	 * @param vo 전달 값 그리고 selectkey의 대상이 되는 setSeq()가지고 있는 객체
	 * @return 입력한 row의 select된 결과
	 */
	public InfoVo afterInsert(InfoVo vo);
}
