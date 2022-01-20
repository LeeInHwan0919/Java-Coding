package com.min.game;

import java.util.Scanner;

import BlackJack.CardReturn;

public class BlackJackGame {

	public void BlackJackGame() {
		Rule rule = new Rule();
		Scanner scan = new Scanner(System.in);

		System.out.println("♦♠♥♣♦♠♥♣BlackJack♦♠♥♣♦♠♥♣");
		String answer = "Y";
		while (true) {
			System.out.println("게임을 시작하시겠습니까? \n 시작(Y)      종료(N)");
			answer = scan.nextLine();
			if (answer.toUpperCase().trim().compareTo("N") == 0) {
				System.out.println("게임을 종료하겠습니다.");
				break;
			} else if (answer.toUpperCase().trim().compareTo("Y") == 0) {
				System.out.println("게임을 시작하겠습니다.");
				System.out.println();
				CardCreate CC = new CardCreate(1);

				CardReturn Gamer = new CardReturn();
				Gamer.addCard(CC.CardDraw());
				Gamer.addCard(CC.CardDraw());
				System.out.println("당신의 카드는 " + Gamer.getCardHand().toString() + " 입니다.");

				CardReturn Dealer = new CardReturn();
				Dealer.addCard(CC.CardDraw());
				Dealer.addCard(CC.CardDraw());
				System.out.println("딜러가 공개한 카드는 [" + "몰?루" + "],"+Dealer.get(1).toString() + " 입니다.");

				if (rule.isBlackJack(Gamer.getCardHand())) {
					System.out.println("당신의 BlackJack으로 승리했습니다.");
				} else {
					CardConvert hash = new CardConvert();
					System.out.println("당신의 차례입니다.");
					while (true) {
						System.out.print("카드를 더 받으시겠습니까 ? (hit/stand) >> ");
						String str = scan.next();
						System.out.println();

						if (str.equals("hit")) {

							Card InputCard = CC.CardDraw();
							System.out.println(InputCard.toString() + " 를 받았습니다.");
							Gamer.addCard(InputCard);
							System.out.println("당신의 카드는 " + Gamer.getCardHand().toString() + " 입니다.");
							System.out.println();


							if (rule.isBust(hash, Gamer.getCardHand())) {
								System.out.println("패의 총합이 21을 초과하여 패배했습니다.");

								break;
							}

						} else if (str.equals("stand")) {
							System.out.println("당신의 차례가 끝났습니다.");
							System.out.println();
							System.out.println("딜러의 차례입니다.");
							System.out.println("딜러의 카드는 " + Dealer.getCardHand().toString() + " 입니다.");
							System.out.println();

							if (rule.isBlackJack(Dealer.getCardHand())) {
								System.out.println("딜러의 BlackJack으로 패배했습니다.");
							} else {
								while (true) {
									if (rule.Score(hash, Dealer.getCardHand()) < 17) {
										Card cardInput = CC.CardDraw();
										System.out.println("딜러는 " + cardInput.toString() + " 를 받았습니다.");
										Dealer.addCard(cardInput);
										System.out.println("딜러의 카드는 " + Dealer.getCardHand().toString() + " 입니다.");
										System.out.println();
									}

									if (rule.isBust(hash, Dealer.getCardHand())) {
										System.out.println("딜러 패의 총합이 21을 초과하여 승리했습니다.");
										break;
									}

									else if (rule.Score(hash, Dealer.getCardHand()) > 16
											&& rule.Score(hash, Dealer.getCardHand()) < 22) {
										System.out.println("딜러가 17이 넘어 강제 스탠드");
										System.out.println("딜러의 차례가 끝났습니다.");
										System.out.println();


										int gamerScore = rule.Score(hash, Gamer.getCardHand());

										int dealerScore = rule.Score(hash, Dealer.getCardHand());

										System.out.println("당신의 점수: " + gamerScore + " vs 딜러의 점수: " + dealerScore);
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
				}break;
			} else {

			}
		}

	}

}
