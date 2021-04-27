
public class BuildingInformation {
	public static int currentPopulation=0;
//	현재 유닛수
	public static int totalPopulation=10;
//	전체 유닛수
	public static int maxPopulation=200;
//	최대 유닛 수
	
	
	public static boolean isBuildCommandCenter() {
//		커멘드센터가 지어져 있는지 확인 하는 메소드
		CommandCenter commandCenter = new CommandCenter();
//		커멘드센터 인스턴스 생성
		return commandCenter.isBuild();
	}
	
	public static boolean addTotalPopulation(int number) {
//		생성 가능 인구수 추가 매소드
		totalPopulation +=number;
		if(totalPopulation>maxPopulation) {
//			최대 인구수를 초과했을 떄
			totalPopulation=maxPopulation;
		}
		return true;
	} 
	public static boolean addCurrentPopulation(int number) {
//		인구수 추가 메소드
		currentPopulation +=number;
		if(currentPopulation>totalPopulation) {
//			생성 가능 인구수를 넘어섰을 때
			currentPopulation-=number;
			return false;
		}
		return true;
	} 
	public static void printPopulationInfo() {
//		인구수 정보 출력 메소드
		System.out.println("사용 인구수"+ currentPopulation + " / " + totalPopulation);
	}
}
