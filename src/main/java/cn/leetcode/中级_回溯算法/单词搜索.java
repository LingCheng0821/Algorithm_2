package cn.leetcode.中级_回溯算法;

import org.junit.Test;

/**
 * Created by Laura on 2018/6/1.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/95/
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class 单词搜索 {
    @Test
    public void test(){
        char[][] board = new char[][] {{'a'}};
        String word = "a";
        System.out.println(exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length < 1 || board[0].length < 1)  return false;

        if(word == null || word.length() < 1)  return false;
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];   //标记深搜时当前字母是否判断过

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dfs(board,word,0,i,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        //index到达word最后，说明找到了符合的
        if(index == word.length())
            return true;
        else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if (visited[i][j] == true)  return false;
//
        //当前字母不符合条件
        if(word.charAt(index) != board[i][j])
            return false;

        //以上都不满足，说明当前字母符合条件，置为true，继续对当前单词的上下左右深搜
        visited[i][j] = true;
        boolean ret = dfs(board,word,index+1,i-1,j,visited) ||
                dfs(board,word,index+1,i+1,j,visited) ||
                dfs(board,word,index+1,i,j-1,visited) ||
                dfs(board,word,index+1,i,j+1,visited);
        //从board[i][j]点开始深搜完成后，visited要重置为false
        visited[i][j] = false;
        return ret;
    }


}
