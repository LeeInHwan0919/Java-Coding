package BlackJack;

import java.util.Scanner;

public class BlackJackGame {

	public void BlackJackGame() {
		Rule rule = new Rule();
		
		Scanner scan = new Scanner(System.in);

		System.out.print("사용할 덱의 개수를 입력해주세요 >> ");
		int deckEa = scan.nextInt();
		System.out.println(deckEa + "개의 덱, " + (deckEa * 52) + "개의 카드를 사용합니다.");
		System.out.println();
		CardPool CP = new CardPool(deckEa);

		Player User = new Player();
		User.addCard(CP.drawCard());
		User.addCard(CP.drawCard());
		System.out.println("당신의 카드는 " + User.getHand().toString() + " 입니다.");

		Player Dealer = new Player();
		Dealer.addCard(CP.drawCard());
		Dealer.addCard(CP.drawCard());
		System.out.println("딜러가 공개한 카드는 " + Dealer.get(0).toString() + " 입니다.");
		System.out.println();

		if (rule.checkBlackjack(User.getHand())) {
			System.out.println("당신의 BlackJack으로 승리했습니다.");
		} else {
			ScoreTable Table = new ScoreTable();
			System.out.println("당신의 차례입니다.");
			while (true) {
				System.out.print("카드를 더 받으시겠습니까 ? (hit/stand) >> ");
				String str = scan.next();
				System.out.println();

				if (str.equals("hit")) {

					BlackJackImpl cardInput = CP.drawCard();
					System.out.println(cardInput.toString() + " 를 받았습니다.");
					User.addCard(cardInput);
					System.out.println("당신의 카드는 " + User.getHand().toString() + " 입니다.");
					System.out.println();


					if (rule.is_bust(Table, User.getHand())) {
						System.out.println("패의 총합이 21을 초과하여 패배했습니다.");

						break;
					}

				} else if (str.equals("stand")) {
					System.out.println("당신의 차례가 끝났습니다.");
					System.out.println();
					System.out.println("딜러의 차례입니다.");
					System.out.println("딜러의 카드는 " + Dealer.getHand().toString() + " 입니다.");
					System.out.println();

					if (rule.checkBlackjack(Dealer.getHand())) {
						System.out.println("딜러의 BlackJack으로 패배했습니다.");
					} else {
						while (true) {
							if (rule.computeScore(Table, Dealer.getHand()) < 17) {
								BlackJackImpl cardInput = CP.drawCard();
								System.out.println("딜러는 " + cardInput.toString() + " 를 받았습니다.");
								Dealer.addCard(cardInput);
								System.out.println("딜러의 카드는 " + Dealer.getHand().toString() + " 입니다.");
								System.out.println();
							}

							if (rule.is_bust(Table, Dealer.getHand())) {
								System.out.println("딜러 패의 총합이 21을 초과하여 승리했습니다.");
								break;
							}

							else if (rule.computeScore(Table, Dealer.getHand()) > 16
									&& rule.computeScore(Table, Dealer.getHand()) < 22) {
								System.out.println("딜러의 차례가 끝났습니다.");
								System.out.println();


								int userScore = rule.computeScore(Table, User.getHand());

								int dealerScore = rule.computeScore(Table, Dealer.getHand());

								System.out.println("유저: " + userScore + " vs 딜러: " + dealerScore);
								if (userScore < dealerScore) {
									System.out.println("패배했습니다.");
								} else if (userScore == dealerScore) {
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
	}


}
