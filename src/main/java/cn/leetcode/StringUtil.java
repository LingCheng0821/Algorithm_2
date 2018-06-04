package cn.leetcode;

import cn.leetcode.中级_链表.两数相加.*;

import java.util.List;

/**
 * Created by Laura on 2018/5/25.
 */
public class StringUtil<T> {


    public void print(List<List<T>> res){
        System.out.println("[ ");
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[ ");
            List<T> var = res.get(i);
            for (int j = 0; j < var.size(); j++) {
                System.out.print(var.get(j) + " ");
            }
            System.out.println(" ]");
        }
        System.out.println(" ]");
    }


    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ]");
        }
    }

    public static void print(ListNode node){
        System.out.print("{ ");

        while(node != null){
            System.out.print(node.getVal() + " ");
            node = node.getNext();
        }
        System.out.print("} ");
    }

}
