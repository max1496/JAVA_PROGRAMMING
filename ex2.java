package chap4;
import java.util.Scanner;
//��ǲ�� �ޱ� ���� ��ĳ��

public class ex2 {
//	���
	public int fastPower(int x, int n) {
		int power = 1;
//		Ż�� ����
		if (n==1) {
			return x;
		}
		else if(n==0) {
			return 1;
		}
//		n�� ¦���� ���
		if (n%2==0) {
			int result = fastPower(x, n/2);
			power = result*result;
		}
//		n�� Ȧ���� ���
		else if (n%2==1) {
			int result = fastPower(x, (n-1)/2);
			power = result*result*x;
		}
		return power;
//		����� ����
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		��ĳ�� Ŭ������ ��ü ����
		ex2 f = new ex2();
//		ex2 Ŭ������ ��ü ����
		System.out.println("input x");
		int x=scan.nextInt();
		System.out.println("input n");
		int n=scan.nextInt();
//		�� ������ �Է� ����
		int power = f.fastPower(x, n);
//		���ϵ� ������� ����
		System.out.println(power);
//		���
	}

}
