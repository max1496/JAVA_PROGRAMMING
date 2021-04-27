
abstract class Unit {
//	�߻� Ŭ���� ����
	abstract boolean killUnit();
	abstract void printUnitInfo();
	abstract void printUnitPopulation();
//	��ӵ� Ŭ�����鿡�� �����ǵ� �޼ҵ��
}

class SCV extends Unit{
//	������ ��ӹ��� Ŭ����
	public static final String UNIT_NAME = "SCV";
	public static final int HP = 60;
	public static final int POWER = 5;
	public static final int DEFENSE = 0;
	public static final int POPULATION = 1;
//	scv������
	public static int count = 0;
//	������ ���� ī��Ʈ
	public boolean killUnit() {
//		���� ���� �޼ҵ�
		if(count == 0) {
//			scv�� ���� ��
			System.out.println("������"+UNIT_NAME+"��(��) ������ �����ϴ�.");
			return false;
		}
		count--;
//		scv ���� �ٿ���
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		�α��� �ٿ��ֱ�
		System.out.println(UNIT_NAME+"��(��) �׾����ϴ�.");
//		���
		return true;
	}
	public void printUnitInfo() {
//		scv ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		scv ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+"��"+ count);
	}
}


class Marine extends Unit{
//	������ ��ӹ��� Ŭ����
	public static final String UNIT_NAME = "Marine";
	public static final int HP = 40;
	public static final int POWER = 6;
	public static final int DEFENSE = 0;
	public static final int POPULATION = 1;
//	���� ����
	public static int count = 0;
//	���� ����
	public boolean killUnit() {
//		���� ���� �޼ҵ�
		if(count == 0) {
//			������ ���� ��
			System.out.println("������"+UNIT_NAME+"��(��) ������ �����ϴ�.");
			return false;
		}
		count--;
//		���� ���� �ٿ���
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		������ �α��� ��ŭ �α����� �ٿ���
		System.out.println(UNIT_NAME+"��(��) �׾����ϴ�.");
		return true;
	}
	public void printUnitInfo() {
//		���� ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		���� ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+"��"+ count);
	}
}

class Firebat extends Unit{
//	������ ��� ���� Ŭ����
	public static final String UNIT_NAME = "Firebat";
	public static final int HP = 50;
	public static final int POWER = 8;
	public static final int DEFENSE = 1;
	public static final int POPULATION = 1;
//	���̾ ����
	public static int count = 0;
//	���̾ ����
	public boolean killUnit() {
//		���� ���� �޼ҵ�
		if(count == 0) {
//			���̾�� ���� ��
			System.out.println("������"+UNIT_NAME+"��(��) ������ �����ϴ�.");
			return false;
		}
		count--;
//		���̾ ���� �ٿ���
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		���̾ �α��� ��ŭ  �α��� �ٿ���
		System.out.println(UNIT_NAME+"��(��) �׾����ϴ�.");
		return true;
	}
	public void printUnitInfo() {
//		���̾ ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		���̾ ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+"��"+ count);
	}
}

class Medic extends Unit{
//	������ ��� ���� Ŭ����
	public static final String UNIT_NAME = "Medic";
	public static final int HP = 60;
	public static final int POWER = 0;
	public static final int DEFENSE = 1;
	public static final int POPULATION = 1;
//	�޵� ����
	public static int count = 0;
//	�޵� ����
	public boolean killUnit() {
//		���� ���� �޼ҵ�
		if(count == 0) {
//			�޵��� ���� ��
			System.out.println("������"+UNIT_NAME+"��(��) ������ �����ϴ�.");
			return false;
		}
		count--;
//		�޵� ���� �ٿ���
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		�޵� �α��� ��ŭ �ٿ���
		System.out.println(UNIT_NAME+"��(��) �׾����ϴ�.");
		return true;
	}
	public void printUnitInfo() {
//		�޵� ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		�޵� ���� ���� ��� �޼ҵ�
		System.out.println(UNIT_NAME+"��"+ count);
	}
}