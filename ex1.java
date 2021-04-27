package chap4;
import java.lang.Math;
//�ž� ���̺귯�� ���
import java.util.Scanner;
//��ǲ�� �ޱ� ���� ��ĳ��

public class ex1 {
	public static double babylonianSqrt(double x) {
//		�ٺ��δϾȱ��� ���ϴ� �Լ�
		double target = Math.sqrt(x);
//		��Ȯ�� ��ġ
		double error = 0.00000001;
//		�Ҽ��� 8�ڸ������� ����
		double prediction = x;
//		X(n+1)=(X(n) + X/X(n))/2 ��� ������ ���� �ٻ簪, ó���� x�� ��
		int i =0;
//		��Ƚ��
		while(Math.abs(target-prediction)>error) {
			prediction = (prediction+x/prediction)/2;
			i++;
		}
//		������ error���Ϸ� ���� ������ ��ȭ�� ����
		System.out.println("Iteration time: " + i);
//		�ݺ�Ƚ�� ���
		return prediction;
//		�ٻ簪�� ����
	}
	
	
	public static void main(String[] args) {
//		�����Լ� ����
		double input;
//		�Է¹��� ���� ����
		Scanner dd = new Scanner(System.in);
//		��ĳ�� ��ü�� ����
		System.out.println("input �Է�");
		input =dd.nextDouble();
//		������ ���� ��ǲ�� �Է¹���
		double sqrt = babylonianSqrt(input);
//		�ٻ簪�� sqrt������ ����
		System.out.println("target: "+Math.sqrt(input) +
				"\nprediction: " + sqrt+ 
				"\nerror: " + (Math.sqrt(input)-sqrt));
//		3���� ��� ���
	}
}

