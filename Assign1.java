package assign;
import assign.Anagram;

import java.util.Scanner;
// Anagram.java�� ����Ʈ ��Ŵ
public class Assign1 {
	public static void main(String[] args) {
//		�����Լ�
		Anagram a = new Anagram();
//		Anagram ��ü ����
		int trueAnagram = 0;
		int falseAnagram = 0;
		String[] wordsA = new String[1000];
		String[] wordsB = new String[1000];
//		anagram �񱳵� �� ������ �迭�� ����
		boolean[] isAnagrams=new boolean[1000];
		int i = 0;
		while(true) {
//			quit�Է½ñ��� �����ϴ� �ݺ���
			System.out.println("�ܾ �ΰ� �Է����ּ���. quit�� �Է½� ���α׷� ����");
			Scanner scan = new Scanner(System.in);
			wordsA[i]=scan.next();
//			wordsA�� ���� �Է¹���
			if(wordsA[i].equals("quit")) {
//			quit�� �ԷµǸ� break
				i--;
//				�迭�� �þ�� ���� �ٽ� �ٿ���
				System.out.println("Anagram�� ���");
				for(int j=0;j<=i;j++) {
					if(isAnagrams[j]) {
						System.out.println(wordsA[j]+ " " + wordsB[j]);
					}
				}
				System.out.println("Anagram���� �ƴ� ���");
				for(int j=0;j<=i;j++) {
					if(isAnagrams[j]==false) {
						System.out.println(wordsA[j]+ " " + wordsB[j]);
					}
				}
//				anagram���� �ų� �ƴ� ���� ���
				System.out.println("Anagram�� ����: "+ trueAnagram+ " Anagram�� �ƴ� ����: "+ falseAnagram);
				System.out.println("quit�Է����� ���α׷� ����");
				break;
//				trueAnagram�� falseAnagram������ ����ؼ� anagram�̰ų� �ƴ� �ֵ��� ���� ���
			}
			wordsB[i]=scan.next();
//			wordsB�� �Է¹���
			isAnagrams[i] = a.anagram(wordsA[i], wordsB[i]);
//			wordsA�� anagram���� �Ǻ��ؼ� isAnagrams�迭�� ����
			if(isAnagrams[i]) {
				trueAnagram++;
//				anagram�� ���
			}
			else {
				falseAnagram++;
//				anagram�� �ƴѰ��
			}
			i++;
//			�迭�� ���ڸ� �÷���
		}
		
		
	}
}
