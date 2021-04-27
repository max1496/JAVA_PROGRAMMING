package chap4;
import java.lang.Math;
//매쓰 라이브러리 사용
import java.util.Scanner;
//인풋을 받귀 위한 스캐너

public class ex1 {
	public static double babylonianSqrt(double x) {
//		바빌로니안근을 구하는 함수
		double target = Math.sqrt(x);
//		정확한 수치
		double error = 0.00000001;
//		소수점 8자리까지인 오차
		double prediction = x;
//		X(n+1)=(X(n) + X/X(n))/2 대로 구했을 때의 근사값, 처음엔 x로 둠
		int i =0;
//		빈복횟수
		while(Math.abs(target-prediction)>error) {
			prediction = (prediction+x/prediction)/2;
			i++;
		}
//		오차를 error이하로 줄일 때까지 점화식 진행
		System.out.println("Iteration time: " + i);
//		반복횟수 출력
		return prediction;
//		근사값을 리턴
	}
	
	
	public static void main(String[] args) {
//		메인함수 정의
		double input;
//		입력받을 변수 정의
		Scanner dd = new Scanner(System.in);
//		스캐너 객체를 만듬
		System.out.println("input 입력");
		input =dd.nextDouble();
//		더블형 변수 인풋을 입력받음
		double sqrt = babylonianSqrt(input);
//		근사값을 sqrt변수에 저장
		System.out.println("target: "+Math.sqrt(input) +
				"\nprediction: " + sqrt+ 
				"\nerror: " + (Math.sqrt(input)-sqrt));
//		3개의 결과 출력
	}
}

