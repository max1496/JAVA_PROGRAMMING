package MUD����;
import java.util.Scanner;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
    	ArrayList<String> mapPaths = new ArrayList<String>();
//    	�� �ؽ�Ʈ������ �޾ƿ��� ����
    	mapPaths.add("src/map1.txt");
    	mapPaths.add("src/map2.txt");
    	mapPaths.add("src/map3.txt");
//    	�� �߰�
    	Collections.shuffle(mapPaths);
//    	�� ����
    	int i = 0;
        GameMap gameMap = new GameMap(mapPaths.get(i));
//        ���Ӹ��� ���� �� ù��° ��
        System.out.println("���� �� ������ ����:" + gameMap.getMapSize()[1]+" ����:" + gameMap.getMapSize()[0]);
        Player player = new Player(5,1);
//        �÷��̾� ����

        while (true) {
            gameMap.printMap();
//            �� ���
            gameMap.printPossibleDirection();
            Scanner sc = new Scanner(System.in);
//            �̵����� �Է¹���
            char direction = sc.next().charAt(0);
//            �Է� ù���ڸ� �������� �Է¹���
            int isMove = gameMap.move(direction);
//            �̵��� ��� -1�̸� �Ұ� 0�̸� ���� 1~4�� �������� 5�� ����
            if (isMove == -1) {
//            	�߸��� ��ɾ��� ���
                System.out.println("�ȳ�> �߸��� ��ɾ��Դϴ�. �ٽ� �Է��ϼ���.");
            } else if (isMove >= 1 && isMove <= 4) {
//            	������ ������ ���
            	gameMap.printMap();
                Boss boss = new Boss(5,isMove);
//                ���� ����
                Blackjack blackjack = new Blackjack();
//                ���� ���� ����

                boolean win= blackjack.matchGame(player, boss);
//                �º� ���θ� ��Ÿ���� win
                if (win==false) {
//                	�� ���
                	System.out.println("�ٽ� �����Ͻðڽ��ϱ�? (y/n)");
                	Scanner yn = new Scanner(System.in);
                	char choice = yn.next().charAt(0);
                	if(choice=='y') {
//                		�ٽ� �����ϱ� ���Ұ��
                		i++;
                		if(i>=mapPaths.size()) {
                			i=0;
                		}
                		gameMap = new GameMap(mapPaths.get(i));
                        player = new Player(5,1);
//                      �÷��̾�� ���� �� �����
//                      �÷��̾� ����
                		continue;
                	}
                	return;
//                	�� ��� ���� ����
                }
            } else if (isMove == 5) {
//            	��� ���� óġ �Ϸ�
                System.out.println("�ȳ�> ������ ��� ����ġ�� ������ ���� �Ǿ����ϴ�.");
                return;
            }
        }
    }
}
