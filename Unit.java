package MUD����;
import java.util.ArrayList;

class Unit {
    protected int hp;
//    ü�� ����
    protected int totalHp;
//    �� ü�� ����
    protected int power;
//    ���ݷ� ����
    protected ArrayList<String> cards;
//    ī�带 ��̸���Ʈ�� ����

//    ������
    public Unit(int totalHp, int power) {
        this.totalHp = totalHp;
        this.hp = totalHp;
        this.power = power;
        this.cards = new ArrayList<String>();
    }

    public boolean attacked(boolean isBlackjack, Unit unit) {
//    	���ݹ޴� �Լ�
        if (isBlackjack) {
//        	�����϶�
            System.out.println("����");
            hp -= (unit.power * 2);
//            2��� ���ݹ���
        } else {
            hp -= unit.power;
        }
        if (hp <=0) {
//        	������ �������
            return false;
        }
        return true;
    }

//    hp��ȯ �Լ�
    public int getHp() {
        return hp;
    }
//    ��hp ��ȯ �Լ�
    public int getTotalHp() {
        return totalHp;
    }
//    ī�� ��ȯ �Լ�
    public ArrayList<String> getCards() {
        return cards;
    }
//    ī�� ���ھ� ��� �Լ�
    public int getCardScore() {
        int score = 0;
//      ���� �ʱ�ȭ
        boolean existA=false;
//      A���翩��
        
        for (int i = 0; i < cards.size(); i++) {
//        	����ī�� ����ũ�⵿��
            String cardNumber = cards.get(i).substring(1);
            if (cardNumber.equals("J") || cardNumber.equals("Q") || cardNumber.equals("K")) {
//             ī�尡 J,Q,K�϶�
            	score += 10;
            } else if (cardNumber.equals("A")) {
//            	ī�尡 A�϶�
                score += 11;
                existA = true;
//              A�� ������
                
            } else {
                score += Integer.parseInt(cardNumber);
//                ������ ��ȯ�� ���ھ ������
            }
        }
    	if(existA && score>21) {
//    		A�� �����ϸ鼭 ����Ʈ�ΰ��
    		score -=10;
//    		A�� 1�� ó��
    		
    	}
    	
    		
        return score;
    }

}
// ������ ����ϴ� Player�� Boss Ŭ����
class Player extends Unit{
//	������
    public Player(int totalHp, int power) {
        super(totalHp, power);
    }

//    �� ü���� ������Ű�� �Լ�
    public void addTotalHp(int plusHp) {
        totalHp+=plusHp;
        hp = totalHp;
//       ü�µ� ���� �÷���
    }
}

class Boss extends Unit{
//	������
    public Boss(int totalHp, int power) {
        super(totalHp, power);
    }
}

