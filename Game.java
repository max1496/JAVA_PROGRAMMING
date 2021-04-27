import java.util.Scanner;
// 입력을 받기 위한 스캐너 임포트

public class Game {
//	게임 클래스
	public static void createBuilding() {
//		건물 생산
		System.out.println("1: CommandCenter, 2: SupplyDepot, 3: Barrack 4. 선택안함 을 입력해주세요 ");
		Scanner sc = new Scanner(System.in);
//		스캐너 객체 생성
		int buildingId = sc.nextInt();
//		빌딩아이디를 입력받음
		if(buildingId == 1) {
			System.out.println("건물 건설 조건 확인... 조건이 안되면 초기화면으로 돌아갑니다.");
			CommandCenter commandCenter = new CommandCenter();
			commandCenter.build();
			
		}
		else if(buildingId == 2) {
			System.out.println("건물 건설 조건 확인... 조건이 안되면 초기화면으로 돌아갑니다.");
			if(BuildingInformation.isBuildCommandCenter()) {
			SupplyDepot supplyDepot = new SupplyDepot();
			supplyDepot.build();
			}
		}
		else if(buildingId == 3) {
			System.out.println("건물 건설 조건 확인... 조건이 안되면 초기화면으로 돌아갑니다.");
			if(BuildingInformation.isBuildCommandCenter()) {
			Barrack barrack = new Barrack();
			barrack.build();
			}
		}
//		지정해준 번호에 따라 해당 건물 객체를 만들고 건설
		else if(buildingId == 4) {
			System.out.println("선택하지 않으셨습니다.");
		}
		
		else {
//			1,2,3,4 외의 값이 입력됐을 때
			System.out.println("1,2,3 중에서 입력해 주세요");
		}
	}
	public static void printUnitinfo() {
//		유닛 정보
		SCV scv = new SCV();
		Marine marine = new Marine();
		Firebat firebat = new Firebat();
		Medic medic = new Medic();
//		모든 유닛 객체 생성
		scv.printUnitPopulation();
		marine.printUnitPopulation();
		firebat.printUnitPopulation();
		medic.printUnitPopulation();
//		모든 유닛 개수 출력
		BuildingInformation.printPopulationInfo();
//		총 인구수 정보 출력
		System.out.println("뒤로 돌아갑니다.");
	}
	public static void createUnit() {
//		유닛 생산
		System.out.println("1: SCV, 2: Maribe, 3: Firebat, 4: Medic 5. 선택안함 을 입력해주세요 ");
		Scanner sc = new Scanner(System.in);
//		스캐너 객체 생성
		int unitId = sc.nextInt();
//		유닛 아이디를 입력받음
		if(unitId == 1) {
			SCV scv = new SCV();
//			 해당 유닛 객체 생성
			scv.printUnitInfo();
			System.out.println("1. 유닛을 생성합니다, 2. 유닛을 생성하지 않습니다. 을 선택해 주세요");
//			해당 유닛 정보 출력
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				총 인구수 정보 출력
				CommandCenter commandCenter = new CommandCenter();
//				해당 유닛 생성 건물 객체 생성
				commandCenter.createUnit(UnitId.SCV);
//				건물에서 유닛 생산
				scv.printUnitPopulation();
//				해당 유닛 개수 출력
			}
			if(a==2) {
				return;
			}
		}
		
		else if(unitId == 2) {
			Marine marine = new Marine();
//			 해당 유닛 객체 생성
			marine.printUnitInfo();
//			해당 유닛 정보 출력
			System.out.println("1. 유닛을 생성합니다, 2. 유닛을 생성하지 않습니다. 을 선택해 주세요");
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				총 인구수 정보 출력
				Barrack barrack = new Barrack();
//				해당 유닛 생성 건물 객체 생성
				barrack.createUnit(UnitId.Marine);
//				건물에서 유닛 생산
				marine.printUnitPopulation();
//				해당 유닛 개수 출력
			}
			if(a==2) {
				return;
			}
		}
		else if(unitId == 3) {
			Firebat firebat = new Firebat();
//			 해당 유닛 객체 생성
			firebat.printUnitInfo();
//			해당 유닛 정보 출력
			System.out.println("1. 유닛을 생성합니다, 2. 유닛을 생성하지 않습니다. 을 선택해 주세요");
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				총 인구수 정보 출력
				Barrack barrack = new Barrack();
//				해당 유닛 생성 건물 객체 생성
				barrack.createUnit(UnitId.Firebat);
//				건물에서 유닛 생산
				firebat.printUnitPopulation();
//				해당 유닛 개수 출력
			}
			if(a==2) {
				return;
			}
		}
		else if(unitId == 4) {
			Medic medic = new Medic();
//			 해당 유닛 객체 생성
			medic.printUnitInfo();
//			해당 유닛 정보 출력
			System.out.println("1. 유닛을 생성합니다, 2. 유닛을 생성하지 않습니다. 을 선택해 주세요");
			int a = sc.nextInt();
			if(a==1) {
				BuildingInformation.printPopulationInfo();
//				총 인구수 정보 출력
				Barrack barrack = new Barrack();
//				해당 유닛 생성 건물 객체 생성
				barrack.createUnit(UnitId.Medic);
//				건물에서 유닛 생산
				medic.printUnitPopulation();
//				해당 유닛 개수 출력
			}
			if(a==2) {
				return;
			}
		}
		else if(unitId == 5) {
			System.out.println("선택하지 않으셨습니다.");
		}
		else {
//			1,2,3,4,5번중에 선택이 안되었을 때
			System.out.println("1,2,3,4 중에서 입력해 주세요");
			return;
		}
		BuildingInformation.printPopulationInfo();
//		총 인구수 정보 출력
	}
	public static void deleteUnit(){
//		유닛 삭제
		System.out.println("1: SCV, 2: Maribe, 3: Firebat, 4: Medic 을 입력해주세요 ");
		Scanner sc = new Scanner(System.in);
//		스캐너 객체 생성
		int unitId = sc.nextInt();
//		유닛아이디를 입력받음
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
//		해당 유닛 객체 생성 후 유닛삭제 매소드 실행
		else {
//			1,2,3,4번 중에서 선택이 안되었을 때
			System.out.println("1,2,3,4 중에서 입력해 주세요");
			return;
		}
		BuildingInformation.printPopulationInfo();
	}
	public static void main(String[] args) {
//		메인 함수
		while(true) {
//			프로그램 종료까지 무한루프
			System.out.println("1: 건물 건설, 2: 유닛 조회, 3: 유닛 생성, 4: 유닛 삭제, 0:프로그램 종료");
			Scanner sc = new Scanner(System.in);
//			 스캐너 객체를 입력받음
			int inputId = sc.nextInt();
//			인풋아이디를 입력받음
			if(inputId==1) {
				System.out.println("건물 건설");
				createBuilding();
			}
			else if(inputId==2) {
				System.out.println("유닛 조회");
				printUnitinfo();
			}
			else if(inputId==3) {
				System.out.println("유닛 생성");
				createUnit();
			}
			else if(inputId==4) {
				System.out.println("유닛 삭제");
				deleteUnit();
			}
			else if(inputId==0) {
				System.out.println("프로그램 종료");
				return;
			}
//			해당 번호에 따른 출력문 설정
			else{
//				1,2,3,4,0번중에 선택이 안되었을 경우
				System.out.println("1,2,3,4 중에서 입력해 주세요");
			}
		}
	}
}


