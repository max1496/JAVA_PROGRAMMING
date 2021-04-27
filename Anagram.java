package assign;

import java.util.Scanner;
// ��ǲ�� ���� ��ĳ��
public class Anagram {
	public static int[] counter(String s) {
//		��Ʈ���� ���ĺ��� ���� �Լ�
		int [] counterArray = new int[26];
//		���ĺ� ���� �°� �迭 ����
		for(int i=0;i<s.length();i++) {
			int index = s.charAt(i)-'a';
//			a�� ���� ���ڸ� ����
			counterArray[index]++;
//			���ĺ� ������ ���� �ش�Ǹ� ++
		}
		return counterArray;
	}
	public boolean anagram(String first, String second) {
//		anagram�� �Ǵ��ϴ� �Լ�
		int[] firstCounter = counter(first);
		int[] secondCounter =counter(second);
//		�� ��ǲ�� counter�Լ� �����ؼ� ����
		int[] sumArray = new int[26];
		boolean isAnagram = true;
//		isAnagram������ true�� �ʱ�ȭ
		
	
		for(char c = 'a';c<='z';c++) {
			int i = c-'a';
			sumArray[i] = firstCounter[i] + secondCounter[i];
//			26���� ���ĺ��� ���� �ݺ������� sumArray�� ���ĺ� ���� ����
			System.out.print(c+ " = " + sumArray[i] + " ");
			if(firstCounter[i] != secondCounter[i]) {
				isAnagram=false;
			}
//			anagram�Ǻ�
			
		}
		System.out.println();
		return isAnagram;
	}
}
