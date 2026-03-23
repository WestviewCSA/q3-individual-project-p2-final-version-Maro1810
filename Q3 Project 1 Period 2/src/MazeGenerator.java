import java.util.*;
public class MazeGenerator {
   static int rows = 20; // 你可以改回 200，为了演示先设为 40
   static int cols = 20;
   static char[][] maze = new char[rows][cols];
   static Random rand = new Random();
   public static void main(String[] args) {
       // 1. 初始化：全填充为墙
       for (int r = 0; r < rows; r++) {
           Arrays.fill(maze[r], '@');
       }
       // 2. 使用 DFS 算法生成一个基础的连通迷宫（确保全图可达）
       generateMaze(1, 1);
       // 3. 随机打通额外的墙壁（创造多条路径和环路）
       // 这里的 0.2 代表打掉 20% 的墙，你可以根据需要调整
       for (int r = 1; r < rows - 1; r++) {
           for (int c = 1; c < cols - 1; c++) {
               if (maze[r][c] == '@' && rand.nextDouble() < 0.2) {
                   maze[r][c] = '.';
               }
           }
       }
       // 4. 设置起点和终点
       maze[0][0] = 'W';
       maze[0][1] = '.'; // 确保起点不被堵死
       maze[1][0] = '.';
      
       maze[rows - 1][cols - 1] = '$';
       maze[rows - 1][cols - 2] = '.'; // 确保终点不被堵死
       maze[rows - 2][cols - 1] = '.';
       maze[rows - 2][cols - 2] = '.';
       maze[rows - 2][cols - 3] = '.';
       maze[rows - 3][cols - 2] = '.';
       // 5. 打印地图
       System.out.println(rows + " " + cols + " 1");
       for (int x = 0; x < rows; x++) {
           System.out.println(new String(maze[x]));
       }
   }
   // 递归深度优先遍历，生成连通骨架
   static void generateMaze(int r, int c) {
       maze[r][c] = '.';
      
       // 定义四个方向（上下左右），并随机打乱顺序
       Integer[] dirs = {0, 1, 2, 3};
       List<Integer> dirList = Arrays.asList(dirs);
       Collections.shuffle(dirList);
       for (int dir : dirList) {
           // 每次走两格，保证中间留有一堵墙
           int nr = r, nc = c;
           int mr = r, mc = c; // 中间格
           if (dir == 0) { nr = r - 2; mr = r - 1; } // 上
           else if (dir == 1) { nr = r + 2; mr = r + 1; } // 下
           else if (dir == 2) { nc = c - 2; mc = c - 1; } // 左
           else if (dir == 3) { nc = c + 2; mc = c + 1; } // 右
           if (nr > 0 && nr < rows - 1 && nc > 0 && nc < cols - 1 && maze[nr][nc] == '@') {
               maze[mr][mc] = '.';
               generateMaze(nr, nc);
           }
       }
   }
}

