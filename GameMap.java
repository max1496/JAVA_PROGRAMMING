package MUD게임;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GameMap {
    private int[] mapSize;
//    맵 전체 사이즈
    private int[] playPosition;
//    플레이어 위치
    private int[] startPosition;
//    시작 위치
    private char[][] map;
//    2차원 배열 맵
//    게임 맵 생성자
    public GameMap(String mapFilePath) {
        map = new char[100][100];
//        맵을 넉넉하게 100*100으로
        playPosition = new int[2];
//        행과 열 배열로 나타냄
        startPosition = new int[2];
//      행과 열 배열로 나타냄
        mapSize = new int[2];
//      행과 열 배열로 나타냄

        try{
            //파일 객체 생성
            File file = new File(mapFilePath);
            //입력 스트림 생성
            FileReader file_reader = new FileReader(file);
            int cur = 0;
//            하나씩 읽을 변수
            int row = 0;
//            행
            int col = 0;
//            열

            while((cur = file_reader.read()) != -1) {
//            	읽지 못할떄까지 읽음
                map[row][col] = (char) cur;
//                맵 저장
                if (cur == 'p') {
//                	읽은 지점임 시작위치일때
                    playPosition[0] = row;
//                    플레이어 포지션 행
                    playPosition[1] = col;
//                  플레이어 포지션 열
                    startPosition[0] = row;
//                  시작 포지션 행
                    startPosition[1] = col;
//                  시작 포지션 열
                }
                col++;
                if (cur == '\n') {
//                	줄바꿈을 읽을 때
                    row++;
                    col = 0;
                }
            }
            mapSize[0] = row + 1;
//          맵 사이즈 행
            mapSize[1] = col;
//          맵 사이즈 열
            file_reader.close();
//            그만 읽음
        }catch (FileNotFoundException e) {
//        	읽어올 수 없는 경우
            e.getStackTrace();
        }catch(IOException e){
//        	오류인 경우
            e.getStackTrace();
        }
    }
    public int[] getMapSize(){
    	return mapSize;
    }
//    플레이어 포지션 반환 함수
    public int[] getPlayerPosition() {
        return playPosition;
    }
//    맵 정보 반환 함수
    public char[][] getMap() {
        return map;
    }
//    움직일수 있는지 없는지 체크
    public boolean isValidMove(int nextRow, int nextCol) {
//        맵을 벗어난 경우
        if (nextRow < 0 || nextRow >= mapSize[0] || nextCol < 0 || nextCol >= mapSize[1]) {
            return false;
        }
//        벽인 경우
        if (map[nextRow][nextCol] == '`') {
            return false;
        }
        return true;
    }
//    direction은 동,서,남,북
    public int move(char direction) {
//    	이동 함수

        int nextRow = playPosition[0];
        int nextCol = playPosition[1];
        if (direction == '동') {
            nextCol++;
        } else if (direction == '서') {
            nextCol--;
        } else if (direction == '남') {
            nextRow++;
        } else if (direction == '북') {
            nextRow--;
        } else {
            return -1;
        }
//        움직일수 있는지 체크
        if (isValidMove(nextRow, nextCol)) {
            int num = 0;
//            보스면 1~4 보물이면 5반환
            if (map[nextRow][nextCol] == '1' || map[nextRow][nextCol] == '2' || map[nextRow][nextCol] == '3' |map[nextRow][nextCol] == '4') {
//               보스 만났을 경우
            	num = Character.getNumericValue(map[nextRow][nextCol]);
//                케릭터를 인티저로
            } else if (map[nextRow][nextCol] == 'T') {
//            	보물 만났을 경우
                num = 5;
            }
            map[playPosition[0]][playPosition[1]] = ' ';
//            이전에 있던자리
            map[startPosition[0]][startPosition[1]]='s';
//            시작 지점 표시
            playPosition[0] = nextRow;
            playPosition[1] = nextCol;
            map[nextRow][nextCol] = 'p';
//            새로운 플레이어 위치
            return num;
        }
        return -1;
    }
    public boolean[] possibleDirection() {
//    	네 방향을 체크
    	boolean[] movable= new boolean[4];
//    	갈 수 있는 방향은 true, 갈 수 없는 방향은 false
//    	0은 동, 1은 서, 2는 남 3은 북
    	int[] dx= {0,0,1,-1};
    	int[] dy= {1,-1,0,0};
//    	동서남북을 dx,dy에 저장
    	for(int i=0;i<4;i++) {
//    		동서남북 방향동안
    		if(isValidMove(playPosition[0]+dx[i],playPosition[1]+dy[i])) {
    			movable[i]=true;
    		}
    		else {
    			movable[i]=false;
    		}
    	}
    	return movable;
    }
    
    public void printPossibleDirection() {
    	boolean[] movable =possibleDirection();
    	String[] directions = {"동", "서","남","북"};
    	boolean comma = false;
    	System.out.print("안내> 이동할 방향을 입력하세요. (");
    	for(int i =0;i<4;i++) {
    		if (movable[i]==true) {
    			if(comma == false) {
    				System.out.print(directions[i]);
    				comma = true;
    				} 
    			else {
    				System.out.print(", "+ directions[i]);
    				
    			}
    		}
    	}
    	System.out.println(")");
    	if(movable[3]==true) {
    		System.out.println(" |");
    	}
    	if(movable[1]==true) {
    		System.out.print("-p");
    	}
    	else {
    		System.out.print(" p");
    	}
    	if(movable[0]==true) {
    		System.out.println("-"); 
    	}
    	else {
    		System.out.println(" "); 
    	}
    	if (movable[2]==true) {
    		System.out.println(" |");
    	}
    }
    
    public void printMap() {
//    	맵 출력 함수
        System.out.println("게임 화면");
        System.out.println("o-----------------------------o");
        for(int row = 0; row < mapSize[0]; row++) {
//        	맵사이즈 행까지
            System.out.print("|");
            for(int col = 0; col < mapSize[1]; col++) {
//            	맵사이즈 열까지
                System.out.print(map[row][col]);
//                읽었던 맵 출력
            }
            System.out.print("|\n");
        }
        System.out.println("o-----------------------------o");
    }
}
