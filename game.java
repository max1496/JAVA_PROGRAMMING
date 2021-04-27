package MUD게임;
import java.util.Scanner;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
    	ArrayList<String> mapPaths = new ArrayList<String>();
//    	맵 텍스트파일을 받아오는 변수
    	mapPaths.add("src/map1.txt");
    	mapPaths.add("src/map2.txt");
    	mapPaths.add("src/map3.txt");
//    	맵 추가
    	Collections.shuffle(mapPaths);
//    	맵 셔플
    	int i = 0;
        GameMap gameMap = new GameMap(mapPaths.get(i));
//        게임맵은 셔플 후 첫번째 맵
        System.out.println("게임 맵 사이즈 가로:" + gameMap.getMapSize()[1]+" 세로:" + gameMap.getMapSize()[0]);
        Player player = new Player(5,1);
//        플레이어 생성

        while (true) {
            gameMap.printMap();
//            맵 출력
            gameMap.printPossibleDirection();
            Scanner sc = new Scanner(System.in);
//            이동방향 입력받음
            char direction = sc.next().charAt(0);
//            입력 첫글자를 방향으로 입력받음
            int isMove = gameMap.move(direction);
//            이동한 결과 -1이면 불가 0이면 가능 1~4는 보스만남 5는 보물
            if (isMove == -1) {
//            	잘못된 명령어일 경우
                System.out.println("안내> 잘못된 명령어입니다. 다시 입력하세요.");
            } else if (isMove >= 1 && isMove <= 4) {
//            	보스를 만났을 경우
            	gameMap.printMap();
                Boss boss = new Boss(5,isMove);
//                보스 생성
                Blackjack blackjack = new Blackjack();
//                블랙잭 게임 시작

                boolean win= blackjack.matchGame(player, boss);
//                승부 여부를 나타내는 win
                if (win==false) {
//                	진 경우
                	System.out.println("다시 시작하시겠습니까? (y/n)");
                	Scanner yn = new Scanner(System.in);
                	char choice = yn.next().charAt(0);
                	if(choice=='y') {
//                		다시 시작하길 원할경우
                		i++;
                		if(i>=mapPaths.size()) {
                			i=0;
                		}
                		gameMap = new GameMap(mapPaths.get(i));
                        player = new Player(5,1);
//                      플레이어와 게임 맵 재생성
//                      플레이어 생성
                		continue;
                	}
                	return;
//                	진 경우 게임 오버
                }
            } else if (isMove == 5) {
//            	모든 보스 처치 완료
                System.out.println("안내> 보스를 모두 물리치고 게임이 종료 되었습니다.");
                return;
            }
        }
    }
}
