package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 환경설정 파일인 SqlMapConfig.xml(+Mapper) 파일을 읽어서 Java객체인 SqlSessionFactory객체를 만들어줌
 * 입력해야 될 값(설정)이 많기 때문에 xml을 통해서 작성 한 후  IO를 통해서 읽어 낸다.
 * 웹 시스템 CRUD가 기본이기 때문에 static 생성자를 통해서 실행 
 */
public class SqlSessionFactoryManager {

	private static SqlSessionFactory factory;
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	static {
		//사용할 xml의 위치를 => IO읽는 메소드를 사용함 Resources
		String path ="com/min/edu/mybatis/SqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("SqlSeesionFactory 객체 성공");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
