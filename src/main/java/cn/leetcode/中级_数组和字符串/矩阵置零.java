package cn.leetcode.中级_数组和字符串;

import cn.leetcode.StringUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Laura on 2018/5/24.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/76/
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 进阶:
 *      一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 *      一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 *      你能想出一个常数空间的解决方案吗？
 */
public class 矩阵置零 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);

        StringUtil.print(matrix);
//        for (int i = 0; i < matrix.length; i++) {
//            System.out.print("[ ");
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println(" ]");
//        }
    }
    public static void setZeroes(int[][] matrix) {

        boolean firstRowHasZero = false;
        boolean thisRowHasZero = false;
        if(matrix == null || matrix.length == 0) return;

        int colSize = matrix.length;
        int rowSize = matrix[0].length;


        for (int j = 0; j < rowSize; j++) {
            if(matrix[0][j] == 0){
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 1; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if(matrix[i][j] == 0){   //如果这一行有0，将第一行的这列记为0
                    matrix[0][j]=0;
                    thisRowHasZero = true;
                }
            }
            if(thisRowHasZero){  //扫描完一行，如果有0，整行置为0
                for (int j = 0; j < rowSize; j++) {
                    matrix[i][j] = 0;
                }
                thisRowHasZero = false;
            }
        }

        for (int j = 0; j < rowSize; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < colSize; i++) {
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRowHasZero){
            for (int j = 0; j < rowSize; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
