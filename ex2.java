package chap4;
import java.util.Scanner;
//인풋을 받기 위한 스캐너

public class ex2 {
//	재귀
	public int fastPower(int x, int n) {
		int power = 1;
//		탈출 조건
		if (n==1) {
			return x;
		}
		else if(n==0) {
			return 1;
		}
//		n이 짝수인 경우
		if (n%2==0) {
			int result = fastPower(x, n/2);
			power = result*result;
		}
//		n이 홀수인 경우
		else if (n%2==1) {
			int result = fastPower(x, (n-1)/2);
			power = result*result*x;
		}
		return power;
//		결과를 리턴
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		스캐너 클래스의 객체 선언
		ex2 f = new ex2();
//		ex2 클래스의 객체 선언
		System.out.println("input x");
		int x=scan.nextInt();
		System.out.println("input n");
		int n=scan.nextInt();
//		두 정수를 입력 받음
		int power = f.fastPower(x, n);
//		리턴된 결과값을 저장
		System.out.println(power);
//		출력
	}

}
