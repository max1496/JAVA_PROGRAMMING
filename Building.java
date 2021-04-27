
abstract class Building {
//	추상 클래스 생성

	abstract boolean build();
	abstract boolean isBuild();
	abstract boolean destroy();
//	상속할 클래스들에서 재정의할 메소드들
}

enum UnitId {
	SCV,
	Marine,
	Firebat,
	Medic
}
// 유닛 순서대로 enum

enum BuildingId{
	CommandCenter,
	SupplyDepot,
	Barrack
}
// 건물 순서대로 enum

class CommandCenter extends Building{
//	빌딩을 상속받은 클래스
	public static String BuildingName = "CommandCenter";
//	BuildingName에 건물이름 담음
	public static int count = 0;
//	건물 개수를 세는 count
	
	public boolean isBuild() {
//		건물이 지어져 있나 판별
		if(count==0) {
//			건물이 없음
			return false;
		}
		return true;
	}
	public boolean build() {
//		건물을 짓는 메소드
		
		count++;
//		건물 개수 늘려줌
		System.out.println(BuildingName+"가 건설되었습니다.");
//		출력
		return true;
	
	}
	public boolean destroy() {
	if(count==0) {
//		건물이 없음
		System.out.println("건설되어 있는"+BuildingName+"가(이) 없습니다.");
		return false;
	}
	System.out.println(BuildingName+"을(를) 삭제했습니다.");
	count--;
//	건물 개수를 줄여줌
	return true;
	}
	
	public boolean createUnit(UnitId unitId) {
		if(unitId == UnitId.SCV && count>0 &&BuildingInformation.addCurrentPopulation(SCV.POPULATION)) {
//			SCV생성 조건
			SCV.count++;
//			scv개수 늘려줌
			System.out.println(SCV.UNIT_NAME+" 생성 ");
			return true;
		} else {
//			조건을 만족하지 못할 때 
			System.out.println("유닛을 생성할 수 없습니다.");
			return false;
		}
	}
}

class SupplyDepot extends Building{
//	Building을 상속받은 클래스
	public static String BuildingName = "SupplyDepot";
//	건물이름
	public static int count = 0;
//	개수를 셀 변수
	
	public boolean isBuild() {
		if(count==0) {
//			건물이 없을 때
			return false;
		}
		return true;
	}
	public boolean build() {
//		건물 건설 메소드
		if(BuildingInformation.isBuildCommandCenter()) {
//			커멘드센터가 지어져 있을 때 
			BuildingInformation.addTotalPopulation(10);
			//인구수 10증가
			count++;
//			건물 개수 증가
			System.out.println(BuildingName+"가 건설되었습니다.");
			return true;
		}
		System.out.println(CommandCenter.BuildingName + "가(이) 건설되어있지 않아서 "+BuildingName+ "을 건설할 수 없습니다.");
		return false;
	}
	public boolean destroy() {
//		건물 파괴 메소드
	if(count==0) {
//		건물이 없을 때
		System.out.println("건설되어 있는"+BuildingName+"가(이) 없습니다.");
		return false;
	}
	System.out.println(BuildingName+"을(를) 삭제했습니다.");
	BuildingInformation.addTotalPopulation(-10);
	//인구수 10감소
	count--;
	return true;
	}
}

class Barrack extends Building{
//	Building을 상속 받은 클래스
	public static String BuildingName = "Barrack";
//	건물이름
	public static int count = 0;
//	건물 개수
	public boolean isBuild() {
		if(count==0) {
//			건물이 없을 떄
			return false;
		}
		return true;
	}
	public boolean build() {
		if(BuildingInformation.isBuildCommandCenter()) {
//			커맨드 센터가 지어져 있을 때
			count++;
//			건물 개수 증가
			System.out.println(BuildingName+"가 건설되었습니다.");
			return true;
		}
		System.out.println(CommandCenter.BuildingName + "가(이) 건설되어있지 않아서 "+BuildingName+ "을 건설할 수 없습니다.");
		return false;
	}
	public boolean destroy() {
	if(count==0) {
//		건물이 없을 때
		System.out.println("건설되어 있는"+BuildingName+"가(이) 없습니다.");
		return false;
	}
	System.out.println(BuildingName+"을(를) 삭제했습니다.");
	count--;
	return true;
	}
	public boolean createUnit(UnitId unitId) {
		if(unitId == UnitId.Marine && count>0 &&BuildingInformation.addCurrentPopulation(Marine.POPULATION)) {
//			마린 생성 조건
			Marine.count++;
//			마린 생성
			System.out.println(Marine.UNIT_NAME+" 생성 ");
			return true;
		}else if(unitId == UnitId.Firebat && count>0 &&BuildingInformation.addCurrentPopulation(Firebat.POPULATION)) {
//			파이어벳 생성 조건
			Firebat.count++;
//			파이어벳 생성
			System.out.println(Firebat.UNIT_NAME+" 생성 ");
			return true;
		}else if(unitId == UnitId.Medic && count>0 &&BuildingInformation.addCurrentPopulation(Medic.POPULATION)) {
//			메딕 생성 조건
			Medic.count++;
//			메딕 생성
			System.out.println(Medic.UNIT_NAME+" 생성 ");
			return true;
		}else {
//			조건을 만족하지 못할 때
			System.out.println("유닛을 생성할 수 없습니다.");
			return false;
		}
	}
}



