package com.min.game;

import java.util.Scanner;

import com.min.card.Card;
import com.min.card.CardConvert;
import com.min.card.CardCreate;
import com.min.card.CardReturn;

/**
 * UI + Game Process 클래스
 * 
 * @author 쿼카
 * @since 2022-01-20
 */
public class BlackJackGame {

	public void BlackJackGame() {
		Rule rule = new Rule();

		System.out.println("♦♠♥♣♦♠♥♣BlackJack♦♠♥♣♦♠♥♣");

		Scanner scan = new Scanner(System.in);
		String answer = "Y";

		while (true) { // 게임의 시작
			System.out.println("게임을 시작하시겠습니까? \n 시작(Y)      종료(N)");

			answer = scan.nextLine();

			// 입력받은 문자열이 "N or n"일 경우 게임을 종료
			if (answer.toUpperCase().trim().compareTo("N") == 0) {
				System.out.println("게임을 종료하겠습니다.");
				break;

				// 입력받은 문자열이 "Y or y"일 경우 게임을 시작
			} else if (answer.toUpperCase().trim().compareTo("Y") == 0) {
				System.out.println("게임을 시작하겠습니다.");
				System.out.println();

				// 게이머가 카드 두장을 받음
				CardCreate CC = new CardCreate();
				CardReturn Gamer = new CardReturn();
				Gamer.addCard(CC.CardDraw());
				Gamer.addCard(CC.CardDraw());
				System.out.println("당신의 카드는 " + Gamer.getCardHand().toString() + " 입니다.");

				// 딜러가 카드 두장을 받고 한 장을 숨김
				CardReturn Dealer = new CardReturn();
				Dealer.addCard(CC.CardDraw());
				Dealer.addCard(CC.CardDraw());
				System.out.println("딜러가 공개한 카드는 [" + "몰?루" + "]," + Dealer.get(1).toString() + " 입니다.");

				// 게이머가 블랙잭인 경우 = While 종료
				if (rule.isBlackJack(Gamer.getCardHand())) {
					System.out.println("당신의 BlackJack으로 승리했습니다.");

					// 게이머가 블랙잭이 아닌 경우 = 게임 진행
				} else {
					CardConvert hash = new CardConvert();
					System.out.println("당신의 차례입니다.");

					// 게임 진행
					while (true) {
						System.out.print("카드를 더 받으시겠습니까 ? (hit/stand) >> ");
						String str = scan.next();
						System.out.println();

						// 게이머가 hit를 입력 했을 경우
						if (str.equals("hit")) {

							// 카드 한장 드로우
							Card InputCard = CC.CardDraw();
							System.out.println(InputCard.toString() + " 를 받았습니다.");

							// 드로우된 카드를 게이머 패(cardhand)에 넣어준다.
							Gamer.addCard(InputCard);
							System.out.println("당신의 카드는 " + Gamer.getCardHand().toString() + " 입니다.");
							System.out.println();

							// 게이머 버스트 판단 (버스트라면 게임종료)
							if (rule.isBust(hash, Gamer.getCardHand())) {
								System.out.println("패의 총합이 21을 초과하여 패배했습니다.");
								break;
							}
							
							// 게이머가 stand를 입력 했을 경우
						} else if (str.equals("stand")) {
							System.out.println("당신의 차례가 끝났습니다.");
							System.out.println();
							System.out.println("딜러의 차례입니다.");
							System.out.println("딜러의 카드는 " + Dealer.getCardHand().toString() + " 입니다.");
							System.out.println();

							// 딜러의 블랙잭판단
							if (rule.isBlackJack(Dealer.getCardHand())) {
								System.out.println("딜러의 BlackJack으로 패배했습니다.");
							} else {
								// 딜러가 블랙잭이 아닌 경우, 딜러의 카드패의 합이 17미만일 경우 hit
								while (true) {
									if (rule.Score(hash, Dealer.getCardHand()) < 17) {
										Card cardInput = CC.CardDraw();
										System.out.println("딜러는 " + cardInput.toString() + " 를 받았습니다.");
										Dealer.addCard(cardInput);
										System.out.println("딜러의 카드는 " + Dealer.getCardHand().toString() + " 입니다.");
										System.out.println();
									}

									// 딜러의 버스트판단
									if (rule.isBust(hash, Dealer.getCardHand())) {
										System.out.println("딜러 패의 총합이 21을 초과하여 승리했습니다.");
										break;
									}
									// 버스트 아니고, 딜러의패가 17이상 그리고 21이하 일때, 스탠드
									else if (rule.Score(hash, Dealer.getCardHand()) > 16
											&& rule.Score(hash, Dealer.getCardHand()) < 22) {
										System.out.println("딜러의 카드합이 17이 넘어 stand합니다.");
										System.out.println("딜러의 차례가 끝났습니다.");
										System.out.println();

										// 게이머 패와 딜러 패 점수
										int gamerScore = rule.Score(hash, Gamer.getCardHand());
										int dealerScore = rule.Score(hash, Dealer.getCardHand());

										System.out.println("당신의 점수: " + gamerScore + " vs 딜러의 점수: " + dealerScore);

										// 점수비교 > 승부판단
										if (gamerScore < dealerScore) {
											System.out.println("패배했습니다.");
										} else if (gamerScore == dealerScore) {
											System.out.println("무승부");
										} else {
											System.out.println("승리했습니다.");
										}
										break;
									}
								}
							}
							break;
						}
					}
				}
				break;
			}
		} // 게임의 끝

	}

}
