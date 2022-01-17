package com.min.edu;

import java.util.Scanner;

import com.min.edu.card.CardDeck;
import com.min.edu.game.Player;
/**
 * 실행과 출력을 위한 메인
 * @author 집사들
 * 2022-01-16
 */

public class BlackJackMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("시작할려면 1을 눌러주세요");
		Player User = new Player();
		int n = scan.nextInt();
		CardDeck CP = new CardDeck(n);
    	User.addCard(CP.drawCard());
    	User.addCard(CP.drawCard());
    	System.out.println("당신의 카드는 " + User.getHand().toString() + " 입니다." );

	}

}
