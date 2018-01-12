package com.fang.backtracking;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class RobotAct {
    public static void main(String[] args) {
        RobotAct ra = new RobotAct();
        System.out.println(ra.movingCount(6,6,6));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols]; //记录是否已经走过
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols,
                                int row, int col, boolean[] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        int i = row * cols + col;
        if (visited[i] || !checkSum(threshold, row, col)) return 0;
        visited[i] = true;
//        System.out.println(row + "---"+ col);
        return 1 + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                + movingCountCore(threshold, rows, cols, row - 1, col, visited);
    }

    private boolean checkSum(int threshold, int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        if (sum > threshold) return false;
        return true;
    }
}
