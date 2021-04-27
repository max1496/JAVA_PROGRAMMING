package MUD게임;
import java.util.ArrayList;

class Unit {
    protected int hp;
//    체력 변수
    protected int totalHp;
//    총 체력 변수
    protected int power;
//    공격력 변수
    protected ArrayList<String> cards;
//    카드를 어레이리스트로 구현

//    생성자
    public Unit(int totalHp, int power) {
        this.totalHp = totalHp;
        this.hp = totalHp;
        this.power = power;
        this.cards = new ArrayList<String>();
    }

    public boolean attacked(boolean isBlackjack, Unit unit) {
//    	공격받는 함수
        if (isBlackjack) {
//        	블랙잭일때
            System.out.println("블랙잭");
            hp -= (unit.power * 2);
//            2배로 공격받음
        } else {
            hp -= unit.power;
        }
        if (hp <=0) {
//        	게임이 끝난경우
            return false;
        }
        return true;
    }

//    hp반환 함수
    public int getHp() {
        return hp;
    }
//    총hp 반환 함수
    public int getTotalHp() {
        return totalHp;
    }
//    카드 반환 함수
    public ArrayList<String> getCards() {
        return cards;
    }
//    카드 스코어 계산 함수
    public int getCardScore() {
        int score = 0;
//      점수 초기화
        boolean existA=false;
//      A존재여부
        
        for (int i = 0; i < cards.size(); i++) {
//        	가진카드 개수크기동안
            String cardNumber = cards.get(i).substring(1);
            if (cardNumber.equals("J") || cardNumber.equals("Q") || cardNumber.equals("K")) {
//             카드가 J,Q,K일때
            	score += 10;
            } else if (cardNumber.equals("A")) {
//            	카드가 A일때
                score += 11;
                existA = true;
//              A가 존재함
                
            } else {
                score += Integer.parseInt(cardNumber);
//                정수로 변환후 스코어에 더해줌
            }
        }
    	if(existA && score>21) {
//    		A가 존재하면서 버스트인경우
    		score -=10;
//    		A를 1로 처리
    		
    	}
    	
    		
        return score;
    }

}
// 유닛을 상속하는 Player와 Boss 클래스
class Player extends Unit{
//	생성자
    public Player(int totalHp, int power) {
        super(totalHp, power);
    }

//    총 체력을 증가시키는 함수
    public void addTotalHp(int plusHp) {
        totalHp+=plusHp;
        hp = totalHp;
//       체력도 같이 늘려줌
    }
}

class Boss extends Unit{
//	생성자
    public Boss(int totalHp, int power) {
        super(totalHp, power);
    }
}

