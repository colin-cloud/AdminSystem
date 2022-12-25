


public class HanRomTower {

	public static void main(String[] args) {

        Tower tower = new Tower();
        tower.game(5, 'A', 'B', 'C');
    }
}

class Tower {

    //实现汉罗塔
    //将a中的罗盘放置c中，期间大盘不能放在小盘上方
    public void game(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println(a + "- >" + c);
        } else {
            //现将a中最后的一个盘子也就是最大的盘放置c中
            //将a中 n - 1 个盘子通过c盘放到b盘中
            game(n - 1, a, c, b);
            System.out.println(a + "- >" + c);
            //在将b盘中的最后一个盘子放到c盘中，通过a
            game(n - 1, b, a, c);
          }
    }
}