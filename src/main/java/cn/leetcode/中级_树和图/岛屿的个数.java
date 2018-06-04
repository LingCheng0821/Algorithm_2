package cn.leetcode.中级_树和图;

import org.junit.Test;

/**
 * Created by Laura on 2018/5/29.
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 示 例 1:
 * 输入:
 *      11110
 *      11010
 *      11000
 *      00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 *      11000
 *      11000
 *      00100
 *      00011
 * 输出: 3
 */
public class 岛屿的个数 {
    @Test
    public void test(){
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        System.out.println(numIslands(grid));
    }


    public int numIslands(char[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1)
            return 0;

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    change(grid, i, j);
                }
            }
        }
        return num;
    }

    // 每遇到'1'后, 开始向四个方向 递归搜索. 搜到后变为'0',
    // 因为相邻的属于一个island. 然后开始继续找下一个'1'.
    public void change(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return;
        if (grid[i][j] != '1')  return;

        // 修改为'0'
        grid[i][j] = '0';
        change(grid, i - 1, j);   // 修改左边的
        change(grid, i + 1, j);   // 修改右边的
        change(grid, i, j - 1);   // 修改上边的
        change(grid, i, j + 1);   // 修改下边的
    }
}
