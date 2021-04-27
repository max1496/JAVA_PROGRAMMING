package MUD����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
    private int index;
//    ���� �ε���
    private ArrayList<String> deck;
//    ī�� ���� ��� ����Ʈ�� ����

    public Blackjack() {
        index = 0;
//        �ʱ�ȭ
        deck = new ArrayList<String>();
//        �ʱ�ȭ
        String[] cardType = {"s", "c","h","d"};
        String[] cardNumber = {"A", "2","3", "4", "5","6","7","8","9", "10", "J","Q","K"};
        for (int i = 0; i < 4; i++) {
//        	4���� ī��Ÿ�Ե���
            for (int j = 0; j <13; j++) {
//            	13���� ī�� �ѹ���������
                String card = cardType[i] + cardNumber[j];
//                ī�� ����
                deck.add(card);
//                ī�带 ���� �־���
            }
        }
//        �� ����
        Collections.shuffle(deck);
    }
//    ī�� ���� �Լ�
    public String pick() {
        return deck.get(index++);
    }


    public void printCard(boolean blind, Unit unit) {
        if (blind == true) {
//        	������ ī�� ����
            for (int i = 0; i < unit.getCards().size(); i++) {
//            	ī�� ������ũ�� ����
                if (i == 0) {
//                	ù��° ī���
                    System.out.print(unit.getCards().get(i));
                } else {
                    System.out.print("/?");
//                    blind�� ����ǥ ���
                }
            }
        } else {
            for (int i = 0; i < unit.getCards().size(); i++) {
//            	ī�� ������ũ�� ����
                if (i == 0) {
//                	ù��° ī���
                    System.out.print(unit.getCards().get(i));
                } else {
                    System.out.print("/" + unit.getCards().get(i));
                }
            }
        }

    }
    public void printGameStatus(boolean blind, Player player, Boss boss) {
//    	���� ���� ����Լ�
        System.out.print("�ȳ� > ���� : ");
        printCard(blind, boss);
//        ���� ī�� ���
        System.out.print("  |  �÷��̾� : ");
        printCard(false, player);
//        �÷��̾� ī�� ���
        System.out.println();
    }

    public int playBossTurn(Boss boss) {
        while(true) {
//            ���� ī�� ������ 16���� ���ų� ������ ���� �̾ƶ�
            if (boss.getCardScore() <= 16) {
                boss.getCards().add(pick());
            } else {
                return boss.getCardScore();
//                �ƴϸ� ī�彺�ھ� ����
            }
        }
    }

    public boolean playBlackjack(Player player, Boss boss) {
//    	���� �÷��� �Լ�
//       2�徿 ī�� �̱�
        player.getCards().add(pick());
        player.getCards().add(pick());
        boss.getCards().add(pick());
        boss.getCards().add(pick());
        System.out.println("�ȳ� > �÷��̾� ("+ player.getHp() + "/" +player.getTotalHp() + ")    / ���� (" + boss.getHp() +"/" +  boss.getTotalHp() + ")");
//�ȳ� ���
        while(true) {
//        	��� �ݺ�
            printGameStatus(true, player, boss);
//            ���� ���� ���
            Scanner sc = new Scanner(System.in);
//            �Է¹���
            char rule = sc.next().charAt(0);
//            ù���ڸ� ���� �꿡 ����
            if (rule == 'h') {
//            	��Ʈ�϶�
                player.getCards().add(pick());
//                ī�带 ����
                if (player.getCardScore() > 21) {
//                	����Ʈ�� ��
                    break;
//                    ��������
                }
            } else if (rule == 's') {
//            	���ĵ��ϋ�
                playBossTurn(boss);
//                ������ ����
                break;
//                �ݺ��� ��������
            } else {
                System.out.println("�ȳ�> �߸��� ��ɾ��Դϴ�. �ٽ� �Է��ϼ���.");
            }
        }
        printGameStatus(false, player, boss);
//        ������ ī�带 ������ ����ä ���� ���� ����ϴ� �Լ�
        if (player.getCardScore() > 21) {
//        	����Ʈ�� ��
            System.out.println("�ȳ� > ����: " + boss.getCardScore() + " | �÷��̾� : " + player.getCardScore() + "(����Ʈ)");
            return false;
        } else if (player.getCardScore() == 21) {
//        	�����϶�
            System.out.println("�ȳ� > ����: " + boss.getCardScore() + " | �÷��̾� : " + player.getCardScore() + "(����)");
            return true;
        } else if (boss.getCardScore() > 21) {
//        	������ ����Ʈ ������
            System.out.println("�ȳ� > ����: " + boss.getCardScore() + " (����Ʈ)" + " | �÷��̾� : " + player.getCardScore() + "(����)");
            return true;
        } else if (boss.getCardScore() == 21) {
//        	������ ������ ��
            System.out.println("�ȳ� > ����: " + boss.getCardScore() + " (����)" + " | �÷��̾� : " + player.getCardScore() + "(����)");
            return false;
        } else if (player.getCardScore() >= boss.getCardScore()) {
//        	�÷��̾��� ���ھ �� ������
            System.out.println("�ȳ� > ����: " + boss.getCardScore() + " | �÷��̾� : " + player.getCardScore());
            return true;
        } else {
            System.out.println("�ȳ� > ����: " + boss.getCardScore() + " | �÷��̾� : " + player.getCardScore());
            return false;
        }
    }

    public boolean whoseWin(boolean win, Player player, Boss boss) {
//    	���� �̰���� �Ǻ��ϴ� �Լ�
        boolean alive;
//        ������ �÷��̾ ����ִٴ� ����
        if (win) {
//        	�÷��̾ �̰�����
            System.out.print("�ȳ� > �÷��̾� �¸� | ");
            if (player.getCardScore() == 21) {
//            	�÷��̾ �����϶�
            	alive = boss.attacked(true, player);
//            	������ 2���� ���ݷ����� ���ݹ���
            } else {
            	alive = boss.attacked(false, player);
//            	������ ���ݹ���
            }
        } else {
            System.out.print("�ȳ� > ���� �¸� | ");
            if (boss.getCardScore() == 21) {
//            	������ �����϶�
            	alive= player.attacked(true, boss);
//            	�÷��̾ 2���� ���ݷ����� ���ݹ���
            } else {
            	alive = player.attacked(false, boss);
//            	�÷��̾ ���ݹ���
            }
        }
        System.out.println("�÷��̾� ("+ player.getHp() + "/" +player.getTotalHp() + ")    / ���� (" + boss.getHp() +"/" +  boss.getTotalHp() + ")");
        return alive;
    }

    public boolean matchGame(Player player, Boss boss) {
        while(true) {
//        	��� ����
            boolean win = playBlackjack(player, boss);
//            ������ �÷����ϰ� ����� win�� ����
           

            boolean alive = whoseWin(win, player, boss);
//            �̰���� ��� ����
            player.getCards().clear();
            boss.getCards().clear();
//          ���ֵ� ī�� �ʱ�ȭ      
            if (alive == false) {
                if (win) {
//                	������ ����ģ ���
                    System.out.println("�ȳ�> ������ �����ƽ��ϴ�.");
                    player.addTotalHp(2);
//                    �÷��̾� ü�� ����
                    return win;
                } else {
//                	�÷��̾ �� ���
                    System.out.println("�ȳ�> Game Over");
                    return win;
                }
            }
        }
    }
}
