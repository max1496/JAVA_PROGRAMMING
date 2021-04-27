
abstract class Building {
//	�߻� Ŭ���� ����

	abstract boolean build();
	abstract boolean isBuild();
	abstract boolean destroy();
//	����� Ŭ�����鿡�� �������� �޼ҵ��
}

enum UnitId {
	SCV,
	Marine,
	Firebat,
	Medic
}
// ���� ������� enum

enum BuildingId{
	CommandCenter,
	SupplyDepot,
	Barrack
}
// �ǹ� ������� enum

class CommandCenter extends Building{
//	������ ��ӹ��� Ŭ����
	public static String BuildingName = "CommandCenter";
//	BuildingName�� �ǹ��̸� ����
	public static int count = 0;
//	�ǹ� ������ ���� count
	
	public boolean isBuild() {
//		�ǹ��� ������ �ֳ� �Ǻ�
		if(count==0) {
//			�ǹ��� ����
			return false;
		}
		return true;
	}
	public boolean build() {
//		�ǹ��� ���� �޼ҵ�
		
		count++;
//		�ǹ� ���� �÷���
		System.out.println(BuildingName+"�� �Ǽ��Ǿ����ϴ�.");
//		���
		return true;
	
	}
	public boolean destroy() {
	if(count==0) {
//		�ǹ��� ����
		System.out.println("�Ǽ��Ǿ� �ִ�"+BuildingName+"��(��) �����ϴ�.");
		return false;
	}
	System.out.println(BuildingName+"��(��) �����߽��ϴ�.");
	count--;
//	�ǹ� ������ �ٿ���
	return true;
	}
	
	public boolean createUnit(UnitId unitId) {
		if(unitId == UnitId.SCV && count>0 &&BuildingInformation.addCurrentPopulation(SCV.POPULATION)) {
//			SCV���� ����
			SCV.count++;
//			scv���� �÷���
			System.out.println(SCV.UNIT_NAME+" ���� ");
			return true;
		} else {
//			������ �������� ���� �� 
			System.out.println("������ ������ �� �����ϴ�.");
			return false;
		}
	}
}

class SupplyDepot extends Building{
//	Building�� ��ӹ��� Ŭ����
	public static String BuildingName = "SupplyDepot";
//	�ǹ��̸�
	public static int count = 0;
//	������ �� ����
	
	public boolean isBuild() {
		if(count==0) {
//			�ǹ��� ���� ��
			return false;
		}
		return true;
	}
	public boolean build() {
//		�ǹ� �Ǽ� �޼ҵ�
		if(BuildingInformation.isBuildCommandCenter()) {
//			Ŀ��弾�Ͱ� ������ ���� �� 
			BuildingInformation.addTotalPopulation(10);
			//�α��� 10����
			count++;
//			�ǹ� ���� ����
			System.out.println(BuildingName+"�� �Ǽ��Ǿ����ϴ�.");
			return true;
		}
		System.out.println(CommandCenter.BuildingName + "��(��) �Ǽ��Ǿ����� �ʾƼ� "+BuildingName+ "�� �Ǽ��� �� �����ϴ�.");
		return false;
	}
	public boolean destroy() {
//		�ǹ� �ı� �޼ҵ�
	if(count==0) {
//		�ǹ��� ���� ��
		System.out.println("�Ǽ��Ǿ� �ִ�"+BuildingName+"��(��) �����ϴ�.");
		return false;
	}
	System.out.println(BuildingName+"��(��) �����߽��ϴ�.");
	BuildingInformation.addTotalPopulation(-10);
	//�α��� 10����
	count--;
	return true;
	}
}

class Barrack extends Building{
//	Building�� ��� ���� Ŭ����
	public static String BuildingName = "Barrack";
//	�ǹ��̸�
	public static int count = 0;
//	�ǹ� ����
	public boolean isBuild() {
		if(count==0) {
//			�ǹ��� ���� ��
			return false;
		}
		return true;
	}
	public boolean build() {
		if(BuildingInformation.isBuildCommandCenter()) {
//			Ŀ�ǵ� ���Ͱ� ������ ���� ��
			count++;
//			�ǹ� ���� ����
			System.out.println(BuildingName+"�� �Ǽ��Ǿ����ϴ�.");
			return true;
		}
		System.out.println(CommandCenter.BuildingName + "��(��) �Ǽ��Ǿ����� �ʾƼ� "+BuildingName+ "�� �Ǽ��� �� �����ϴ�.");
		return false;
	}
	public boolean destroy() {
	if(count==0) {
//		�ǹ��� ���� ��
		System.out.println("�Ǽ��Ǿ� �ִ�"+BuildingName+"��(��) �����ϴ�.");
		return false;
	}
	System.out.println(BuildingName+"��(��) �����߽��ϴ�.");
	count--;
	return true;
	}
	public boolean createUnit(UnitId unitId) {
		if(unitId == UnitId.Marine && count>0 &&BuildingInformation.addCurrentPopulation(Marine.POPULATION)) {
//			���� ���� ����
			Marine.count++;
//			���� ����
			System.out.println(Marine.UNIT_NAME+" ���� ");
			return true;
		}else if(unitId == UnitId.Firebat && count>0 &&BuildingInformation.addCurrentPopulation(Firebat.POPULATION)) {
//			���̾ ���� ����
			Firebat.count++;
//			���̾ ����
			System.out.println(Firebat.UNIT_NAME+" ���� ");
			return true;
		}else if(unitId == UnitId.Medic && count>0 &&BuildingInformation.addCurrentPopulation(Medic.POPULATION)) {
//			�޵� ���� ����
			Medic.count++;
//			�޵� ����
			System.out.println(Medic.UNIT_NAME+" ���� ");
			return true;
		}else {
//			������ �������� ���� ��
			System.out.println("������ ������ �� �����ϴ�.");
			return false;
		}
	}
}



