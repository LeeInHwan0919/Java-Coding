package com.min.edu.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.min.edu.ctrl.QuokkaController;
import com.min.edu.service.IQuokkaService;
import com.min.edu.service.QuokkaServiceImpl;
import com.min.edu.vo.AdminVo;

public class AdminFunction {

	private static AdminVo vod;
	private static Object obj;
	private static Map<String, Object> map = new HashMap<String, Object>();

	public void Function(){

		IQuokkaService iq = new QuokkaServiceImpl();
		QuokkaController ctrl = new QuokkaController();
		Scanner scan = new Scanner(System.in);

		int numcnt = 0;
		String ibirthdate = "";
		String strPattern = "^[a-zA-z가-힣]*$";
		String datePattern = "^\\d{4}-\\d{2}-\\d{2}$";

		
		
		while (numcnt == 0) {
			System.out.println("쿼카제과 물류관리 시스템입니다. 로그인 또는 회원가입을 해주세요.\n" + "1. 로그인  2.회원가입  3.아이디 찾기  4.비밀번호 찾기 5.종료");
			System.out.print("> ");
			int first = scan.nextInt();
			switch (first) {
			case 1:
				numcnt = 1;
				while (true) {
					System.out.println("로그인을 해주세요.");
					System.out.print("ID : ");
					String id = scan.nextLine();
					System.out.print("PW : ");
					String pw = scan.nextLine();

					try {
						AdminVo enterLogin = ctrl.Login(id, pw);
						if (enterLogin.getId().isEmpty() == false) {// 값이 있다면 FALSE
							System.out.println(enterLogin.getName() + "님 반갑습니다. 화면으로 넘어갑니다.");
							break;
						}
					} catch (NullPointerException e) {
						System.out.println("로그인을 실패하였습니다. 다시 입력해주세요.");
					}
				}
				break;
			case 2:
				while (true) {
					String iid ="";
					int cnt = 0;
					try {
						System.out.println("회원가입을 시작합니다.");
						
						System.out.println("아이디를 입력해주세요");
						iid = scan.next();		
						
//						System.out.println(iq.IDAll(iid));
						
						System.out.println("패스워드를 입력해주세요");
						String ipw = scan.next();

						System.out.println("이름을 입력해주세요");
						String iname = scan.next();

						while (true) {
							System.out.println("생년월일을 입력해주세요 ex) 2022-02-22");
							ibirthdate = scan.next();
							if (!Pattern.matches(datePattern, ibirthdate)) {
								System.out.println("날짜 형식에 맞게 다시 입력해주세요.");
							} else {
								break;
							}
						}

						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						Date date = formatter.parse(ibirthdate);

						System.out.println("전화번호를 입력해주세요");
						String iphonenum = scan.next();

						ctrl.insertAdmin(iid, ipw, iname, date, iphonenum);

						System.out.println("계정이 생성되었습니다.");
						break;

					} catch (Exception e) {
						System.out.println("값의 길이가 너무 길거나 값이 비었습니다.\n\n\n\n");
						System.out.println("다시 입력 해주세요.");
					}
				}
				break;

			case 3:
				while (true) {
					try {
						System.out.println("이름을 입력해주세요. ex)홍길동");
						String name = scan.next();
						if (!Pattern.matches(strPattern, name)) {
							System.out.println("이름형식이 맞지 않습니다. 다시 확인해주세요.");
						} else {
							while (true) {
								System.out.println("전화번호를 입력해 주세요. ex)01012345678");
								String phonenum = scan.next();
								AdminVo findID = ctrl.selectID(name, phonenum);
								System.out.println("당신의 아이디는 " + findID.getId() + "입니다. ");
								break;
							}
							break;
						}
					} catch (NullPointerException e) {
						System.out.println("아이디가 존재하지 않습니다. 다시 입력해주세요.");
					}
				}

				break;
			case 4:
				int cnt = 0;
				while (true) {
					try {
						System.out.println("아이디를 입력해주세요.");
						String id = scan.next();

						System.out.println("이름을 입력해주세요. ex)홍길동");
						String name = scan.next();
						if (!Pattern.matches(strPattern, name)) {
							System.out.println("이름형식이 맞지 않습니다. 다시 확인해주세요.");
						} else {
							AdminVo findPW = ctrl.selectPW(id, name);
							System.out.println(findPW.getPw());
							System.out.println("비밀번호 찾아드렸습니다.");
							cnt++;
							break;
						}

					} catch (NullPointerException e) {
						System.out.println("아이디 혹은 이름이 일치하지 않습니다.");
					}
				}
				break;
			case 5:
				numcnt = 1;
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
				break;
			}
		}

//			 계정삭제--이인환
//			ctrl.deleteAdmin(vod);
//			System.out.println("계정이 삭제되었습니다.");

	}
}
