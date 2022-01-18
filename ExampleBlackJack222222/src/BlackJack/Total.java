package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Total extends BlackJackImpl {
	public static int computeScore(ScoreTable table, ArrayList<Card> cards) {
		// (H) table 이용해 card 들의 점수 총합을 리턴
		int count = 0; // 카드의 총합
		int aCard = 0; // A카드를 필요에 따라 1또는 11의 값으로 변경하기 위한 변수

		if (dealer_or_user == true) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = table.score(cards.get(i));

				if (value[0] == 1 && aCard == 0 && (i == 0 || i == 1)) { // 처음 2개의 패 중 1개의 "A"만 있을 경우
					int num11 = value[1]; // "11"
					count += num11;
					aCard++;
				}

				else {
					int num = value[0];
					count += num;
				}
			}
		}

		if (dealer_or_user == false) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = table.score(cards.get(i));

				if (value[0] == 1) { // "A"일 경우(동시에 "A"임을 증명)
					int num1 = value[0]; // "1"
					int num11 = value[1]; // "11"

					if (count > 10) {
						count += num1;
						if (count > 21 && aCard == 1) {
							count = count - 10;
							aCard = 0;
						}
					} else {
						count += num11;
						aCard++;
					}
				} else { // "A"가 아닐경우
					int num = value[0];
					count += num;
					if (count > 21 && aCard == 1) {
						count = count - 10;
						aCard = 0;
					}
				}
			}
		}

		return count;
	}

	public void start() {
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

		if (checkBlackjack(User.getHand())) {
			System.out.println("당신의 BlackJack으로 승리했습니다.");
		} else {
			ScoreTable Table = new ScoreTable();
			System.out.println("당신의 차례입니다.");
			while (true) {
				System.out.print("카드를 더 받으시겠습니까 ? (hit/stand) >> ");
				String str = scan.next();
				System.out.println();

				if (str.equals("hit")) {

					Card cardInput = CP.drawCard();
					System.out.println(cardInput.toString() + " 를 받았습니다.");
					User.addCard(cardInput);
					System.out.println("당신의 카드는 " + User.getHand().toString() + " 입니다.");
					System.out.println();

					dealer_or_user = false;
					if (is_bust(Table, User.getHand())) {
						System.out.println("패의 총합이 21을 초과하여 패배했습니다.");
						dealer_or_user = true;
						break;
					}
					dealer_or_user = true;
				} else if (str.equals("stand")) {
					System.out.println("당신의 차례가 끝났습니다.");
					System.out.println();
					System.out.println("딜러의 차례입니다.");
					System.out.println("딜러의 카드는 " + Dealer.getHand().toString() + " 입니다.");
					System.out.println();

					if (checkBlackjack(Dealer.getHand())) {
						System.out.println("딜러의 BlackJack으로 패배했습니다.");
					} else {
						while (true) {
							if (computeScore(Table, Dealer.getHand()) < 17) {
								sleep(3);
								Card cardInput = CP.drawCard();
								System.out.println("딜러는 " + cardInput.toString() + " 를 받았습니다.");
								Dealer.addCard(cardInput);
								System.out.println("딜러의 카드는 " + Dealer.getHand().toString() + " 입니다.");
								System.out.println();
							}

							if (is_bust(Table, Dealer.getHand())) {
								System.out.println("딜러 패의 총합이 21을 초과하여 승리했습니다.");
								break;
							}

							else if (computeScore(Table, Dealer.getHand()) > 16
									&& computeScore(Table, Dealer.getHand()) < 22) {
								System.out.println("딜러의 차례가 끝났습니다.");
								System.out.println();

								dealer_or_user = false;
								int userScore = computeScore(Table, User.getHand());
								dealer_or_user = true;
								int dealerScore = computeScore(Table, Dealer.getHand());

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

	public static boolean checkBlackjack(ArrayList<Card> cards) {
		// (J) 카드들을 받아 블랙잭인지 아닌지 리턴

		String str1 = cards.get(0).getRank();
		String str2 = cards.get(1).getRank();

		// 패의 2개의 카드 중 하나가 A이고 다른 하나가 10,J,Q,K일 경우 블랙잭
		if (str1.equals("A") && (str2.equals("10") || str2.equals("J") || str2.equals("Q") || str2.equals("K"))) {
			return true;
		} else if (str2.equals("A")
				&& (str1.equals("10") || str1.equals("J") || str1.equals("Q") || str1.equals("K"))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean is_bust(ScoreTable table, ArrayList<Card> cards) {
		// (I) table 이용해 card 들의 점수 총합이 21을 초과하는지 아닌지 리턴
		int count = 0; // 카드의 총합
		int aCard = 0; // A카드를 필요에 따라 1또는 11의 값으로 변경하기 위한 변수

		if (dealer_or_user == true) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = table.score(cards.get(i));

				if (value[0] == 1 && aCard == 0 && (i == 0 || i == 1)) { // 처음 2개의 패 중 1개의 "A"만 있을 경우
					int num11 = value[1]; // "11"
					count += num11;
					aCard++;
				}

				else {
					int num = value[0];
					count += num;
				}
			}
		}

		if (dealer_or_user == false) {
			for (int i = 0; i < cards.size(); i++) {
				int[] value = new int[2];
				value = table.score(cards.get(i));

				if (value[0] == 1) { // "A"일 경우(동시에 "A"임을 증명)
					int num1 = value[0]; // "1"
					int num11 = value[1]; // "11"

					if (count > 10) {
						count += num1;
						if (count > 21 && aCard == 1) {
							count = count - 10;
							aCard = 0;
						}
					} else {
						count += num11;
						aCard++;
					}
				} else { // "A"가 아닐경우
					int num = value[0];
					count += num;
					if (count > 21 && aCard == 1) {
						count = count - 10;
						aCard = 0;
					}
				}
			}
		}

		if (count > 21) {
			return true;
		} else {
			return false;
		}
	}

	public static void sleep(int time) {
		// (K) time 만큼 pause 후 재개. (단위: 밀리세컨드)
		try {
			for (int i = 0; i < time; i++) {
				Thread.sleep(1);
			} // 1ms x time만큼 pause후 재개
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
