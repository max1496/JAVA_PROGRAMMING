
public class BuildingInformation {
	public static int currentPopulation=0;
//	���� ���ּ�
	public static int totalPopulation=10;
//	��ü ���ּ�
	public static int maxPopulation=200;
//	�ִ� ���� ��
	
	
	public static boolean isBuildCommandCenter() {
//		Ŀ��弾�Ͱ� ������ �ִ��� Ȯ�� �ϴ� �޼ҵ�
		CommandCenter commandCenter = new CommandCenter();
//		Ŀ��弾�� �ν��Ͻ� ����
		return commandCenter.isBuild();
	}
	
	public static boolean addTotalPopulation(int number) {
//		���� ���� �α��� �߰� �żҵ�
		totalPopulation +=number;
		if(totalPopulation>maxPopulation) {
//			�ִ� �α����� �ʰ����� ��
			totalPopulation=maxPopulation;
		}
		return true;
	} 
	public static boolean addCurrentPopulation(int number) {
//		�α��� �߰� �޼ҵ�
		currentPopulation +=number;
		if(currentPopulation>totalPopulation) {
//			���� ���� �α����� �Ѿ�� ��
			currentPopulation-=number;
			return false;
		}
		return true;
	} 
	public static void printPopulationInfo() {
//		�α��� ���� ��� �޼ҵ�
		System.out.println("��� �α���"+ currentPopulation + " / " + totalPopulation);
	}
}
