package assign;

import java.util.Scanner;
// 인풋을 위한 스캐너
public class Anagram {
	public static int[] counter(String s) {
//		스트링의 알파벳을 세는 함수
		int [] counterArray = new int[26];
//		알파벳 수에 맞게 배열 형성
		for(int i=0;i<s.length();i++) {
			int index = s.charAt(i)-'a';
//			a를 빼서 숫자를 저장
			counterArray[index]++;
//			알파벳 순서에 따라 해당되면 ++
		}
		return counterArray;
	}
	public boolean anagram(String first, String second) {
//		anagram을 판단하는 함수
		int[] firstCounter = counter(first);
		int[] secondCounter =counter(second);
//		두 인풋에 counter함수 실행해서 저장
		int[] sumArray = new int[26];
		boolean isAnagram = true;
//		isAnagram변수를 true로 초기화
		
	
		for(char c = 'a';c<='z';c++) {
			int i = c-'a';
			sumArray[i] = firstCounter[i] + secondCounter[i];
//			26개의 알파벳에 대해 반복문으로 sumArray에 알파벳 개수 저장
			System.out.print(c+ " = " + sumArray[i] + " ");
			if(firstCounter[i] != secondCounter[i]) {
				isAnagram=false;
			}
//			anagram판별
			
		}
		System.out.println();
		return isAnagram;
	}
}
