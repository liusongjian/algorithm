package graph;

/**
 * 广度优先搜索（Breadth First Search，简称 BFS）
 */
public class BFS {
    // 地图的行
    int r;
    // 地图的列
    int c;
    // 目标点x
    int targetX;
    // 目标点y
    int targetY;
    // 地图
    int[][] data;
    // 路径标记
    boolean[][] mark;
    // 最短路径
//    boolean[][] step;
    // 方向
    int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    // 最短路径
    int minStep = Integer.MAX_VALUE;

    public BFS(int r, int c, int[][] data, int targetX, int targetY) {
        this.r = r;
        this.c = c;
        this.targetX = targetX;
        this.targetY = targetY;
        this.data = data;
        mark = new boolean[c][r];
        mark[targetX][targetY] = false;
//        step = new boolean[c][r];
    }

    /**
     * 0 0 1 0
     * 0 0 0 0
     * 0 0 1 0
     * 0 1 0 0
     * 0 0 0 1
     * 障碍(2,0),(2,2),(1,3)，(3,4)
     * 起始(0,0)
     * 目标(2,3)
     */
    public static void main(String[] args) {
        int[][] data ={{0,0,0,0,0},{0,0,0,1,0},{1,0,1,0,0},{0,0,0,0,1}};
        BFS bfs = new BFS(5, 4, data, 2, 3);

        bfs.bfs(0,0,0);
        if (bfs.minStep == Integer.MAX_VALUE){
            System.out.println("未找到路径");
        }else {
            System.out.println("最短路径" + bfs.minStep);
        }
    }

    /**
     * 寻找最短路径 -> 广度优先搜索
     * 待优化：通过 mark[][] 记录最佳路径方案
     * @param x 当前X坐标点
     * @param y 当前Y坐标点
     * @param step  步数
     */
    public void bfs(int x,int y,int step){
        // 检查当前坐标是否为目标位置
        // 如果找到目标位置 比较步数是否小于当前最短路径，CAS
        if(targetX == x && targetY == y){
            if(step < minStep){
                minStep = step;
            }
            return;
        }
        // 如果不是开始遍历附近可移动位置，前进并步数加一
        for (int[] ints : direction) {
            // 判断边界
            int nextX = x + ints[0];
            int nextY = y + ints[1];
            if (nextX >= 0 && nextX < c && nextY >= 0 && nextY < r) {
                if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {
                    mark[nextX][nextY] = true;
                    bfs(nextX, nextY, step + 1);
                    mark[nextX][nextY] = false;
                }
            }
        }
    }
}
