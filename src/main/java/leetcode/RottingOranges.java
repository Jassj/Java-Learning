package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 示例 1：
 *
 * 2 1 1   2 2 1   2 2 2   2 2 2   2 2 2
 * 1 1 0   2 1 0   2 2 0   2 2 0   2 2 0
 * 0 1 1   0 1 1   0 1 1   0 2 1   0 2 2
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 * 2 1 1   2 2 1   2 2 2   2 2 2   2 2 2
 * 0 1 1   0 1 1   0 2 1   0 2 2   0 2 2
 * 1 0 1   1 0 1   1 0 1   1 0 1   1 0 2
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 * 提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * @author yuanjie 2020/03/04 16:00
 */
public class RottingOranges {

    /**
     * 为什么使用BFS： 腐烂橘子每次可以腐烂上下左右四个节点橘子，每个节点又可以同时腐烂上下左右四个节点橘子，相当于按照层级往外扩张
     * ①.通过枚举法进行广度优先遍历：以所有被腐烂的橘子为起点，找出所有情况中橘子全都被腐烂的最小时间
     * ②.多源广度优先遍历：可以把所有腐烂的橘子看做同一起始层，后续每一层为腐烂橘子侵蚀的下一层
     */
    private static int orangesRotting(int[][] grid) {
        return multiSourceBFS(grid);
    }

    private static int multiSourceBFS(int[][] grid) {
        int lenX = grid.length;
        int lenY = grid[0].length;
        int freshOrangeCount = 0; // 初始新鲜橘子的数量
        int time = 0; // 计算腐烂所需时间
        Queue<int[]> queue = new LinkedList<>(); // 用于深度优先遍历的队列，初始将所有腐烂橘子放入队列中
        for(int i = 0; i < lenX; i++) {
            for(int j = 0; j < lenY; j++) {
                if(grid[i][j] == 1) {
                    freshOrangeCount++;
                } else if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(freshOrangeCount > 0 && !queue.isEmpty()) { // 当没有新鲜橘子或者无法腐烂时停止遍历
            int count = 0;
            int preRottedCount = queue.size(); // 每次深度遍历腐烂的橘子总数，每次遍历需要将上一次的腐烂橘子统一取出并向下侵蚀
            for(int k = 1; k <= preRottedCount; k++) {
                int[] rotInt = queue.poll();
                int x = rotInt[0];
                int y = rotInt[1];
                if(x - 1 >= 0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    queue.offer(new int[]{x-1, y});
                    freshOrangeCount--;
                }
                if(x + 1 < lenX && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    queue.offer(new int[]{x+1, y});
                    freshOrangeCount--;
                }
                if(y - 1 >= 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    queue.offer(new int[]{x, y-1});
                    freshOrangeCount--;
                }
                if(y + 1 < lenY && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    queue.offer(new int[]{x, y+1});
                    freshOrangeCount--;
                }
            }
            time++;
        }
        if(freshOrangeCount > 0) { // 腐烂结束后若仍存在新鲜橘子，则返回-1(存在无法腐烂的橘子)
            return -1;
        } else {
            return time;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
