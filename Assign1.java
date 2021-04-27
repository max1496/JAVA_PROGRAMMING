package assign;
import assign.Anagram;

import java.util.Scanner;
// Anagram.java을 임포트 시킴
public class Assign1 {
	public static void main(String[] args) {
//		메인함수
		Anagram a = new Anagram();
//		Anagram 객체 생성
		int trueAnagram = 0;
		int falseAnagram = 0;
		String[] wordsA = new String[1000];
		String[] wordsB = new String[1000];
//		anagram 비교될 두 변수를 배열로 선언
		boolean[] isAnagrams=new boolean[1000];
		int i = 0;
		while(true) {
//			quit입력시까지 수행하는 반복문
			System.out.println("단어를 두개 입력해주세요. quit을 입력시 프로그램 종료");
			Scanner scan = new Scanner(System.in);
			wordsA[i]=scan.next();
//			wordsA를 먼저 입력받음
			if(wordsA[i].equals("quit")) {
//			quit이 입력되면 break
				i--;
//				배열이 늘어났던 것을 다시 줄여줌
				System.out.println("Anagram쌍 목록");
				for(int j=0;j<=i;j++) {
					if(isAnagrams[j]) {
						System.out.println(wordsA[j]+ " " + wordsB[j]);
					}
				}
				System.out.println("Anagram쌍이 아닌 목록");
				for(int j=0;j<=i;j++) {
					if(isAnagrams[j]==false) {
						System.out.println(wordsA[j]+ " " + wordsB[j]);
					}
				}
//				anagram쌍이 거나 아닌 쌍을 출력
				System.out.println("Anagram쌍 개수: "+ trueAnagram+ " Anagram이 아닌 개수: "+ falseAnagram);
				System.out.println("quit입력으로 프로그램 종료");
				break;
//				trueAnagram과 falseAnagram변수를 사용해서 anagram이거나 아닌 쌍들의 개수 출력
			}
			wordsB[i]=scan.next();
//			wordsB를 입력받음
			isAnagrams[i] = a.anagram(wordsA[i], wordsB[i]);
//			wordsA와 anagram인지 판별해서 isAnagrams배열에 저장
			if(isAnagrams[i]) {
				trueAnagram++;
//				anagram인 경우
			}
			else {
				falseAnagram++;
//				anagram이 아닌경우
			}
			i++;
//			배열의 숫자를 늘려줌
		}
		
		
	}
}
