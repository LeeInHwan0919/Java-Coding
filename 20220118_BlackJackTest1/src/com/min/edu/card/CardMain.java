package com.min.edu.card;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CardMain {

	public static void main(String[] args) {

		
		int gamercard=0;

		CardCase make = new CardCase();
		List<CardOne> allCard = make.getCardcase();

		System.out.println("=========================================BLACKJACK=========================================");
		
		while (true) {
			System.out.println("게임을 시작 하시겠습니까? 1 : 시작 /  2 : 종료");
			Scanner scan = new Scanner(System.in);
			int sn = scan.nextInt();

			if (sn == 1) {
				System.out.println("게임을 시작합니다.");
				CardOne[] dealer = new CardOne[2];
				for (int i = 0; i < dealer.length; i++) {
					dealer[i] = allCard.get(0);
					allCard.remove(0);
				}
				System.out.println("딜러의 카드입니다." + dealer[0] +  dealer[1]);

				CardOne[] gamer = new CardOne[2];
				for (int i = 0; i < gamer.length; i++) {
					gamer[i] = allCard.get(0);
					allCard.remove(0);
				}

				System.out.println("당신의 카드입니다." + Arrays.toString(gamer));
				
//				int k = 0;
//				while(Arrays.toString(gamer).split("")[3+6*k] != null) {
//				
//				switch (Arrays.toString(gamer).split("")[3+6*k]) {
//				case "A":gamercard =+ 1;break;			
//				case "2":gamercard =+ 2;break;
//				case "3":gamercard =+ 3;break;
//				case "4":gamercard =+ 4;break;
//				case "5":gamercard =+ 5;break;
//				case "6":gamercard =+ 6;break;
//				case "7":gamercard =+ 7;break;
//				case "8":gamercard =+ 8;break;
//				case "9":gamercard =+ 9;break;
//				case "10":gamercard =+ 10;break;
//				case "J":gamercard =+ 11;break;
//				case "Q":gamercard =+ 12;break;
//				case "K":gamercard =+ 13;break;
//				default:
//					break;
//				}
//				if(gamercard >21) {
//					System.out.println("버스트입니다.");
//				}
//				k++;
//			}
//				System.out.println("hit/stay");
//				if(scan.next()=="hit") {
//					System.out.println("hit");
//				}else {
//					System.out.println("stay");
//				}
//				
//
//				break;
			} else if (sn == 2) {
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}

//		System.out.println("user나눠줌 : " + Arrays.toString(user));
//		System.out.println("나머지 카드");
//		System.out.println(make.getCardcase());
//		
//		String card0 = user[0].toString();
//		String[] cardSplit = card0.split("");
//		System.out.println(Arrays.toString(cardSplit));
	}

}
