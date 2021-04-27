
abstract class Unit {
//	추상 클래스 생성
	abstract boolean killUnit();
	abstract void printUnitInfo();
	abstract void printUnitPopulation();
//	상속될 클래스들에서 재정의될 메소드들
}

class SCV extends Unit{
//	유닛을 상속받은 클래스
	public static final String UNIT_NAME = "SCV";
	public static final int HP = 60;
	public static final int POWER = 5;
	public static final int DEFENSE = 0;
	public static final int POPULATION = 1;
//	scv정보들
	public static int count = 0;
//	개수를 세는 카운트
	public boolean killUnit() {
//		유닛 제거 메소드
		if(count == 0) {
//			scv가 없을 때
			System.out.println("삭제할"+UNIT_NAME+"가(이) 유닛이 없습니다.");
			return false;
		}
		count--;
//		scv 개수 줄여줌
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		인구수 줄여주기
		System.out.println(UNIT_NAME+"가(이) 죽었습니다.");
//		출력
		return true;
	}
	public void printUnitInfo() {
//		scv 정보 출력 메소드
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		scv 개수 출력 메소드
		System.out.println(UNIT_NAME+"총"+ count);
	}
}


class Marine extends Unit{
//	유닛을 상속받은 클래스
	public static final String UNIT_NAME = "Marine";
	public static final int HP = 40;
	public static final int POWER = 6;
	public static final int DEFENSE = 0;
	public static final int POPULATION = 1;
//	마린 정보
	public static int count = 0;
//	마린 개수
	public boolean killUnit() {
//		유닛 삭제 메소드
		if(count == 0) {
//			마린이 없을 때
			System.out.println("삭제할"+UNIT_NAME+"가(이) 유닛이 없습니다.");
			return false;
		}
		count--;
//		마린 개수 줄여줌
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		유닛의 인구수 만큼 인구수를 줄여줌
		System.out.println(UNIT_NAME+"가(이) 죽었습니다.");
		return true;
	}
	public void printUnitInfo() {
//		마린 정보 출력 메소드
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		마린 개수 출력 메소드
		System.out.println(UNIT_NAME+"총"+ count);
	}
}

class Firebat extends Unit{
//	유닛을 상속 받은 클래스
	public static final String UNIT_NAME = "Firebat";
	public static final int HP = 50;
	public static final int POWER = 8;
	public static final int DEFENSE = 1;
	public static final int POPULATION = 1;
//	파이어벳 정보
	public static int count = 0;
//	파이어벳 개수
	public boolean killUnit() {
//		유닛 삭제 메소드
		if(count == 0) {
//			파이어벳이 없을 때
			System.out.println("삭제할"+UNIT_NAME+"가(이) 유닛이 없습니다.");
			return false;
		}
		count--;
//		파이어벳 개수 줄여줌
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		파이어벳 인구수 만큼  인구수 줄여줌
		System.out.println(UNIT_NAME+"가(이) 죽었습니다.");
		return true;
	}
	public void printUnitInfo() {
//		파이어벳 정보 출력 메소드
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		파이어벳 개수 출력 메소드
		System.out.println(UNIT_NAME+"총"+ count);
	}
}

class Medic extends Unit{
//	유닛을 상속 받은 클래스
	public static final String UNIT_NAME = "Medic";
	public static final int HP = 60;
	public static final int POWER = 0;
	public static final int DEFENSE = 1;
	public static final int POPULATION = 1;
//	메딕 정보
	public static int count = 0;
//	메딕 개수
	public boolean killUnit() {
//		유닉 삭제 메소드
		if(count == 0) {
//			메딕이 없을 때
			System.out.println("삭제할"+UNIT_NAME+"가(이) 유닛이 없습니다.");
			return false;
		}
		count--;
//		메딕 개수 줄여줌
		BuildingInformation.addCurrentPopulation(-POPULATION);
//		메딕 인구수 만큼 줄여줌
		System.out.println(UNIT_NAME+"가(이) 죽었습니다.");
		return true;
	}
	public void printUnitInfo() {
//		메딕 정보 출력 메소드
		System.out.println(UNIT_NAME+" Info HP" + HP + " POWER" + POWER + " DEFENSE"+ DEFENSE + " POPULATION" + POPULATION);
	}
	public void printUnitPopulation() {
//		메딕 개수 정보 출력 메소드
		System.out.println(UNIT_NAME+"총"+ count);
	}
}