

public class EightQueen {

	public static void main(String[] args) {

		
		char[][] map = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = '0';
			}
		}
		MyTools tools = new MyTools();
		tools.queenFindWay(map, 0);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class MyTools {
	
	public void changeNum(char[][] copyMap, int rowForQueen, int colForQueen) {
		
		for (int i = 0; i < copyMap[rowForQueen].length; i++) {
			if (i == colForQueen) {
				continue;
			} else {
				copyMap[rowForQueen][i] = '#';
			}
		}
	
		for (int i = 0; i < copyMap.length; i++) {
			if (i == rowForQueen) {
				continue;
			} else {
				copyMap[i][colForQueen] = '#';
			}
		}
		//对角线进行改变
		for (int i = 0; i < copyMap.length; i++) {
			for (int j = 0; j < copyMap[i].length; j++) {
				if ((i + j - rowForQueen - colForQueen) % 2 == 0 && i - rowForQueen == j - colForQueen
				|| i + j == rowForQueen + colForQueen) {
					if (i == rowForQueen && j == colForQueen) {
						continue;
					}
					copyMap[i][j] = '#';
				}
			}
		}
	}

	public boolean queenFindWay(char[][] map, int rowNow) {
		//先从第一行寻找可以放置皇后的位置
		//假设第一行第一个位置可以放置
		//拷贝一份map数组
		char[][] copyMap = new char[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < map[0].length; i++) {
			if (map[rowNow][i] == '0') {
				//记录拷贝的数组
				char[][] copyMapTwo = new char[copyMap.length][copyMap[0].length];
				for (int m = 0; m < copyMap.length; m++) {
					for (int j = 0; j < copyMap[m].length; j++) {
						copyMapTwo[m][j] = copyMap[m][j];
					}
				}
				copyMap[rowNow][i] = '*';
				//改变棋盘布局
				changeNum(copyMap, rowNow, i);
				if (rowNow + 1 <= 7) {
					if (queenFindWay(copyMap, rowNow + 1)) {
						map = copyMap;
						return true;
					} else {
						copyMap = copyMapTwo;
						continue;
					}
				}
				map = copyMap;
				return true;
			} else {
				//位置已经被占领或无法放置，无法在放置皇后，循环继续寻找合适的位置
				continue;
			}
		}
		return false;
	}
}	