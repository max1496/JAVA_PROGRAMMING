package MUD����;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GameMap {
    private int[] mapSize;
//    �� ��ü ������
    private int[] playPosition;
//    �÷��̾� ��ġ
    private int[] startPosition;
//    ���� ��ġ
    private char[][] map;
//    2���� �迭 ��
//    ���� �� ������
    public GameMap(String mapFilePath) {
        map = new char[100][100];
//        ���� �˳��ϰ� 100*100����
        playPosition = new int[2];
//        ��� �� �迭�� ��Ÿ��
        startPosition = new int[2];
//      ��� �� �迭�� ��Ÿ��
        mapSize = new int[2];
//      ��� �� �迭�� ��Ÿ��

        try{
            //���� ��ü ����
            File file = new File(mapFilePath);
            //�Է� ��Ʈ�� ����
            FileReader file_reader = new FileReader(file);
            int cur = 0;
//            �ϳ��� ���� ����
            int row = 0;
//            ��
            int col = 0;
//            ��

            while((cur = file_reader.read()) != -1) {
//            	���� ���ҋ����� ����
                map[row][col] = (char) cur;
//                �� ����
                if (cur == 'p') {
//                	���� ������ ������ġ�϶�
                    playPosition[0] = row;
//                    �÷��̾� ������ ��
                    playPosition[1] = col;
//                  �÷��̾� ������ ��
                    startPosition[0] = row;
//                  ���� ������ ��
                    startPosition[1] = col;
//                  ���� ������ ��
                }
                col++;
                if (cur == '\n') {
//                	�ٹٲ��� ���� ��
                    row++;
                    col = 0;
                }
            }
            mapSize[0] = row + 1;
//          �� ������ ��
            mapSize[1] = col;
//          �� ������ ��
            file_reader.close();
//            �׸� ����
        }catch (FileNotFoundException e) {
//        	�о�� �� ���� ���
            e.getStackTrace();
        }catch(IOException e){
//        	������ ���
            e.getStackTrace();
        }
    }
    public int[] getMapSize(){
    	return mapSize;
    }
//    �÷��̾� ������ ��ȯ �Լ�
    public int[] getPlayerPosition() {
        return playPosition;
    }
//    �� ���� ��ȯ �Լ�
    public char[][] getMap() {
        return map;
    }
//    �����ϼ� �ִ��� ������ üũ
    public boolean isValidMove(int nextRow, int nextCol) {
//        ���� ��� ���
        if (nextRow < 0 || nextRow >= mapSize[0] || nextCol < 0 || nextCol >= mapSize[1]) {
            return false;
        }
//        ���� ���
        if (map[nextRow][nextCol] == '`') {
            return false;
        }
        return true;
    }
//    direction�� ��,��,��,��
    public int move(char direction) {
//    	�̵� �Լ�

        int nextRow = playPosition[0];
        int nextCol = playPosition[1];
        if (direction == '��') {
            nextCol++;
        } else if (direction == '��') {
            nextCol--;
        } else if (direction == '��') {
            nextRow++;
        } else if (direction == '��') {
            nextRow--;
        } else {
            return -1;
        }
//        �����ϼ� �ִ��� üũ
        if (isValidMove(nextRow, nextCol)) {
            int num = 0;
//            ������ 1~4 �����̸� 5��ȯ
            if (map[nextRow][nextCol] == '1' || map[nextRow][nextCol] == '2' || map[nextRow][nextCol] == '3' |map[nextRow][nextCol] == '4') {
//               ���� ������ ���
            	num = Character.getNumericValue(map[nextRow][nextCol]);
//                �ɸ��͸� ��Ƽ����
            } else if (map[nextRow][nextCol] == 'T') {
//            	���� ������ ���
                num = 5;
            }
            map[playPosition[0]][playPosition[1]] = ' ';
//            ������ �ִ��ڸ�
            map[startPosition[0]][startPosition[1]]='s';
//            ���� ���� ǥ��
            playPosition[0] = nextRow;
            playPosition[1] = nextCol;
            map[nextRow][nextCol] = 'p';
//            ���ο� �÷��̾� ��ġ
            return num;
        }
        return -1;
    }
    public boolean[] possibleDirection() {
//    	�� ������ üũ
    	boolean[] movable= new boolean[4];
//    	�� �� �ִ� ������ true, �� �� ���� ������ false
//    	0�� ��, 1�� ��, 2�� �� 3�� ��
    	int[] dx= {0,0,1,-1};
    	int[] dy= {1,-1,0,0};
//    	���������� dx,dy�� ����
    	for(int i=0;i<4;i++) {
//    		�������� ���⵿��
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
    	String[] directions = {"��", "��","��","��"};
    	boolean comma = false;
    	System.out.print("�ȳ�> �̵��� ������ �Է��ϼ���. (");
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
//    	�� ��� �Լ�
        System.out.println("���� ȭ��");
        System.out.println("o-----------------------------o");
        for(int row = 0; row < mapSize[0]; row++) {
//        	�ʻ����� �����
            System.out.print("|");
            for(int col = 0; col < mapSize[1]; col++) {
//            	�ʻ����� ������
                System.out.print(map[row][col]);
//                �о��� �� ���
            }
            System.out.print("|\n");
        }
        System.out.println("o-----------------------------o");
    }
}
