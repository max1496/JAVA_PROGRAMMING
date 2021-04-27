import java.util.Scanner;
// �Է��� �ޱ� ���� ��ĳ�� ����Ʈ

public class Game {
//	���� Ŭ����
	public static void createBuilding() {
//		�ǹ� ����
		System.out.println("1: CommandCenter, 2: SupplyDepot, 3: Barrack 4. ���þ��� �� �Է����ּ��� ");
		Scanner sc = new Scanner(System.in);
//		��ĳ�� ��ü ����
		int buildingId = sc.nextInt();
//		�������̵� �Է¹���
		if(buildingId == 1) {
			System.out.println("�ǹ� �Ǽ� ���� Ȯ��... ������ �ȵǸ� �ʱ�ȭ������ ���ư��ϴ�.");
			CommandCenter commandCenter = new CommandCenter();
			commandCenter.build();
			
		}
		else if(buildingId == 2) {
			System.out.println("�ǹ� �Ǽ� ���� Ȯ��... ������ �ȵǸ� �ʱ�ȭ������ ���ư��ϴ�.");
			if(BuildingInformation.isBuildCommandCenter()) {
			SupplyDepot supplyDepot = new SupplyDepot();
			supplyDepot.build();
			}
		}
		else if(buildingId == 3) {
			System.out.println("�ǹ� �Ǽ� ���� Ȯ��... ������ �ȵǸ� �ʱ�ȭ������ ���ư��ϴ�.");
			if(BuildingInformation.isBuildCommandCenter()) {
			Barrack barrack = new Barrack();
			barrack.build();
			}
		}
//		�������� ��ȣ�� ���� �ش� �ǹ� ��ü�� ����� �Ǽ�
		else if(buildingId == 4) {
			System.out.println("�������� �����̽��ϴ�.");
		}
		
		else {
//			1,2,3,4 ���� ���� �Էµ��� ��
			System.out.println("1,2,3 �߿��� �Է��� �ּ���");
		}
	}
	public static void printUnitinfo() {
//		���� ����
		SCV scv = new SCV();
		Marine marine = new Marine();
		Firebat firebat = new Firebat();
		Medic medic = new Medic();
//		��� ���� ��ü ����
		scv.printUnitPopulation();
		marine.printUnitPopulation();
		firebat.printUnitPopulation();
		medic.printUnitPopulation();
//		��� ���� ���� ���
		BuildingInformation.printPopulationInfo();
//		�� �α��� ���� ���
		System.out.println("�ڷ� ���ư��ϴ�.");
	}
	public static void createUnit() {
//		���� ����
		System.out.println("1: SCV, 2: Maribe, 3: Firebat, 4: Medic 5. ���þ��� �� �Է����ּ��� ");
		Scanner sc = new Scanner(System.in);
//		��ĳ�� ��ü ����
		int unitId = sc.nextInt();
//		���� ���̵� �Է¹���
		if(unitId == 1) {
			SCV scv = new SCV();
//			 �ش� ���� ��ü ����
			scv.printUnitInfo();
			System.out.println("1. ������ �����մϴ�, 2. ������ �������� �ʽ��ϴ�. �� ������ �ּ���");
//			�ش� ���� ���� ���
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				�� �α��� ���� ���
				CommandCenter commandCenter = new CommandCenter();
//				�ش� ���� ���� �ǹ� ��ü ����
				commandCenter.createUnit(UnitId.SCV);
//				�ǹ����� ���� ����
				scv.printUnitPopulation();
//				�ش� ���� ���� ���
			}
			if(a==2) {
				return;
			}
		}
		
		else if(unitId == 2) {
			Marine marine = new Marine();
//			 �ش� ���� ��ü ����
			marine.printUnitInfo();
//			�ش� ���� ���� ���
			System.out.println("1. ������ �����մϴ�, 2. ������ �������� �ʽ��ϴ�. �� ������ �ּ���");
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				�� �α��� ���� ���
				Barrack barrack = new Barrack();
//				�ش� ���� ���� �ǹ� ��ü ����
				barrack.createUnit(UnitId.Marine);
//				�ǹ����� ���� ����
				marine.printUnitPopulation();
//				�ش� ���� ���� ���
			}
			if(a==2) {
				return;
			}
		}
		else if(unitId == 3) {
			Firebat firebat = new Firebat();
//			 �ش� ���� ��ü ����
			firebat.printUnitInfo();
//			�ش� ���� ���� ���
			System.out.println("1. ������ �����մϴ�, 2. ������ �������� �ʽ��ϴ�. �� ������ �ּ���");
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				�� �α��� ���� ���
				Barrack barrack = new Barrack();
//				�ش� ���� ���� �ǹ� ��ü ����
				barrack.createUnit(UnitId.Firebat);
//				�ǹ����� ���� ����
				firebat.printUnitPopulation();
//				�ش� ���� ���� ���
			}
			if(a==2) {
				return;
			}
		}
		else if(unitId == 4) {
			Medic medic = new Medic();
//			 �ش� ���� ��ü ����
			medic.printUnitInfo();
//			�ش� ���� ���� ���
			System.out.println("1. ������ �����մϴ�, 2. ������ �������� �ʽ��ϴ�. �� ������ �ּ���");
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				�� �α��� ���� ���
				Barrack barrack = new Barrack();
//				�ش� ���� ���� �ǹ� ��ü ����
				barrack.createUnit(UnitId.Medic);
//				�ǹ����� ���� ����
				medic.printUnitPopulation();
//				�ش� ���� ���� ���
			}
			if(a==2) {
				return;
			}
		}
		else if(unitId == 5) {
			System.out.println("�������� �����̽��ϴ�.");
		}
		else {
//			1,2,3,4,5���߿� ������ �ȵǾ��� ��
			System.out.println("1,2,3,4 �߿��� �Է��� �ּ���");
			return;
		}
		BuildingInformation.printPopulationInfo();
//		�� �α��� ���� ���
	}
	public static void deleteUnit(){
//		���� ����
		System.out.println("1: SCV, 2: Maribe, 3: Firebat, 4: Medic �� �Է����ּ��� ");
		Scanner sc = new Scanner(System.in);
//		��ĳ�� ��ü ����
		int unitId = sc.nextInt();
//		���־��̵� �Է¹���
		if(unitId == 1) {
			SCV scv = new SCV();
			scv.killUnit();
		}
		
		else if(unitId == 2) {
			Marine marine = new Marine();
			marine.killUnit();
		}
		else if(unitId == 3) {
			Firebat firebat = new Firebat();
			firebat.killUnit();
		}
		else if(unitId == 4) {
			Medic medic = new Medic();
			medic.killUnit();
		}
//		�ش� ���� ��ü ���� �� ���ֻ��� �żҵ� ����
		else {
//			1,2,3,4�� �߿��� ������ �ȵǾ��� ��
			System.out.println("1,2,3,4 �߿��� �Է��� �ּ���");
			return;
		}
		BuildingInformation.printPopulationInfo();
	}
	public static void main(String[] args) {
//		���� �Լ�
		while(true) {
//			���α׷� ������� ���ѷ���
			System.out.println("1: �ǹ� �Ǽ�, 2: ���� ��ȸ, 3: ���� ����, 4: ���� ����, 0:���α׷� ����");
			Scanner sc = new Scanner(System.in);
//			 ��ĳ�� ��ü�� �Է¹���
			int inputId = sc.nextInt();
//			��ǲ���̵� �Է¹���
			if(inputId==1) {
				System.out.println("�ǹ� �Ǽ�");
				createBuilding();
			}
			else if(inputId==2) {
				System.out.println("���� ��ȸ");
				printUnitinfo();
			}
			else if(inputId==3) {
				System.out.println("���� ����");
				createUnit();
			}
			else if(inputId==4) {
				System.out.println("���� ����");
				deleteUnit();
			}
			else if(inputId==0) {
				System.out.println("���α׷� ����");
				return;
			}
//			�ش� ��ȣ�� ���� ��¹� ����
			else{
//				1,2,3,4,0���߿� ������ �ȵǾ��� ���
				System.out.println("1,2,3,4 �߿��� �Է��� �ּ���");
			}
		}
	}
}


