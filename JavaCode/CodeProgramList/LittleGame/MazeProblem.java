

public class MazeProblem {

	public static void main(String[] args) {

		int[][] mazeMap = new int[8][7];
		for (int i = 0; i < mazeMap.length; i++) {
			mazeMap[i][0] = 1;
			mazeMap[i][6] = 1;
		}
		for (int i = 0; i < mazeMap[0].length; i++) {
			mazeMap[0][i] = 1;
			mazeMap[7][i] = 1;
		}
		mazeMap[3][1] = 1;
		mazeMap[3][2] = 1;
		Maze maze = new Maze();
		maze.findWay(mazeMap, 1, 1);
		for (int i = 0; i < mazeMap.length; i++) {
			for (int j = 0; j < mazeMap[i].length; j++) {
				System.out.print(mazeMap[i][j]);
			}
			System.out.println();
		}
	}
}


class Maze {

	public boolean findWay(int[][] mazeMap, int rowNow, int colNow) {
		if (mazeMap[6][5] == 2) {
			return true;
		} else {
			if (mazeMap[rowNow][colNow] == 0) {
				mazeMap[rowNow][colNow] = 2;
				if (findWay(mazeMap, rowNow + 1, colNow)) {
					return true;
				} else if (findWay(mazeMap, rowNow, colNow + 1)) {
					return true;
				} else if (findWay(mazeMap, rowNow - 1, colNow)) {
					return true;
				} else if (findWay(mazeMap, rowNow - 1, colNow - 1)) {
					return true;
				} else {
					mazeMap[rowNow][colNow] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}
}