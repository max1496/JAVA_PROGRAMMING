package MUD게임;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
    private int index;
//    순서 인덱스
    private ArrayList<String> deck;
//    카드 덱을 어레이 리스트로 구현

    public Blackjack() {
        index = 0;
//        초기화
        deck = new ArrayList<String>();
//        초기화
        String[] cardType = {"s", "c","h","d"};
        String[] cardNumber = {"A", "2","3", "4", "5","6","7","8","9", "10", "J","Q","K"};
        for (int i = 0; i < 4; i++) {
//        	4가지 카드타입동안
            for (int j = 0; j <13; j++) {
//            	13개의 카드 넘버종류동안
                String card = cardType[i] + cardNumber[j];
//                카드 정의
                deck.add(card);
//                카드를 덱에 넣어줌
            }
        }
//        덱 셔플
        Collections.shuffle(deck);
    }
//    카드 고르는 함수
    public String pick() {
        return deck.get(index++);
    }


    public void printCard(boolean blind, Unit unit) {
        if (blind == true) {
//        	보스의 카드 공개
            for (int i = 0; i < unit.getCards().size(); i++) {
//            	카드 사이즈크기 동안
                if (i == 0) {
//                	첫번째 카드면
                    System.out.print(unit.getCards().get(i));
                } else {
                    System.out.print("/?");
//                    blind라 물음표 출력
                }
            }
        } else {
            for (int i = 0; i < unit.getCards().size(); i++) {
//            	카드 사이즈크기 동안
                if (i == 0) {
//                	첫번째 카드면
                    System.out.print(unit.getCards().get(i));
                } else {
                    System.out.print("/" + unit.getCards().get(i));
                }
            }
        }

    }
    public void printGameStatus(boolean blind, Player player, Boss boss) {
//    	유닛 상태 출력함수
        System.out.print("안내 > 보스 : ");
        printCard(blind, boss);
//        보스 카드 출력
        System.out.print("  |  플레이어 : ");
        printCard(false, player);
//        플레이어 카드 출력
        System.out.println();
    }

    public int playBossTurn(Boss boss) {
        while(true) {
//            보스 카드 점수가 16보다 같거나 작으면 한장 뽑아라
            if (boss.getCardScore() <= 16) {
                boss.getCards().add(pick());
            } else {
                return boss.getCardScore();
//                아니면 카드스코어 공개
            }
        }
    }

    public boolean playBlackjack(Player player, Boss boss) {
//    	블랙잭 플레이 함수
//       2장씩 카드 뽑기
        player.getCards().add(pick());
        player.getCards().add(pick());
        boss.getCards().add(pick());
        boss.getCards().add(pick());
        System.out.println("안내 > 플레이어 ("+ player.getHp() + "/" +player.getTotalHp() + ")    / 보스 (" + boss.getHp() +"/" +  boss.getTotalHp() + ")");
//안내 출력
        while(true) {
//        	계속 반복
            printGameStatus(true, player, boss);
//            게임 상태 출력
            Scanner sc = new Scanner(System.in);
//            입력받음
            char rule = sc.next().charAt(0);
//            첫글자만 따서 룰에 저장
            if (rule == 'h') {
//            	히트일때
                player.getCards().add(pick());
//                카드를 뽑음
                if (player.getCardScore() > 21) {
//                	버스트일 때
                    break;
//                    빠져나옴
                }
            } else if (rule == 's') {
//            	스탠드일떄
                playBossTurn(boss);
//                보스턴 진행
                break;
//                반복문 빠져나옴
            } else {
                System.out.println("안내> 잘못된 명령어입니다. 다시 입력하세요.");
            }
        }
        printGameStatus(false, player, boss);
//        보스의 카드를 가리지 않은채 게임 상태 출력하는 함수
        if (player.getCardScore() > 21) {
//        	버스트일 떄
            System.out.println("안내 > 보스: " + boss.getCardScore() + " | 플레이어 : " + player.getCardScore() + "(버스트)");
            return false;
        } else if (player.getCardScore() == 21) {
//        	블랙잭일때
            System.out.println("안내 > 보스: " + boss.getCardScore() + " | 플레이어 : " + player.getCardScore() + "(블랙잭)");
            return true;
        } else if (boss.getCardScore() > 21) {
//        	보스가 버스트 했을때
            System.out.println("안내 > 보스: " + boss.getCardScore() + " (버스트)" + " | 플레이어 : " + player.getCardScore() + "(블랙잭)");
            return true;
        } else if (boss.getCardScore() == 21) {
//        	보스가 블랙잭일 때
            System.out.println("안내 > 보스: " + boss.getCardScore() + " (블랙잭)" + " | 플레이어 : " + player.getCardScore() + "(블랙잭)");
            return false;
        } else if (player.getCardScore() >= boss.getCardScore()) {
//        	플레이어의 스코어가 더 높을때
            System.out.println("안내 > 보스: " + boss.getCardScore() + " | 플레이어 : " + player.getCardScore());
            return true;
        } else {
            System.out.println("안내 > 보스: " + boss.getCardScore() + " | 플레이어 : " + player.getCardScore());
            return false;
        }
    }

    public boolean whoseWin(boolean win, Player player, Boss boss) {
//    	누가 이겼는지 판별하는 함수
        boolean alive;
//        보스나 플레이어가 살아있다는 변수
        if (win) {
//        	플레이어가 이겼을떄
            System.out.print("안내 > 플레이어 승리 | ");
            if (player.getCardScore() == 21) {
//            	플레이어가 블랙잭일때
            	alive = boss.attacked(true, player);
//            	보스가 2배의 공격력으로 공격받음
            } else {
            	alive = boss.attacked(false, player);
//            	보스가 공격받음
            }
        } else {
            System.out.print("안내 > 보스 승리 | ");
            if (boss.getCardScore() == 21) {
//            	보스가 블랙잭일때
            	alive= player.attacked(true, boss);
//            	플레이어가 2배의 공격력으로 공격받음
            } else {
            	alive = player.attacked(false, boss);
//            	플레이어가 공격받음
            }
        }
        System.out.println("플레이어 ("+ player.getHp() + "/" +player.getTotalHp() + ")    / 보스 (" + boss.getHp() +"/" +  boss.getTotalHp() + ")");
        return alive;
    }

    public boolean matchGame(Player player, Boss boss) {
        while(true) {
//        	계속 실행
            boolean win = playBlackjack(player, boss);
//            블랙잭을 플레이하고 결과를 win에 저장
           

            boolean alive = whoseWin(win, player, boss);
//            이겼는지 결과 저장
            player.getCards().clear();
            boss.getCards().clear();
//          유닛들 카드 초기화      
            if (alive == false) {
                if (win) {
//                	보스를 물리친 경우
                    System.out.println("안내> 보스를 물리쳤습니다.");
                    player.addTotalHp(2);
//                    플레이어 체력 증가
                    return win;
                } else {
//                	플레이어가 진 경우
                    System.out.println("안내> Game Over");
                    return win;
                }
            }
        }
    }
}
